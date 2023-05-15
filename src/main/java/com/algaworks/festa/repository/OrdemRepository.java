package com.algaworks.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.festa.model.OrdemModel;

@Repository
public interface OrdemRepository extends JpaRepository<OrdemModel, Long>{
    OrdemModel findByMatricula(String matricula);
   // OrdemModel save(OrdemModel ordem);


}
