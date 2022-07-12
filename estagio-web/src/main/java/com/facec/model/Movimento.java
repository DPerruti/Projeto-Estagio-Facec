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
public class Movimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "veiculo_fk")
	private Veiculo veiculo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "funcionario_fk")
	private Funcionario funcionario;

	@NotNull
	private BigDecimal valor;
	
	@NotNull
	private TipoMovimento tipoMovimento;
	
	@PastOrPresent(message = "Data nao pode ser maior que a atual.")
	@NotNull
	private LocalDateTime dataMovimento;

	public Movimento() {
		// TODO Auto-generated constructor stub
	}

	public Movimento(Long id, Cliente cliente, Funcionario funcionario, BigDecimal valor, Veiculo veiculo, TipoMovimento tipoMovimento, LocalDateTime dataMovimento) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.funcionario = funcionario;
		this.valor = valor;
		this.tipoMovimento = tipoMovimento;
		this.dataMovimento = dataMovimento;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public LocalDateTime getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(LocalDateTime dataMovimento) {
		this.dataMovimento = dataMovimento;
	}
}
