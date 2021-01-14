package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;

public class ClienteDAO {
	
	public void create(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, cpf, usuario, senha, endereco) VALUES"
					+ "(?,?,?,?,?)");
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getCpf());
			stmt.setString(3, c.getUsuario());
			stmt.setString(4, c.getSenha());
			stmt.setString(5, c.getEndereco());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Cliente> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from cliente");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId_cliente(rs.getInt("id_cliente"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getInt("cpf"));
				c.setUsuario(rs.getString("usuario"));
				c.setSenha(rs.getString("senha"));
				c.setEndereco(rs.getString("endereco"));
				clientes.add(c);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar informações do BD: " + e);
			e.printStackTrace();
		} finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return clientes;
	}
	
	public Cliente read(int idCliente) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente c = new Cliente();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE id_cliente=? LIMIT 1");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				c.setId_cliente(rs.getInt("id_cliente"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getInt("cpf"));
				c.setUsuario(rs.getString("usuario"));
				c.setSenha(rs.getString("senha"));
				c.setEndereco(rs.getString("endereco"));
			}		
		} catch (SQLException e) {
			 e.printStackTrace();
		} finally {
			 ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return c;
	}
	
	
	public void update(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE cliente SET nome=?, cpf=?, usuario=?, senha=?, endereco=? WHERE id_cliente=?;");
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getCpf());
			stmt.setString(3, c.getUsuario());
			stmt.setString(4, c.getSenha());
			stmt.setString(5, c.getEndereco());
			stmt.setInt(6, c.getId_cliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados do cliente atualizados com sucesso! ");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados do cliente: " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente=?;");
			stmt.setInt(1, c.getId_cliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
}