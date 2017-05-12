package br.com.pcinfo.javaweb.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.pcinfo.javaweb.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {
	public void init(FilterConfig config) {
	}
	public void destroy( ) {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			// pendurando a connection na requisição
			request.setAttribute("conexao", connection);
			
			chain.doFilter(request, response);
			
			connection.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
