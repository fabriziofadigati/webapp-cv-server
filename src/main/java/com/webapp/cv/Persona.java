package com.webapp.cv;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;

@Entity
@Table(name = "persona")
public class Persona {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Basic(optional = false)
	  @Column(name = "idPersona", unique=true, nullable = false, columnDefinition = "int default 1")
	  private int idPersona;
	  
	  @Column(name = "Nome")
	  @Field
	  private String nome;

	  @Column(name = "Cognome")
	  @Field
	  private String cognome;
	  
	  @Column(name = "Via")
	  @Field
	  private String via;
	  
	  @Column(name = "ComuneResidenza")
	  @Field
	  private String comuneresidenza;
	  
	  @Column(name = "CAP")
	  @Field
	  private String cap;
	  
	  @Column(name = "Nazionalità")
	  @Field
	  private String nazionalita;
	  
	  @Column(name = "Sesso")
	  @Field
	  private String sesso;
	  
	  @Column(name = "DataNascita")
	  private Date datanascita;
	  
	  @Column(name = "Email")
	  @Field
	  private String email;
	  
	  @Column(name = "NumeroCellulare")
	  @Field
	  private String numerocellulare;

	  @Column(name = "CodiceFiscale")
	  @Field
	  private String codicefiscale;
	  
	  @Column(name = "AttualeRAL")
	  private float attualeral;
	  
	  @Column(name = "DesiderataRAL")
	  private float desiderataral;
	  
	  @Column(name = "AttualePartitaIVA")
	  @Field
	  private String attualepartitaiva;
	  
	  @Column(name = "DesiderataPartitaIVA")
	  @Field
	  private String desideratapartitaiva;
	  
	  @Column(name = "StatoOccupazionale")
	  private boolean statooccupazionale;
	  
	  @Column(name = "TermineOccupazione")
	  private Date termineoccupazione;
	  
	  @Column(name = "AllegatoCV")
	  private byte[] allegatocv;

	  @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "persona")
	  private Set<Certificazione> cert = new HashSet<>();

	  @ManyToMany(mappedBy = "persone")
      private Set<Titolostudio> titoli = new HashSet<>();
	  
	public void setCert(Set<Certificazione> certificazioni) {
		cert = certificazioni;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getComuneresidenza() {
		return comuneresidenza;
	}

	public void setComuneresidenza(String comuneresidenza) {
		this.comuneresidenza = comuneresidenza;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Date getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(Date datanascita) {
		this.datanascita = datanascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumerocellulare() {
		return numerocellulare;
	}

	public void setNumerocellulare(String numerocellulare) {
		this.numerocellulare = numerocellulare;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public float getAttualeral() {
		return attualeral;
	}

	public void setAttualeral(float attualeral) {
		this.attualeral = attualeral;
	}

	public float getDesiderataral() {
		return desiderataral;
	}

	public void setDesiderataral(float desiderataral) {
		this.desiderataral = desiderataral;
	}

	public String getAttualepartitaiva() {
		return attualepartitaiva;
	}

	public void setAttualepartitaiva(String attualepartitaiva) {
		this.attualepartitaiva = attualepartitaiva;
	}

	public String getDesideratapartitaiva() {
		return desideratapartitaiva;
	}

	public void setDesideratapartitaiva(String desideratapartitaiva) {
		this.desideratapartitaiva = desideratapartitaiva;
	}

	public boolean isStatooccupazionale() {
		return statooccupazionale;
	}

	public void setStatooccupazionale(boolean statooccupazionale) {
		this.statooccupazionale = statooccupazionale;
	}

	public Date getTermineoccupazione() {
		return termineoccupazione;
	}

	public void setTermineoccupazione(Date termineoccupazione) {
		this.termineoccupazione = termineoccupazione;
	}

	public byte[] getAllegatocv() {
		return allegatocv;
	}

	public void setAllegatocv(byte[] allegatocv) {
		this.allegatocv = allegatocv;
	}
	  
	  
}
	  
