package br.com.pcinfo.javaweb.spring.java;

import java.util.Calendar;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class Tarefa {

	private Long id;

	@NotEmpty(message= "org.hibernate.validator.constraints.NotEmpty.message")
	@Min(5)
	private String descricao;

	private boolean finalizado;
	private Calendar dataFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

}
