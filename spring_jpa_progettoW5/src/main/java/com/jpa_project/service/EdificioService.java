package com.jpa_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa_project.model.Edificio;
import com.jpa_project.repository.EdificioDaoRepository;

import jakarta.transaction.Transactional;

@Service
public class EdificioService {

	@Autowired private EdificioDaoRepository repo;
	
	public void inserisciEdificio(Edificio e) {
		repo.save(e);
	}
	

	public Edificio cercaEdificio(Long id) {
        return repo.findById(id).get();
    }
	
}
