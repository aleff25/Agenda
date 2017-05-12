package br.com.pcinfo.javaweb.spring.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pcinfo.javaweb.ConnectionFactory;

public class JdbcUsuarioDao {

	private Connection connection;

	public JdbcUsuarioDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public JdbcUsuarioDao(Connection connection) {
		this.connection = connection;
	}

	public boolean existeUsuario(Usuario usuario) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from usuarios where login=?");
			stmt.setString(1, usuario.getLogin());
	
			ResultSet rs = stmt.executeQuery();
			Usuario user= null;
			while (rs.next()) {
				user = new Usuario();
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
			}

			stmt.execute();
			stmt.close();
	
			return true;
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	}
}
