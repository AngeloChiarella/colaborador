package br.com.desafio.back.dto;

import br.com.desafio.back.entities.Setor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorGetAllDTO {
	
	private String cpf;
	private String nome;
	private String email;
	private Setor setor;
	
		

}
