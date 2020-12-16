package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Filme;

public class FilmeDAO {
	
	public void create(Filme f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO FILME (titulo, categoria, sinopse, duracao, imagem3d, dublado) VALUES"
					+ "(?,?,?,?,?,?)");
			stmt.setString(1, f.getTitulo());
			stmt.setString(2, f.getCategoria());
			stmt.setString(3, f.getSinopse());
			stmt.setInt(4, f.getDuracao());
			stmt.setBoolean(5, f.isImagem3d());
			stmt.setBoolean(6, f.isDublado());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Filme salvo com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Filme> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Filme> filmes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from filme");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Filme f = new Filme();
				f.setId_filme(rs.getInt("id_filme"));
				f.setTitulo(rs.getString("titulo"));
				f.setDuracao(rs.getInt("duracao"));
				f.setSinopse(rs.getString("sinopse"));
				f.setCategoria(rs.getString("categoria"));
				f.setDublado(rs.getBoolean("dublado"));
				f.setImagem3d(rs.getBoolean("imagem3d"));
				filmes.add(f);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar informações do BD: " + e);
			e.printStackTrace();
		} finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return filmes;
	}
	
	public Filme read(int idFilme) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Filme f = new Filme();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM filme WHERE id_filme=? LIMIT 1");
			stmt.setInt(1, idFilme);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				f.setId_filme(rs.getInt("id_filme"));
				f.setTitulo(rs.getString("titulo"));
				f.setDuracao(rs.getInt("duracao"));
				f.setSinopse(rs.getString("sinopse"));
				f.setCategoria(rs.getString("categoria"));
				f.setDublado(rs.getBoolean("dublado"));
				f.setImagem3d(rs.getBoolean("imagem3d"));
			}		
		} catch (SQLException e) {
			 e.printStackTrace();
		} finally {
			 ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return f;
	}
	
	
	public void update(Filme f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE filme SET titulo=?, categoria=?, sinopse=?,"
					                     + "duracao=?, imagem3d=?, dublado=? WHERE id_filme=?;");
			stmt.setString(1, f.getTitulo());
			stmt.setString(2, f.getCategoria());
			stmt.setString(3, f.getSinopse());
			stmt.setInt(4, f.getDuracao());
			stmt.setBoolean(5, f.isImagem3d());
			stmt.setBoolean(6, f.isDublado());
			stmt.setInt(7, f.getId_filme());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Filme atualizado com sucesso! ");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar o filme: " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
