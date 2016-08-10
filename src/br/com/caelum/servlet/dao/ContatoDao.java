package br.com.caelum.servlet.dao;

import java.sql.*;
import java.util.*;
import java.sql.Date;

import br.com.caelum.servlet.ConnectionFactory;
import br.com.caelum.servlet.dao.modelo.*;
//import br.com.caelum.util.*;
import java.sql.Connection;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao(Connection connection) {
		this.connection = connection;
		}

	

	/*private Connection connection;
	
	public ContatoDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}*/

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
	try {
		PreparedStatement ins = connection.prepareStatement(sql);
		ins.setString(1,contato.getNome());
		ins.setString(2,contato.getEmail());
		ins.setString(3,contato.getEndereco());
		ins.setDate(4, new Date (contato.getDataNascimento().getTimeInMillis()));
		ins.execute();
		ins.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
	
public List<Contato> getLista() {
	try {
		List<Contato> contatos = new ArrayList<Contato>();
		PreparedStatement ins = this.connection.prepareStatement("select * from contatos");
		ResultSet x = ins.executeQuery();
	
	while (x.next()) {
	Contato contato = new Contato();
	contato.setId(x.getLong("id"));
	contato.setNome(x.getString("nome"));
	contato.setEmail(x.getString("email"));
	contato.setEndereco(x.getString("endereco"));
	//contato.setDataNascimento(x.getDate("dataNascimento"));
	
	Calendar y = Calendar.getInstance();
	y.setTime(x.getDate("dataNascimento"));
	contato.setDataNascimento(y);
	
	contatos.add(contato);
	}
	x.close();
	ins.close();
	return  contatos;
		
	}catch (SQLException e) {
		throw new RuntimeException(e);
	}
	
}
	
	public void exclui(Contato contato) {
		try {
			PreparedStatement dlt = connection.prepareStatement("delete from contatos where id=?");
			
			dlt.setLong(1, contato.getId());
			dlt.execute();
			dlt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
			 try {
			PreparedStatement alt = connection.prepareStatement(sql);
			
			alt.setString(1, contato.getNome());
			alt.setString(2, contato.getEmail());
			alt.setString(3, contato.getEndereco());
			alt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			alt.setLong(5, contato.getId());
			
			alt.execute();
			alt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
					
}
		