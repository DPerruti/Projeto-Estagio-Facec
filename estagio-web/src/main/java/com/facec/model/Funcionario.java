package com.facec.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	@CPF(message = "Cpf inv�lido")
	private String cpf;
	private BigDecimal salario;

	@PastOrPresent(message = "Data nao pode ser maior que a atual.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAdmissao;

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

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public BigDecimal getSalarioDia() {
		return salario.divide(BigDecimal.valueOf(30l), 6, RoundingMode.CEILING);
	}
		
}
