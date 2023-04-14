package com.jpa_project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;

@Configuration
public class PostazioneConfiguration {
	
	@Bean
	@Scope("prototype")
	public Postazione creaPostazione(String desc, Tipo tipo, Edificio edificio) {
		Postazione post = new Postazione(desc, tipo, edificio);
		switch(post.getTipo()) {
		case PRIVATO:
			post.setMaxOccupanti(120);;
			break;
		
		case OPENSPACE:
			post.setMaxOccupanti(200);
			break;
		
		case SALA_RIUNIONI:
			post.setMaxOccupanti(60);
			break;
		
		default:
			break;
		}
		
		return post;
	}
}
