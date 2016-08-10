package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import br.com.caelum.servlet.dao.ContatoDao;
import br.com.caelum.servlet.dao.modelo.Contato;

public class RemoveContatoLogic implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		long id = Long.parseLong(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
	
		Connection connection = (Connection) req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.exclui(contato);
		System.out.println("Excluindo contato");
		
		return "mvc?logica=ListaContatosLogic";
		
	}

}
	