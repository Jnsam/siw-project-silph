package it.uniroma3.silph.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fotografo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;
	
	@OneToMany(mappedBy = "fotografo")
	private List<Foto> fotos = new LinkedList<Foto>();

	@OneToMany(mappedBy = "fotografo")
	private List<Album> albums = new LinkedList<Album>();

	public Fotografo() {
	}

	public Fotografo(long id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Fotografo(long id, String nome, String cognome, List<Foto> fotos, List<Album> albums) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.fotos = fotos;
		this.albums = albums;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the fotos
	 */
	public List<Foto> getFotos() {
		return fotos;
	}

	/**
	 * @param fotos the fotos to set
	 */
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	/**
	 * Aggiungi Foto
	 */
	public void addFoto(Foto foto) {
        fotos.add(foto);
        foto.setFotografo(this);
	}

	/**
	 * @return the albums
	 */
	public List<Album> getAlbums() {
		return albums;
	}

	/**
	 * @param albums the albums to set
	 */
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	/**
	 * Aggiungi Foto
	 */
	public void addAlbum(Album album) {
        albums.add(album);
        album.setFotografo(this);
	}

}
