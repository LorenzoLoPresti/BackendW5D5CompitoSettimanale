package com.jpa_project.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.model.Utente;
import com.jpa_project.service.EdificioService;
import com.jpa_project.service.PostazioneService;
import com.jpa_project.service.PrenotazioneService;
import com.jpa_project.service.UtenteService;

@Component
public class AppRunner implements CommandLineRunner{
	
	@Autowired private PostazioneService postazioneService;
	@Autowired private EdificioService edificioService;
	@Autowired private UtenteService utenteService;
	@Autowired private PrenotazioneService prenotazioneService;
	@Autowired private AnnotationConfigApplicationContext appContext;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run...");
//		Edificio e = new Edificio();
		
//		Postazione p = new Postazione("Ciao", Tipo.OPENSPACE, e);

	//	Edificio e1 = (Edificio) appContext.getBean("nuovoEdificio");
		
	//	edificioService.inserisciEdificio(e1);
		Edificio e2 = edificioService.cercaEdificio(1l);
	//	System.out.println(e1);
		postazioneService.creaPostazione("Milano", e2, Tipo.PRIVATO);
		
		//utenteService.creaUtente();
		Utente u1 = utenteService.getUtenteById(1l);
		
		System.out.println(u1);
		
		Postazione post = postazioneService.getPostazioneById(1l);
	//	prenotazioneService.creaPrenotazione(post, LocalDate.now(), u1);
		

	}

}
