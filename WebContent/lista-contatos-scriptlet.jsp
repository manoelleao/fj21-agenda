<%@ page import="java.util.*, br.com.caelum.servlet.dao.*, br.com.caelum.servlet.dao.modelo.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="br.com.caelum.servlet.dao.*; %>
<%@ page import="br.com.caelum.servlet.ConnectionFactory;" %>

<html>
	<body>
		<table border="1" cellspacing="3px">
	
	<!-- <//%List<Contato> contatos = new ContatoDao(connection).getLista();
		for (Contato contato : contatos ) { 
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		%>
		
	<tr>
	<th>Nome</th>
	<th>Email</th>
	<th>Endereço</th>
	<th>Data de nascimento</th>
	</tr>
	<tr>
	<td><\%=contato.getNome() %></td>
	<td><\\%=contato.getEmail() %></td>
	<td><\%=contato.getEndereco() %></td>
	<td><\%=form.format(contato.getDataNascimento().getTime())%></td>
	</tr>
	<\% } %>
	 -->	
		</table>
	</body>
</html>