package com.facec.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import javax.validation.constraints.NotNull;

import com.facec.model.Cliente;
import com.facec.model.Funcionario;
import com.facec.model.Movimento;
import com.facec.model.TipoMovimento;
import com.facec.model.Veiculo;


public class MovimentoDto {

	private Long id;

	@NotNull(message = "Informe o cliente")
	private Cliente cliente;
	
	@NotNull(message = "Informe o veiculo")
	private Veiculo veiculo;
	
	@NotNull(message = "Informe o funcionário")
	private Funcionario funcionario;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	private TipoMovimento tipoMovimento;

	
	@NotNull
	private String dataMovimento;

	public MovimentoDto() {
		// TODO Auto-generated constructor stub
	}

	public MovimentoDto(Movimento entity) {
		super();
		this.id = entity.getId();
		this.cliente = entity.getCliente();
		this.veiculo = entity.getVeiculo();
		this.funcionario = entity.getFuncionario();
		this.valor = entity.getValor();
		this.tipoMovimento = entity.getTipoMovimento();
		this.dataMovimento = entity.getDataMovimento().toString().substring(0, 10);
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
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}	

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	public String getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(String dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	private LocalDateTime formataData(String data) {
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(data, formatter);

			return LocalDateTime.of(localDate, LocalTime.now());
		} catch (Exception e) {
			return null;
		}
	}

	public Movimento getEntity() {
		return new Movimento(id, cliente, funcionario, valor, veiculo, tipoMovimento, formataData(dataMovimento));
	}

}
