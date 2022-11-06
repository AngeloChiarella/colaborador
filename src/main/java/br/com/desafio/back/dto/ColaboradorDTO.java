package br.com.desafio.back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.desafio.back.entities.Colaborador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDTO {

	@JsonIgnore
	private Integer colaboradorId;
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private Integer setorId;
	private String dataNascimento;

	public ColaboradorDTO(Colaborador colaborador) {
		this.colaboradorId = colaborador.getColaboradorId();
		this.cpf = colaborador.getCpf();
		this.nome = colaborador.getNome();
		this.email = colaborador.getEmail();
		this.telefone = colaborador.getTelefone();
		this.setorId = colaborador.getSetorId().getId();
		this.dataNascimento = colaborador.getDataNascimento().toString();
	}

	public ColaboradorDTO build() throws Exception {
		if (validarNome() && validaCpf())
			return this;
		else
			return null;
	}

	protected boolean validarNome() throws Exception {
		if (nome.length() < 3 || nome.matches("[A-z]\\s[A-z]") || nome.matches("[A-z]*"))
			return false;
		else
			return true;
	}

	protected boolean validaCpf() {
		if (cpf.length() != 11 || telefone.length() != 11)
			return false;
		else
			return true;
	}

}
