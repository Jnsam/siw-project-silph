package it.uniroma3.silph;

import it.uniroma3.silph.model.Album;
import it.uniroma3.silph.model.Foto;
import it.uniroma3.silph.model.Fotografo;
import it.uniroma3.silph.model.User;
import it.uniroma3.silph.service.AlbumService;
import it.uniroma3.silph.service.FotoService;
import it.uniroma3.silph.service.FotografoService;
import it.uniroma3.silph.storage.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class DBPopulation implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FotoService fotoService;
    
    @Autowired
    private FotografoService fotografoService;
    
    @Autowired
    private AlbumService albumService;


    public void run(ApplicationArguments args) throws Exception {
        this.deleteAll();
        this.populateDB();
    }

    private void deleteAll() {
        System.out.println("Deleting all users from DB...");
        userRepository.deleteAll();
        System.out.println("Done");
    }

    private void populateDB() throws IOException, InterruptedException {

        System.out.println("Storing users...");

        User admin = new User(1L, "Mario", "Rossi", "mariorossi", null, "ADMIN");
        String adminPassword = new BCryptPasswordEncoder().encode("mrpass");
        admin.setPassword(adminPassword);
        admin = this.userRepository.save(admin);

        User guest = new User(2L, "Giuseppe", "Verdi", "giuseppeverdi", null, "ADMIN");
        String guestPassword = new BCryptPasswordEncoder().encode("gvpass");
        guest.setPassword(guestPassword);
        guest = this.userRepository.save(guest);
        
        System.out.println("Creating Foto...");

        Foto foto = new Foto(12345, "prova.jpeg", "Prova", "Foto di prova");
        foto = this.fotoService.save(foto);

        Foto foto1 = new Foto(12346, "1prova.jpeg", "Uno Prova", "Foto di prova uno");
        foto1 = this.fotoService.save(foto1);

        Foto foto2 = new Foto(12347, "2prova.jpeg", "Due Prova", "Foto di prova due");
        foto2 = this.fotoService.save(foto2);

        Foto foto3 = new Foto(12348, "3prova.jpeg", "Tre Prova", "Foto di prova tre");
        foto3 = this.fotoService.save(foto3);
        
        System.out.println("Creating Fotografo...");
        
        Fotografo fotografo = this.fotografoService.save(new Fotografo(1111, "Luca", "Bianchi"));
        Album album = this.albumService.save(new Album("Album1","Primo Album"));
        List<Foto> fotos = new LinkedList<Foto>();
        fotografo.addAlbum(album);
        
        Foto fototemp = fotoService.findByTitolo(foto.getTitolo()).get(0);
        fotografo.addFoto(fototemp);
        album.addFoto(fototemp);
        fototemp = this.fotoService.save(fototemp);
        album = this.albumService.save(album);
        
        album = this.albumService.save(new Album("Album2","Secondo Album"));
        fotografo.addAlbum(album);
        fototemp = fotoService.findByTitolo(foto1.getTitolo()).get(0);
        fotografo.addFoto(fototemp);
        album.addFoto(fototemp);
        fototemp = this.fotoService.save(fototemp);
        
        fototemp = fotoService.findByTitolo(foto3.getTitolo()).get(0);
        fotografo.addFoto(fototemp);
        album.addFoto(fototemp);
        fototemp = this.fotoService.save(fototemp);
        
        album = this.albumService.save(album);
        fotografo = this.fotografoService.save(fotografo);
        fotos = fotografoService.findByNomeAndCognome(fotografo.getNome(), fotografo.getCognome()).get(0).getFotos();
        System.out.println(fotos.size());

        fotografo = this.fotografoService.save(new Fotografo(2222, "Luigi", "Gialli"));
        fotos = new LinkedList<Foto>();
        fototemp = fotoService.findByTitolo(foto2.getTitolo()).get(0);
		fotografo.addFoto(fototemp);
        fototemp = this.fotoService.save(fototemp);
        fotografo = this.fotografoService.save(fotografo);
        fotos = fotografoService.findByNomeAndCognome(fotografo.getNome(), fotografo.getCognome()).get(0).getFotos();
        System.out.println(fotos.size());
        

        fotografo = new Fotografo(2222, "Giacomo", "Viola");
        fotografo = this.fotografoService.save(fotografo);
        
        System.out.println("Done.\n");
    }
}
