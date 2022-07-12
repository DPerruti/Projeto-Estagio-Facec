package com.facec.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import javax.validation.constraints.NotNull;

import com.facec.model.Cnh;
import com.facec.model.Detran;
import com.facec.model.Funcionario;
import com.facec.model.Renovacao;

public class RenovacaoDto {

	private Long id;

	@NotNull(message = "Informe o cliente")
	private Funcionario funcionario;
	
	@NotNull(message = "Informe o cnh")
	private Cnh cnh;
	
	@NotNull(message = "Informe o detran")
	private Detran detran;
	
	@NotNull
	private BigDecimal valor;
	
	
	@NotNull
	private String dataMovimento;

	public RenovacaoDto() {
		// TODO Auto-generated constructor stub
	}

	public RenovacaoDto(Renovacao entity) {
		super();
		this.id = entity.getId();
		this.funcionario = entity.getFuncionario();
		this.cnh = entity.getCnh();
		this.detran = entity.getDetran();
		this.valor = entity.getValor();
		this.dataMovimento = entity.getDataMovimento().toString().substring(0, 10);
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

	public Renovacao getEntity() {
		return new Renovacao(id, funcionario, cnh, detran, valor, formataData(dataMovimento));
	}

}
