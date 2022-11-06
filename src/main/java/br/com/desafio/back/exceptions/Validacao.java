package br.com.desafio.back.exceptions;

import org.springframework.http.HttpStatus;

public class Validacao extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String resposta;
	private HttpStatus httpStatus;

	public Validacao() {

	}

	public Validacao(String resposta) {
		this.resposta = resposta;

		switch (resposta) {
		case "dadosInvalidos":
			this.httpStatus = HttpStatus.BAD_REQUEST;
			break;
		case "notFound":
			this.httpStatus = HttpStatus.NOT_FOUND;
		}
	}

	public String getError() {
		return resposta;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
