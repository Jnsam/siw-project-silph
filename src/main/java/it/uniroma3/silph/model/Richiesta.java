package it.uniroma3.silph.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Richiesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCreazione = new Date();
	
	private boolean accettato = false;
	
	/**Non serve piu
	@ManyToOne
	@JoinColumn(name = "users_id")
	private User user;
	**/
	
	@OneToMany
	@JoinColumn(name = "richiesta_id")
	private List<Foto> fotos = new LinkedList<Foto>();

	public Richiesta() {
	}

	public Richiesta(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}

	public Richiesta(long id, Date dataCreazione, List<Foto> fotos) {
		this.id = id;
		this.dataCreazione = dataCreazione;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
