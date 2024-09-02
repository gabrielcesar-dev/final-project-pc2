package br.com.main.persistence;

import java.util.List;
import br.com.main.model.Chale;

public interface ChaleDAO {
    public String inserir(Chale chale);
    public String alterar(Chale chale);
    public String excluir(Chale chale);
    public List<Chale> listarTodos();
}