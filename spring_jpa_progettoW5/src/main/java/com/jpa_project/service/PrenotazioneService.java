package com.jpa_project.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.PrenotazioneConfiguration;
import com.jpa_project.configuration.UtenteConfiguration;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Utente;
import com.jpa_project.repository.PrenotazioneDaoRepository;


@Service
public class PrenotazioneService {


	@Autowired PrenotazioneDaoRepository repo;
	
	
	
	public void creaPrenotazione(Postazione post, LocalDate data, Utente u) {
		 AnnotationConfigApplicationContext appConfig =
				 new AnnotationConfigApplicationContext(PrenotazioneConfiguration.class);
		Prenotazione p = (Prenotazione) appConfig.getBean("nuovaPrenotazione");
		p.setData(data);
		p.setUtente(u);
		inserisciPrenotazione(p);
	}
	
	public void inserisciPrenotazione(Prenotazione p) {
		repo.save(p);
	}
	
	public void getPostazioneById(Long id) {
		repo.findById(id);
	}
}
