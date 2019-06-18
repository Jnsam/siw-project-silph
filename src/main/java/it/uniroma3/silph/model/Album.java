package it.uniroma3.silph.model;

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
	private List<Foto> fotos;

	/**
	 * @param id
	 * @param titolo
	 * @param desc
	 * @param fotografo
	 * @param fotos
	 */
	public Album(long id, String titolo, String desc, Fotografo fotografo, List<Foto> fotos) {
		this.id = id;
		this.titolo = titolo;
		this.descrizione = desc;
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

	public String getDesc() {
		return descrizione;
	}

	public void setDesc(String desc) {
		this.descrizione = desc;
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

}
