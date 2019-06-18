package it.uniroma3.silph.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.silph.model.Richiesta;

public interface RichiestaRepository extends JpaRepository<Richiesta, Long> {

}
