package br.com.desafio.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.back.entities.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

	Colaborador findByCpf(String cpf);

}
