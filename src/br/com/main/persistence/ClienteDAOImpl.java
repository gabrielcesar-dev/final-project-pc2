package br.com.main.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.main.model.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public String inserir(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cliente(nomeCliente, rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, cepCliente, nascimentoCliente) VALUES (?,?,?,?,?,?,?,?)");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, cliente.getNomeCliente());
            pst.setString(2, cliente.getRgCliente());
            pst.setString(3, cliente.getEnderecoCliente());
            pst.setString(4, cliente.getBairroCliente());
            pst.setString(5, cliente.getCidadeCliente());
            pst.setString(6, cliente.getEstadoCliente());
            pst.setString(7, cliente.getCepCliente());
            pst.setObject(8, cliente.getNascimentoCliente());
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
    public String alterar(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE cliente SET rgCliente=?, enderecoCliente=?, bairroCliente=?, cidadeCliente=?, estadoCliente=?, cepCliente=?, nascimentoCliente=?, nomeCliente=? WHERE codCliente=?");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, cliente.getRgCliente());
            pst.setString(2, cliente.getEnderecoCliente());
            pst.setString(3, cliente.getBairroCliente());
            pst.setString(4, cliente.getCidadeCliente());
            pst.setString(5, cliente.getEstadoCliente());
            pst.setString(6, cliente.getCepCliente());
            pst.setObject(7, cliente.getNascimentoCliente());
            pst.setString(8, cliente.getNomeCliente());
            pst.setInt(9, cliente.getCodCliente());
            
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
    public String excluir(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM cliente WHERE nomeCliente=? AND rgCliente=?");
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, cliente.getNomeCliente());
            pst.setString(2, cliente.getRgCliente());
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
    public List<Cliente> listarTodos() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM cliente ORDER BY nomeCliente");
        Connection con = ConnectionFactory.getConnection();
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setCodCliente(rs.getInt("codCliente"));
                    cliente.setNomeCliente(rs.getString("nomeCliente"));
                    cliente.setRgCliente(rs.getString("rgCliente"));
                    cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
                    cliente.setBairroCliente(rs.getString("bairroCliente"));
                    cliente.setCidadeCliente(rs.getString("cidadeCliente"));
                    cliente.setEstadoCliente(rs.getString("estadoCliente"));
                    cliente.setCepCliente(rs.getString("cepCliente"));
                    cliente.setNascimentoCliente(rs.getObject("nascimentoCliente", LocalDate.class));
                    lista.add(cliente);
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