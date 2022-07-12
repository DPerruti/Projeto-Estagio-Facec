package com.facec.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotBlank(message = "O nome do cliente nao pode estar em branco")
	private String nome;
	
	@CPF(message = "Informe um cpf valido")
	@NotNull(message = "O cpf do cliente nao pode estar em branco")
	private String cpf;
	
	@NotBlank(message = "O endereco do cliente nao pode estar em branco")
	private String endereco;	
	

	@Size(min =11, max = 11,message = "Telefone invalido")
	@NotBlank(message = "O endereco do cliente nao pode estar em branco")
	private String telefone;
	
	@PastOrPresent(message = "Data nao pode ser maior que a atual.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCadastro;
	
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}

