package br.com.desafio.back.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;

import br.com.desafio.back.entities.Setor;
import br.com.desafio.back.repositories.SetorRepository;

@Configuration
@SpringBootConfiguration
public class Test implements CommandLineRunner {

	@Autowired
	private SetorRepository setorRepository;

	@Override
	public void run(String... args) throws Exception {
		Setor rh = new Setor(1, "RH");
		Setor dp = new Setor(2, "DP");
		setorRepository.saveAll(Arrays.asList(rh, dp));
	}

}
