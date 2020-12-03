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

}