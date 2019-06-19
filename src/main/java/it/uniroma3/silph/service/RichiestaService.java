package it.uniroma3.silph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.silph.model.Richiesta;
import it.uniroma3.silph.storage.RichiestaRepository;

@Transactional
@Service
public class RichiestaService {
	@Autowired
	private RichiestaRepository richiestaRepository; 
	
	public Richiesta save(Richiesta richiesta) {
		return this.richiestaRepository.save(richiesta);
	}
	
	public List<Richiesta> findAll() {
		return (List<Richiesta>) this.richiestaRepository.findAll();
	}
	
	public Richiesta findById(Long id) {
		Optional<Richiesta> richiesta = this.richiestaRepository.findById(id);
		if (richiesta.isPresent()) 
			return richiesta.get();
		else
			return null;
	}
}
