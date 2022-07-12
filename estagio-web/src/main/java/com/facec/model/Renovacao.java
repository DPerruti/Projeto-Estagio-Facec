package com.facec.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Renovacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Funcionario funcionario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cnh_fk")
	private Cnh cnh;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "detran_fk")
	private Detran detran;

	@NotNull
	private BigDecimal valor;
	
	
	
	@PastOrPresent(message = "Data nao pode ser maior que a atual.")
	@NotNull
	private LocalDateTime dataMovimento;

	public Renovacao() {
		// TODO Auto-generated constructor stub
	}

	public Renovacao(Long id, Funcionario funcionario, Cnh cnh, Detran detran, BigDecimal valor, LocalDateTime dataMovimento) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.cnh = cnh;
		this.detran = detran;
		this.valor = valor;
		
		this.dataMovimento = dataMovimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cnh getCnh() {
		return cnh;
	}

	public void setCnh(Cnh cnh) {
		this.cnh = cnh;
	}

	public Detran getDetran() {
		return detran;
	}

	public void setDetran(Detran detran) {
		this.detran = detran;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(LocalDateTime dataMovimento) {
		this.dataMovimento = dataMovimento;
	}
    
	
	
}
