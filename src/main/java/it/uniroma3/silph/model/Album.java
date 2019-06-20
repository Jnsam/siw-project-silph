package it.uniroma3.silph.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String titolo;
	
	private String descrizione;
	
	@ManyToOne
	@JoinColumn(name="fotografo_id")
	private Fotografo fotografo;
	
	@OneToMany(mappedBy = "album")
	private List<Foto> fotos = new LinkedList<Foto>();

	public Album() {
	}
 
	public Album(String titolo, String descrizione) {
		this.titolo = titolo;
		this.descrizione = descrizione;
	}

	public Album(long id, String titolo, String descrizione, Fotografo fotografo, List<Foto> fotos) {
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.fotografo = fotografo;
		this.fotos = fotos;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	
	/**
	 * Aggiungi Foto
	 */
	public void addFoto(Foto foto) {
        fotos.add(foto);
        foto.setAlbum(this);
	}


}
