package com.jpa_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.UtenteConfiguration;
import com.jpa_project.model.Utente;
import com.jpa_project.repository.UtenteDaoRepository;

@Service
public class UtenteService {

	@Autowired UtenteDaoRepository repo;
	;
	
	
	public void creaUtente() {
		 AnnotationConfigApplicationContext appConfig =
				 new AnnotationConfigApplicationContext(UtenteConfiguration.class);
		Utente u = (Utente) appConfig.getBean("nuovoUtente");
		inserisciUtente(u);
	}
	
	public void inserisciUtente(Utente u) {
		repo.save(u);
	}
	
	public Utente getUtenteById(Long id) {
		return repo.findById(id).get();
	}
}
