package br.com.desafio.back.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "colaborador")
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer colaboradorId;

	@Column(columnDefinition = "CHAR(11)", nullable = false, unique = true)
	@NotNull
	@Length(max = 11, min = 11)
	private String cpf;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	@Column(precision = 11, length = 11)
	private String telefone;

	@Column(name = "data_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;

	@ManyToOne
	@JoinColumn(name = "setorId", columnDefinition = "int")
	private Setor setorId;

}
