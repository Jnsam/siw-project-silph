package it.uniroma3.silph;

import it.uniroma3.silph.model.Foto;
import it.uniroma3.silph.model.User;
import it.uniroma3.silph.storage.FotoRepository;
import it.uniroma3.silph.storage.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class DBPopulation implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private FotoRepository fotoRepository;


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

        User guest = new User(2L, "Giuseppe", "Verdi", "giuseppeverdi", null, "GUEST");
        String guestPassword = new BCryptPasswordEncoder().encode("gvpass");
        guest.setPassword(guestPassword);
        guest = this.userRepository.save(guest);
        
        System.out.println("Creating Foto...");

        Foto foto = new Foto(12345, "prova.jpeg", "Prova", "Foto di prova");
        foto = this.fotoRepository.save(foto);

        Foto foto1 = new Foto(12346, "1prova.jpeg", "Uno Prova", "Foto di prova uno");
        foto1 = this.fotoRepository.save(foto1);

        Foto foto2 = new Foto(12347, "2prova.jpeg", "Due Prova", "Foto di prova due");
        foto2 = this.fotoRepository.save(foto2);

        Foto foto3 = new Foto(12348, "3prova.jpeg", "Tre Prova", "Foto di prova tre");
        foto3 = this.fotoRepository.save(foto3);

        System.out.println("Done.\n");
    }
}
