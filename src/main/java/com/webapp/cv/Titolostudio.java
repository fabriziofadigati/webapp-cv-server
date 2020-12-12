package com.webapp.cv;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "titolostudio")
public class Titolostudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTitoloStudio", unique=true, nullable = false, columnDefinition = "int default 1")
    private int idTitoloStudio;
    
    
    @Column(name = "Titolo")
    private String titolo;
  
    @Column(name = "Tipologia")
    private String tipologia;

    @Column(name = "Istituto")
    private String istituto;

    @Column(name = "ViaIstituto")
    private String viaistituto;

    @Column(name = "ComuneIstituto")
    private String comuneistituto;

    @Column(name = "CAPIstituto")
    private String capistituto;

    @Column(name = "DataInizio")
    private Date datainizio;

    @Column(name = "DataFine")
    private Date datafine;

    @Column(name = "Voto")
    private int voto;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "titolopersona", joinColumns = { @JoinColumn(name = "titolostudio_idTitoloStudio") },
    inverseJoinColumns = { @JoinColumn(name = "persona_idPersona") })
    private Set<Persona> persone = new HashSet<>();
}