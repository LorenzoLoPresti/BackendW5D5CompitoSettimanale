package com.jpa_project.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postazioni")
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descrizione;
	private Tipo tipo;
	private int maxOccupanti;
	@OneToOne
	private Edificio edificio;
	@ManyToOne
	private Utente utentePrenotato;
	
	public Postazione(String descrizione, Tipo tipo, Edificio edificio) {
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.edificio = edificio;
	}
}
