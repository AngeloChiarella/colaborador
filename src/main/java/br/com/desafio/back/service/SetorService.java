package br.com.desafio.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.back.entities.Setor;
import br.com.desafio.back.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository setorRepository;

	public Setor save(Setor setor) {
		return setorRepository.save(setor);
	}

	public List<Setor> findAll() {
		return setorRepository.findAll();
	}

	public Optional<Setor> findById(Integer id) {
		return setorRepository.findById(id);
	}

	public void deleteById(Integer id) {
		setorRepository.deleteById(id);;
	}
	
	
}
