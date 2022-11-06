package br.com.desafio.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.back.dto.ColaboradorDTO;
import br.com.desafio.back.dto.ColaboradorGetAllDTO;
import br.com.desafio.back.entities.Colaborador;
import br.com.desafio.back.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaborador")
@CrossOrigin(origins = "*")
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;

	@GetMapping
	public ResponseEntity<List<ColaboradorGetAllDTO>> findAll() {
		List<ColaboradorGetAllDTO> lista = service.findAll();

		if (!lista.isEmpty())
			return new ResponseEntity<List<ColaboradorGetAllDTO>>(lista, HttpStatus.OK);

		else
			return new ResponseEntity<List<ColaboradorGetAllDTO>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Colaborador> findByCpf(@PathVariable String cpf) throws NotFoundException {
		if (cpf.length() != 11)
			return new ResponseEntity<Colaborador>(HttpStatus.BAD_REQUEST);

		if (service.findByCpf(cpf) == null)
			return new ResponseEntity<Colaborador>(HttpStatus.NOT_FOUND);

		else
			return new ResponseEntity<Colaborador>(service.findByCpf(cpf), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<ColaboradorDTO> save(@RequestBody ColaboradorDTO colaboradorDTO) throws Exception {
		if (colaboradorDTO.build() == null)
			return new ResponseEntity<ColaboradorDTO>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<ColaboradorDTO>(service.save(colaboradorDTO), HttpStatus.OK);
	}

	@DeleteMapping("/{cpf}")
	public ResponseEntity<ColaboradorDTO> delete(@PathVariable String cpf) throws Exception {
		if (cpf.length() != 11)
			return new ResponseEntity<ColaboradorDTO>(HttpStatus.BAD_REQUEST);
		
		if (service.findByCpf(cpf) == null)
			return new ResponseEntity<ColaboradorDTO>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ColaboradorDTO>(service.delete(cpf), HttpStatus.OK);
	}

}
