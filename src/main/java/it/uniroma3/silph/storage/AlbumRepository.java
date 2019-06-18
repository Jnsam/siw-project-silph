/**
 * 
 */
package it.uniroma3.silph.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.silph.model.Album;


public interface AlbumRepository extends JpaRepository<Album, Long> {

}
