package br.com.main.model;

import java.time.LocalDate;

public class Hospedagem {
    private Integer codHospedagem;
    private Integer codChale;
    private Integer codCliente;
    private String estado;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer qtdPessoas;
    private Double desconto;
    private Double valorFinal;

    public Hospedagem() {
    }

    public Hospedagem(Integer codHospedagem, Integer codChale, Integer codCliente, String estado, LocalDate dataInicio, LocalDate dataFim, Integer qtdPessoas, Double desconto, Double valorFinal) {
        this.codHospedagem = codHospedagem;
        this.codChale = codChale;
        this.codCliente = codCliente;
        this.estado = estado;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.qtdPessoas = qtdPessoas;
        this.desconto = desconto;
        this.valorFinal = valorFinal;
    }

    public Integer getCodHospedagem() {
        return codHospedagem;
    }

    public void setCodHospedagem(Integer codHospedagem) {
        this.codHospedagem = codHospedagem;
    }

    public Integer getCodChale() {
        return codChale;
    }

    public void setCodChale(Integer codChale) {
        this.codChale = codChale;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(Integer qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
