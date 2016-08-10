package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.servlet.dao.ContatoDao;
import br.com.caelum.servlet.dao.modelo.Contato;

public class ListaContatosLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection connection = (Connection) req.getAttribute("conexao");		
		List<Contato> contatos = new ContatoDao(connection).getLista();
		req.setAttribute("contatos", contatos);
		
		return "lista-contatos.jsp";
	}
}