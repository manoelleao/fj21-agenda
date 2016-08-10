package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import com.mysql.jdbc.Connection;
import br.com.caelum.servlet.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao {
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain)throws IOException, ServletException, ClassNotFoundException {
		try {
			Connection connection = (Connection) request.getAttribute("conexao");
			chain.doFilter(request, response);
			connection.close();
		}catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
