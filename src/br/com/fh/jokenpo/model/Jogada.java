package br.com.fh.jokenpo.model;

import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Jogada {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	
	@NotEmpty(message = "{login.valida}") @Size(min=5, message = "{login.tamanho}")
	private String jogador;
	private Calendar data_cadastro;
	private String jogada_jogador;
	private String jogada_computador;
	private String resultado;
	
	public Long getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	public Calendar getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public String getJogada_jogador() {
		return jogada_jogador;
	}
	public void setJogada_jogador(String jogada_jogador) {
		this.jogada_jogador = jogada_jogador;
	}
	public String getJogada_computador() {
		return jogada_computador;
	}
	public void setJogada_computador(String jogada_computador) {
		this.jogada_computador = jogada_computador;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
