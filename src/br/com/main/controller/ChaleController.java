package br.com.main.controller;

import java.util.List;

import br.com.main.model.Chale;
import br.com.main.persistence.ChaleDAO;
import br.com.main.persistence.ChaleDAOImpl;

public class ChaleController {
    public String inserir(Chale chale) {
        ChaleDAO dao = new ChaleDAOImpl();
        return dao.inserir(chale);
    }
    
    public String alterar(Chale chale) {
        ChaleDAO dao = new ChaleDAOImpl();
        return dao.alterar(chale);
    }
    
    public String excluir(Chale chale) {
        ChaleDAO dao = new ChaleDAOImpl();
        return dao.excluir(chale);
    }

    public List<Chale> listarTodos() {
        ChaleDAO dao = new ChaleDAOImpl();
        return dao.listarTodos();
    }
}
