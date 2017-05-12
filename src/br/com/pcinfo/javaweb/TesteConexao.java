package br.com.pcinfo.javaweb;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws Exception {
		Connection conexao = new ConnectionFactory().getConnection();
		System.out.println("Conexao Aberta!");
		conexao.close();

		System.out.println(conexao.isClosed());
	}

}
