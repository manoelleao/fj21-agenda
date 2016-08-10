package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import br.com.caelum.servlet.dao.ContatoDao;
import br.com.caelum.servlet.dao.modelo.Contato;
import br.com.caelum.util.FormataData;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataNascimento = req.getParameter("dataNascimento");
			
		
		
		Contato contato = new Contato();
		
		contato.setId(id);
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(FormataData.Formata(dataNascimento));
		
		Connection connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		dao.altera(contato);
		
		System.out.print("Alterando contato");
		
		return "mvc?logica=ListaContatosLogic";
			
	}

}
