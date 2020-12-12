package com.webapp.cv;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.mapping.ForeignKey;

@Entity
@Table(name = "certificazione")
public class Certificazione {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "idCertificazione", unique=true, nullable = false, columnDefinition = "int default 1")
  private int idCertificazione;
  
  
  @Column(name = "NomeCertificazione")
  private String nomecertificazione;

  @Column(name = "Settore")
  private String settore;

  @ManyToOne
  @JoinColumn(foreignKey = @javax.persistence.ForeignKey(name = "persona_idPersona"), name = "persona_idPersona")
  private Persona persona;



    
}