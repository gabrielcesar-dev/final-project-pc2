package br.com.main.persistence;

import java.util.List;
import br.com.main.model.Cliente;

public interface ClienteDAO {
    public String inserir(Cliente cliente);
    public String alterar(Cliente cliente);
    public String excluir(Cliente cliente);
    public List<Cliente> listarTodos();
}