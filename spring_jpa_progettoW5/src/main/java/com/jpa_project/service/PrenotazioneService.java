package com.jpa_project.service;

import java.time.LocalDate;
import java.util.List;

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

	@Autowired
	PrenotazioneDaoRepository repo;

	public void creaPrenotazione(Postazione post, LocalDate data, Utente u) {

		List<Prenotazione> lista = cercaPrenotazioneLibera(data, post);
		if (lista.size() == 0) {
			AnnotationConfigApplicationContext appConfig = new AnnotationConfigApplicationContext(
					PrenotazioneConfiguration.class);
			Prenotazione p = (Prenotazione) appConfig.getBean("nuovaPrenotazione");
			p.setPostazionePrenotata(post);
			p.setDataPrenotazione(data);
			p.setDataScadenza(data.plusDays(1));
			p.setUtente(u);
			salvaPrenotazione(p);
			System.out.println("Prenotazione per l'edificio " + p.getPostazionePrenotata().getEdificio().getNome() + " accettata");
		} else {
			System.out.println("Postazione occupata per la data " + data);
		}
	}

	public void salvaPrenotazione(Prenotazione p) {
		repo.save(p);
		
	}

	public Prenotazione getPrenotazioneById(Long id) {
		return repo.findById(id).get();
	}

	public List<Prenotazione> cercaPrenotazioneLibera(LocalDate data, Postazione postazione) {
		return repo.checkPrenotazione(data, postazione);
	}
}
