<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista</title>
</head>
<body>
<c:import url="cabecalho.jsp"/> 

<table border="1%" cellspacing="3px">
<th>Link de remoção</th>
<th>Link de alteração</th>
<th>Nome</th>
<th>Email</th>
<th>Endereço</th>
<th>Data de Nascimento</th>
<c:forEach var="contato" items="${contatos}">
<tr>
<td>
<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
</td>

<td>
<a href="altera-contato.jsp">Alterar</a>
</td>



<td>${contato.nome}</td>
<td>
	<c:choose>
	<c:when test="${not empty contato.email}">
	<a href="mailto:${contato.email}">${contato.email}</a>
	</c:when>
	<c:otherwise>
	E-mail não informado
	</c:otherwise>
	</c:choose>
	<!--<c:if test="${not empty contato.email}">
	<a href="mailto:${contato.email}">${contato.email}</a>
	</c:if>
	<c:if test="${empty contato.email}">
	E-mail não informado
	</c:if>-->
</td>
<td>${contato.endereco}</td>
<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
</tr>
</c:forEach>
</table>
<h3><a href="adiciona-contato.jsp">Adicionar Contatos</a></h3>
<c:import url="rodape.jsp"/>
</body>
</html>