package br.com.main.controller;

import java.util.List;

import br.com.main.model.Cliente;
import br.com.main.persistence.ClienteDAO;
import br.com.main.persistence.ClienteDAOImpl;

public class ClienteController {
    public String inserir(Cliente cliente) {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.inserir(cliente);
    }
    
    public String alterar(Cliente cliente) {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.alterar(cliente);
    }
    
    public String excluir(Cliente cliente) {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.excluir(cliente);
    }

    public List<Cliente> listarTodos() {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.listarTodos();
    }
}