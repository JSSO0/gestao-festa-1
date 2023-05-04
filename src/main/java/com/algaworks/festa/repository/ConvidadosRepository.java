package com.algaworks.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.festa.model.Convidado;

@Repository
public interface ConvidadosRepository extends JpaRepository<Convidado, Long>{

}
