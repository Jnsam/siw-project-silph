package it.uniroma3.silph.storage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.silph.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {
	public List<Foto> findByTitolo(String titolo);

	public List<Foto> findByTitoloAndIndirizzo(String titolo, String indirizzo);
}
