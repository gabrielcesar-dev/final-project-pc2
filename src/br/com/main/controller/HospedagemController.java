package br.com.main.controller;

import java.util.List;

import br.com.main.model.Hospedagem;
import br.com.main.persistence.HospedagemDAO;
import br.com.main.persistence.HospedagemDAOImpl;

public class HospedagemController {
    public String inserir(Hospedagem hospedagem) {
        HospedagemDAO dao = new HospedagemDAOImpl();
        return dao.inserir(hospedagem);
    }
    
    public String alterar(Hospedagem hospedagem) {
        HospedagemDAO dao = new HospedagemDAOImpl();
        return dao.alterar(hospedagem);
    }
    
    public String excluir(Hospedagem hospedagem) {
        HospedagemDAO dao = new HospedagemDAOImpl();
        return dao.excluir(hospedagem);
    }

    public List<Hospedagem> listarTodos() {
        HospedagemDAO dao = new HospedagemDAOImpl();
        return dao.listarTodos();
    }
}