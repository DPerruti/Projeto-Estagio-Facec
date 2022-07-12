package com.facec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String placa;
	
	@Size(min =1, max = 11,message = "Marca invalida")
	@NotBlank(message = "A marca do veiculo nao pode estar em branco")
	private String marca;
	@Size(min =1, max = 11,message = "Modelo invalido")
	@NotBlank(message = "O modelo do veiculo nao pode estar em branco")
	private String modelo;
	
	@NotNull(message = "O ano do veiculo nao pode estar em branco")
	private int ano;
	
	@NotBlank(message = "A cor do veiculo nao pode estar em branco")
	private String cor;
	
	@Size(min =6, max = 17,message = "Chassi invalido")
	@NotBlank(message = "O chassi do veiculo nao pode estar em branco")
	private String chassi;
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
		
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
}
