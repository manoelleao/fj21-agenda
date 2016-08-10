<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Contatos</title>

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
<form action="mvc?logica=AdicionaContatoLogic" method="post">
Nome: <input type="text" name="nome" /><br /><br />
E-mail: <input type="text" name="email" /><br /><br />
Endereço: <input type="text" name="endereco" /><br /><br />
Data Nascimento: <caelum:campoData id="dataNascimento" /><br /><br/>

<input type="submit" value="Gravar" />

</form>
<c:import url="rodape.jsp"></c:import>
</body>
</html>