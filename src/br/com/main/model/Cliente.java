package br.com.main.model;

import java.time.LocalDate;

public class Cliente {

	private Integer codClient;
	private String nomeCliente;
	private String rgCliente;
	private String enderecoCliente;
	private String bairroCliente;
	private String cidadeCliente;
	private String estadoCliente;
	private String cepCliente;
	private LocalDate nascimentoCliente;
	
	
	public Cliente(Integer codClient, String nomeCliente, String rgCliente, String enderecoCliente,
			String bairroCliente, String cidadeCliente, String estadoCliente, String cepCliente,
			LocalDate nascimentoCliente) {
		this.codClient = codClient;
		this.nomeCliente = nomeCliente;
		this.rgCliente = rgCliente;
		this.enderecoCliente = enderecoCliente;
		this.bairroCliente = bairroCliente;
		this.cidadeCliente = cidadeCliente;
		this.estadoCliente = estadoCliente;
		this.cepCliente = cepCliente;
		this.nascimentoCliente = nascimentoCliente;
	}

	public Integer getCodClient() {
		return codClient;
	}

	public void setCodClient(Integer codClient) {
		this.codClient = codClient;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getRgCliente() {
		return rgCliente;
	}

	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public LocalDate getNascimentoCliente() {
		return nascimentoCliente;
	}

	public void setNascimentoCliente(LocalDate nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}

}
