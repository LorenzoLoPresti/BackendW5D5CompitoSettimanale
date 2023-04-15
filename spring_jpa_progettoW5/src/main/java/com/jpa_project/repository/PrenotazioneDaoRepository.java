package com.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa_project.model.Prenotazione;

@Repository
public interface PrenotazioneDaoRepository extends JpaRepository<Prenotazione, Long> {

}
