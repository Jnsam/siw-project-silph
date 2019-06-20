package it.uniroma3.silph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.silph.model.Fotografo;
import it.uniroma3.silph.storage.FotografoRepository;

@Transactional
@Service
public class FotografoService {
	
	@Autowired
	private FotografoRepository fotografoRepository; 
	
	public Fotografo save(Fotografo fotografo) {
		return this.fotografoRepository.save(fotografo);
	}
	
	public List<Fotografo> findAll() {
		return (List<Fotografo>) this.fotografoRepository.findAll();
	}
	
	public Fotografo findById(Long id) {
		Optional<Fotografo> fotografo = this.fotografoRepository.findById(id);
		if (fotografo.isPresent()) 
			return fotografo.get();
		else
			return null;
	}
	
	public List<Fotografo> findByNomeAndCognome(String nome, String cognome){
		return this.fotografoRepository.findByNomeAndCognome(nome, cognome);
	}
	
	public boolean alreadyExists(Fotografo fotografo) {
		List<Fotografo> fotografi = this.fotografoRepository.findByNomeAndCognome(fotografo.getNome(), fotografo.getCognome());
		if (fotografi.size() > 0)
			return true;
		else 
			return false;
	}	

}
