package it.uniroma3.silph.storage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.silph.model.Fotografo;

public interface FotografoRepository extends JpaRepository<Fotografo, Long> {
	public List<Fotografo> findByNomeAndCognome(String nome, String cognome);
}
