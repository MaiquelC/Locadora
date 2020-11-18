package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;

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
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}