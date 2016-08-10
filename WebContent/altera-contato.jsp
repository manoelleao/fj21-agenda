<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Contatos</title>

<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#dataNascimento" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
  </script>
</head>
<body>
<c:import url="cabecalho.jsp"></c:import>
<hr />
<form action="mvc?logica=AlteraContatoLogic" method="post">
<input type="text" name="id" value="${contato.id}"placeholder="id"/><br><br />
<input type="text" name="nome" value="${contato.nome}"placeholder="nome"/><br><br />
<input type="text" name="email" value="${contato.email}" placeholder="email"/><br><br />
<input type="text" name="endereco" value="${contato.endereco}" placeholder="endereço"/><br><br />
<input type="text" name="dataNascimento"  value="${contato.dataNascimento.time}" value="pattern=dd/MM/yyyy" placeholder="dataNascimento" /><br><br />
<input type="submit" value="Gravar" />
</form>

<c:import url="rodape.jsp"></c:import>
</body>
</html>









