package br.com.desafio.back.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.back.dto.ColaboradorDTO;
import br.com.desafio.back.dto.ColaboradorGetAllDTO;
import br.com.desafio.back.entities.Colaborador;
import br.com.desafio.back.entities.Setor;
import br.com.desafio.back.repositories.ColaboradorRepository;
import br.com.desafio.back.repositories.SetorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	@Autowired
	private SetorRepository setorRepository;

	public ColaboradorDTO save(ColaboradorDTO colaboradorDTO) {

		Optional<Setor> setor = setorRepository.findById(colaboradorDTO.getSetorId());

		Colaborador colaborador = findByCpf(colaboradorDTO.getCpf());

		if (colaborador == null) {
			colaborador = new Colaborador();
		}

		colaborador.setCpf(colaboradorDTO.getCpf());
		colaborador.setNome(colaboradorDTO.getNome());
		colaborador.setEmail(colaboradorDTO.getEmail());
		colaborador.setTelefone(colaboradorDTO.getTelefone());
		colaborador.setDataNascimento(Date.valueOf(colaboradorDTO.getDataNascimento()));
		colaborador.setSetorId(setor.get());

		repository.save(colaborador);
		return colaboradorDTO;

	}

	public List<ColaboradorGetAllDTO> findAll() {
		List<Colaborador> colaboradores = (ArrayList<Colaborador>) repository.findAll();
		List<ColaboradorGetAllDTO> colaboradoresGetAllDTO = new ArrayList<>();

		for (Colaborador colaborador : colaboradores) {
			ColaboradorGetAllDTO colaboradorDTO = new ColaboradorGetAllDTO();
			colaboradorDTO.setCpf(colaborador.getCpf());
			colaboradorDTO.setNome(colaborador.getNome());
			colaboradorDTO.setEmail(colaborador.getEmail());
			colaboradorDTO.setSetor(colaborador.getSetorId());

			colaboradoresGetAllDTO.add(colaboradorDTO);
		}
		colaboradoresGetAllDTO.sort(Comparator.comparing(c -> c.getNome()));
		return colaboradoresGetAllDTO;

	}

	public Optional<Colaborador> findById(Integer colaboradorId) {
		return repository.findById(colaboradorId);
	}

	public Colaborador findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public ColaboradorDTO delete(String cpf) {
		ColaboradorDTO colaboradorDTO2 = new ColaboradorDTO(repository.findByCpf(cpf));
		repository.delete((Colaborador) repository.findByCpf(cpf));
		return colaboradorDTO2;
	}

}
