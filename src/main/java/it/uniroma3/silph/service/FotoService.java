package it.uniroma3.silph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.silph.model.Foto;
import it.uniroma3.silph.storage.FotoRepository;

@Transactional
@Service
public class FotoService {
	@Autowired
	private FotoRepository fotoRepository; 
	
	public Foto save(Foto foto) {
		return this.fotoRepository.save(foto);
	}
	
	public List<Foto> findAll() {
		return (List<Foto>) this.fotoRepository.findAll();
	}
	
	public Foto findById(Long id) {
		Optional<Foto> foto = this.fotoRepository.findById(id);
		if (foto.isPresent()) 
			return foto.get();
		else
			return null;
	}
}
