package it.uniroma3.silph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.silph.model.Album;
import it.uniroma3.silph.storage.AlbumRepository;

@Transactional
@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository; 
	
	public Album save(Album album) {
		return this.albumRepository.save(album);
	}
	
	public List<Album> findAll() {
		return (List<Album>) this.albumRepository.findAll();
	}
	
	public Album findById(Long id) {
		Optional<Album> album = this.albumRepository.findById(id);
		if (album.isPresent()) 
			return album.get();
		else
			return null;
	}
	
	public boolean alreadyExists(Album album) {
		List<Album> albums = this.albumRepository.findByTitolo(album.getTitolo());
		if (albums.size() > 0)
			return true;
		else 
			return false;
	}	
	
}
