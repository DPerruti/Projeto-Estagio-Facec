package com.facec.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cnh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	@CPF(message = "Cpf invalido")
	private String cpf;
	private Long numRegistro;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVencimento;
	@Size(min =11, max = 11,message = "Telefone invalido")
	private String telefone;

	public Long getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(Long numRegistro) {
		this.numRegistro = numRegistro;
	}

	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
		
}
