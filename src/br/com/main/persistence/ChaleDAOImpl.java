package br.com.main.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.main.model.Chale;

public class ChaleDAOImpl implements ChaleDAO {

    @Override
    public String inserir(Chale chale) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO chale(localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao) VALUES (?,?,?,?)");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, chale.getLocalizacao());
            pst.setInt(2, chale.getCapacidade());
            pst.setDouble(3, chale.getValorAltaEstacao());
            pst.setDouble(4, chale.getValorBaixaEstacao());
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

    @Override
    public String alterar(Chale chale) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE chale SET localizacao=?, capacidade=?, valorAltaEstacao=?, valorBaixaEstacao=? WHERE codChale=?");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, chale.getLocalizacao());
            pst.setInt(2, chale.getCapacidade());
            pst.setDouble(3, chale.getValorAltaEstacao());
            pst.setDouble(4, chale.getValorBaixaEstacao());
            pst.setInt(5, chale.getCodChale());
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
    public String excluir(Chale chale) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM chale WHERE codChale=?");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setInt(1, chale.getCodChale());
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
    public List<Chale> listarTodos() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM chale ORDER BY localizacao");
        Connection con = ConnectionFactory.getConnection();
        List<Chale> lista = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Chale chale = new Chale();
                    chale.setCodChale(rs.getInt("codChale"));
                    chale.setLocalizacao(rs.getString("localizacao"));
                    chale.setCapacidade(rs.getInt("capacidade"));
                    chale.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
                    chale.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
                    lista.add(chale);
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