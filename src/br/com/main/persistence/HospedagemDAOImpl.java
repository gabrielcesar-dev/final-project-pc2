package br.com.main.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import br.com.main.model.Chale;
import br.com.main.model.Hospedagem;

public class HospedagemDAOImpl implements HospedagemDAO {
	
	private boolean isAltaEstacao(LocalDate date) {
	    // Suponha que alta estação seja de dezembro a fevereiro (verão no Brasil)
	    Month month = date.getMonth();
	    return month == Month.DECEMBER || month == Month.JANUARY || month == Month.FEBRUARY;
	}

	private Double calcularValorFinal(Hospedagem hospedagem, Chale chale) {
	    LocalDate dataInicio = hospedagem.getDataInicio();
	    LocalDate dataFim = hospedagem.getDataFim();
	    long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);

	    Double diaria;
	    if (isAltaEstacao(dataInicio)) {
	        diaria = chale.getValorAltaEstacao().doubleValue();
	    } else {
	        diaria = chale.getValorBaixaEstacao().doubleValue();
	    }

	    Double valorFinal = diaria * dias;
	    
	    // Aplicar desconto se houver
	    Double desconto = hospedagem.getDesconto() != null ? hospedagem.getDesconto().doubleValue() : 0.0;
	    valorFinal -= desconto;
	    
	    return valorFinal;
	}

	private String determinarEstado(LocalDate dataFim, LocalDate dataInicio) {
	    LocalDate hoje = LocalDate.now();
	    if (dataFim.isBefore(hoje)) {
	        return "Finalizada";
	    } else if (dataInicio.isAfter(hoje)) {
	        return "Reservado";
	    } else {
	        return "Em andamento";
	    }
	}

	private Chale buscarChalePorId(int codChale) {
	    // SQL para buscar o chalé pelo ID
	    String sql = "SELECT * FROM chale WHERE codChale = ?";
	    Chale chale = null;
	    Connection con = ConnectionFactory.getConnection(); // Obtém a conexão com o banco de dados

	    try {
	        // Preparando a consulta
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setInt(1, codChale);
	        
	        // Executando a consulta e obtendo o resultado
	        ResultSet rs = pst.executeQuery();
	        
	        // Verifica se o resultado contém dados
	        if (rs.next()) {
	            chale = new Chale();
	            chale.setCodChale(rs.getInt("codChale"));
	            chale.setLocalizacao(rs.getString("localizacao"));
	            chale.setCapacidade(rs.getInt("capacidade"));
	            chale.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
	            chale.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Registra a exceção
	    } finally {
	        // Fecha a conexão com o banco de dados
	        ConnectionFactory.close(con);
	    }

	    return chale; // Retorna o objeto Chalé ou null se não encontrado
	}

	@Override
	public String alterar(Hospedagem hospedagem) {
	    // Primeiro, busque os dados do chalé
	    Chale chale = buscarChalePorId(hospedagem.getCodChale());
	    
	    // Determine o estado e calcule o valor final
	    hospedagem.setDataFim(LocalDate.now());
	    String novoEstado = determinarEstado(hospedagem.getDataFim(), hospedagem.getDataInicio());
	    Double valorFinal = calcularValorFinal(hospedagem, chale);
	    
	    
	    // Atualize a hospedagem com o novo estado e valor final
	    hospedagem.setEstado(novoEstado);
	    hospedagem.setValorFinal(valorFinal);
	    

	    StringBuilder sql = new StringBuilder();
	    sql.append("UPDATE hospedagem SET estado=?, dataInicio=?, dataFim=?, qtdPessoas=?, desconto=?, valorFinal=? WHERE codChale=? AND codCliente=?");
	    Connection con = ConnectionFactory.getConnection();
	    try {
	        PreparedStatement pst = con.prepareStatement(sql.toString());
	        pst.setString(1, hospedagem.getEstado());
	        pst.setObject(2, hospedagem.getDataInicio());
	        pst.setObject(3, hospedagem.getDataFim());
	        pst.setInt(4, hospedagem.getQtdPessoas());
	        pst.setDouble(5, hospedagem.getDesconto());
	        pst.setDouble(6, hospedagem.getValorFinal());
	        pst.setInt(7, hospedagem.getCodChale());
	        pst.setInt(8, hospedagem.getCodCliente());
	        int res = pst.executeUpdate();
	        if (res > 0) {
	            return "Alterado com sucesso.";
	        } else {
	            return "Erro ao alterar.";
	        }
	    } catch (SQLException e) {
	        return e.getMessage();
	    } finally {
	        ConnectionFactory.close(con);
	    }
	}


    @Override
    public String inserir(Hospedagem hospedagem) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO hospedagem(codChale, codCliente, estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) VALUES (?,?,?,?,?,?,?,?)");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, hospedagem.getCodChale());
            pst.setInt(2, hospedagem.getCodCliente());
            pst.setString(3, hospedagem.getEstado());
            pst.setObject(4, hospedagem.getDataInicio());
            pst.setObject(5, hospedagem.getDataFim());
            pst.setInt(6, hospedagem.getQtdPessoas());
            pst.setDouble(7, hospedagem.getDesconto());
            pst.setDouble(8, hospedagem.getValorFinal());
            int res = pst.executeUpdate();
            if (res > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            ConnectionFactory.close(con);
        }
    }

    /*@Override
    public String alterar(Hospedagem hospedagem) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE hospedagem SET estado=?, dataInicio=?, dataFim=?, qtdPessoas=?, desconto=?, valorFinal=? WHERE codChale=? AND codCliente=?");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, hospedagem.getEstado());
            pst.setObject(2, hospedagem.getDataInicio());
            pst.setObject(3, hospedagem.getDataFim());
            pst.setInt(4, hospedagem.getQtdPessoas());
            pst.setDouble(5, hospedagem.getDesconto());
            pst.setDouble(6, hospedagem.getValorFinal());
            pst.setInt(7, hospedagem.getCodChale());
            pst.setInt(8, hospedagem.getCodCliente());
            int res = pst.executeUpdate();
            if (res > 0) {
                return "Alterado com sucesso.";
            } else {
                return "Erro ao alterar.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            ConnectionFactory.close(con);
        }
    }*/

    @Override
    public String excluir(Hospedagem hospedagem) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM hospedagem WHERE codChale=? AND codCliente=?");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, hospedagem.getCodChale());
            pst.setInt(2, hospedagem.getCodCliente());
            int res = pst.executeUpdate();
            if (res > 0) {
                return "Excluído com sucesso.";
            } else {
                return "Erro ao excluir.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            ConnectionFactory.close(con);
        }
    }

    @Override
    public List<Hospedagem> listarTodos() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM hospedagem ORDER BY dataInicio");
        Connection con = ConnectionFactory.getConnection();
        List<Hospedagem> lista = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Hospedagem hospedagem = new Hospedagem();
                    hospedagem.setCodChale(rs.getInt("codChale"));
                    hospedagem.setCodCliente(rs.getInt("codCliente"));
                    hospedagem.setEstado(rs.getString("estado"));
                    hospedagem.setDataInicio(rs.getObject("dataInicio", LocalDate.class));
                    hospedagem.setDataFim(rs.getObject("dataFim", LocalDate.class));
                    hospedagem.setQtdPessoas(rs.getInt("qtdPessoas"));
                    hospedagem.setDesconto(rs.getDouble("desconto"));
                    hospedagem.setValorFinal(rs.getDouble("valorFinal"));
                    lista.add(hospedagem);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            ConnectionFactory.close(con);
        }
    }
}