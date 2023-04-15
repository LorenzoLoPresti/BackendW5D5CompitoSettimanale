package com.jpa_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.PostazioneConfiguration;
import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.repository.PostazioneDaoRepository;


@Service
public class PostazioneService {

	@Autowired private PostazioneDaoRepository repo;
	
	
	
//	public void creaPostazioneDb() {
//	
//	}
	
	public void creaPostazione(String desc, Edificio e, Tipo t) {
//		Postazione p = new Postazione(desc, t, e);
		 AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PostazioneConfiguration.class);
		Postazione p = (Postazione) appContext.getBean("creaPostazione");
//		Edificio e = new Edificio();
//		e.setCitta("Roma");
//		e.setIndirizzo("Roma");
//		e.setNome("Romapalace");
//		Postazione p = creaPostazioneProvider.getObject();
		p.setDescrizione(desc);
		p.setEdificio(e);
		p.setTipo(t);
		p.creaOccupanti(p);
		
		System.out.println("prima");
		inserisciPostazione(p);
		System.out.println("dopo");
	}
	
	public void inserisciPostazione(Postazione p) {
		repo.save(p);
	}
	
	public void rimuoviPostazione(Postazione p) {
		repo.delete(p);
	}
	
	public Postazione getPostazioneById(Long id) {
		return repo.findById(id).get();
	}
	
	public void updatePostazione(Postazione p) {
		repo.save(p);
	}
	
	public List<Postazione> cercaTuttePostazioni(){
		return (List<Postazione>) repo.findAll();
	}
}
