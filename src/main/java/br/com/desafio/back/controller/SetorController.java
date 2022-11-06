package br.com.desafio.back.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.back.entities.Setor;
import br.com.desafio.back.service.SetorService;

@RestController(value = "/setor")
public class SetorController {

	@Autowired
	private SetorService setorService;

	@GetMapping
	public ResponseEntity<List<Setor>> findAll() {
		return new ResponseEntity<List<Setor>>(setorService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Setor>> findById(@PathVariable Integer id) {
		return new ResponseEntity<Optional<Setor>>(setorService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Setor> save(@RequestBody Setor setor) {
		return new ResponseEntity<Setor>(setorService.save(setor), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		setorService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
