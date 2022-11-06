package br.com.desafio.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.back.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

}
