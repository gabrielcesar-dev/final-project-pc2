package br.com.main.persistence;

import java.util.List;
import br.com.main.model.Hospedagem;

public interface HospedagemDAO {
    public String inserir(Hospedagem hospedagem);
    public String alterar(Hospedagem hospedagem);
    public String excluir(Hospedagem hospedagem);
    public List<Hospedagem> listarTodos();
}