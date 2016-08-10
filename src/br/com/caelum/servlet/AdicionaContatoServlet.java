	package br.com.caelum.servlet;
	
	import com.mysql.jdbc.Connection;
	import java.util.Date;
	import java.io.IOException;
	import java.io.PrintWriter;
//	import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	//////////////////////////////////////////
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
	
	/////////////////////////////////////////
	import br.com.caelum.servlet.dao.ContatoDao;
	import br.com.caelum.servlet.dao.modelo.Contato;
	import br.com.caelum.util.FormataData;
	
		@WebServlet("/adicionaContato")
	public class AdicionaContatoServlet extends HttpServlet { 
		 protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
			// busca o writer
	PrintWriter out = response.getWriter();
	
	
	// buscando os parâmetros no request
	String nome = request.getParameter("nome");
	String endereco = request.getParameter("endereco");
	String email = request.getParameter("email");
	String dataNascimento = request.getParameter("dataNascimento");
		
	
	
	Contato contato = new Contato();
	
	contato.setNome(nome);
	contato.setEndereco(endereco);
	contato.setEmail(email);
	contato.setDataNascimento(FormataData.Formata(dataNascimento));
	
	
	// salva o contato
	Connection connection = (Connection) request.getAttribute("conexao");
	ContatoDao dao = null;
	dao = new ContatoDao(connection);
	dao.adiciona(contato);
	
	
	// imprime o nome do contato que foi adicionado
	/*out.println("<html>");
	out.println("<body>");
	out.println("Contato " + contato.getNome() +" adicionado com sucesso");
	out.println("</body>");
	out.println("</html>");*/
	
	RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
	rd.include(request,response);
	
	
	
	
			}
	}