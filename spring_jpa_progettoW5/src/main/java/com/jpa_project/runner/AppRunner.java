package com.jpa_project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.service.EdificioService;
import com.jpa_project.service.PostazioneService;

@Component
public class AppRunner implements CommandLineRunner{
	
	@Autowired private PostazioneService postazioneService;
	@Autowired private EdificioService edificioService;
	@Autowired private AnnotationConfigApplicationContext appContext;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run...");
//		Edificio e = new Edificio();
		
//		Postazione p = new Postazione("Ciao", Tipo.OPENSPACE, e);

		Edificio e1 = (Edificio) appContext.getBean("nuovoEdificio");
		
		edificioService.inserisciEdificio(e1);
		Edificio e2 = edificioService.cercaEdificio(1l);
		System.out.println(e1);
		postazioneService.creaPostazione("Milano", e2, Tipo.PRIVATO);
	}

}
