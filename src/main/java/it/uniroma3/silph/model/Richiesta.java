package it.uniroma3.silph.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Richiesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCreazione = new Date();
	
	private boolean accettato = false;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
	private User user;
	
	@OneToMany
	@JoinColumn(name = "richiesta_id")
	private List<Foto> fotos;

	public Richiesta() {
	}

	public Richiesta(long id, Date dataCreazione, User user, List<Foto> fotos) {
		this.id = id;
		this.dataCreazione = dataCreazione;
		this.user = user;
		this.fotos = fotos;
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
	 * @return the dataCreazione
	 */
	public java.util.Date getDataCreazione() {
		return dataCreazione;
	}

	/**
	 * @param dataCreazione the dataCreazione to set
	 */
	public void setDataCreazione(java.util.Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	/**
	 * @return the accettato
	 */
	public boolean isAccettato() {
		return accettato;
	}

	/**
	 * @param accettato the accettato to set
	 */
	public void setAccettato(boolean accettato) {
		this.accettato = accettato;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	}

}
