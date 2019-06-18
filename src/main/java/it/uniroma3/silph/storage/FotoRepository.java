package it.uniroma3.silph.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.silph.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {

}
