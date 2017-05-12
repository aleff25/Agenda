package br.com.pcinfo.javaweb.spring.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTarefaDao {

	private Connection connection;

	@Autowired
	public JdbcTarefaDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public JdbcTarefaDao(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Tarefa tarefa) {
		String sql = "insert into tarefa " + "(descricao,finalizado,dataFinalizacao)" + " values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(System.currentTimeMillis()), Calendar.getInstance());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Tarefa> lista() {
		try {
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tarefa");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				// criando o objeto Contato
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);

				// adicionando o objeto à lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Tarefa tarefa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete" + " from tarefa where id=?");
			stmt.setLong(1, tarefa.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Tarefa tarefa) {
		String sql = "update tarefa set descricao=?, finalizado=? " + "dataNascimento=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(4, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(5, tarefa.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void finaliza(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("update tarefa" + " set finalizado=1 where id=?");
			stmt.setLong(1, id);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Tarefa buscarPorId(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("select *" + " from tarefa where id=?");
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			Tarefa tarefa = null;
			while (rs.next()) {
				tarefa = new Tarefa();
				// criando o objeto Contato
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));

				// montando a data através do Calendar
				Date date = new Date(System.currentTimeMillis());
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				tarefa.setDataFinalizacao(cal);
			}

			stmt.execute();
			stmt.close();

			return tarefa;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
