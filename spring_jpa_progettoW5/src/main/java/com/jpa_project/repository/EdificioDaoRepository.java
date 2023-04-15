package com.jpa_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;

@Repository
public interface EdificioDaoRepository extends JpaRepository<Edificio, Long> {

//	public List<Postazione> findByTipo(Tipo tipo);
//	public List<Postazione>  findByEdificio(Edificio e);
}
