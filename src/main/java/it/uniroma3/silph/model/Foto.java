package it.uniroma3.silph.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Foto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String indirizzo;

	@Column(nullable = false)
	private String titolo;
	
	private String descrizione;

	@ManyToOne
	@JoinColumn(name="fotografo_id")
	private Fotografo fotografo;
	
	@ManyToOne
	@JoinColumn(name="album_id")
	private Album album;
	
	
	public Foto() {
		
	}

	public Foto(long id, String indirizzo, String titolo, String desc) {
		this.id = id;
		this.indirizzo = indirizzo;
		this.titolo = titolo;
		this.descrizione = desc;
	}

	public Foto(long id, String indirizzo, String titolo, String desc, Fotografo fotografo, Album album) {
		this.id = id;
		this.indirizzo = indirizzo;
		this.titolo = titolo;
		this.descrizione = desc;
		this.fotografo = fotografo;
		this.album = album;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foto other = (Foto) obj;
		if (id != other.id)
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
	
	

}
