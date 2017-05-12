<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="minhaTag"%>
<html>
<head>
<title>Adicionar Contato</title>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.min.css">
<script src="jQuery-ui/jquery-3.1.1.min.js"></script>
<script src="jQuery-ui/jquery-ui.min.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<form action="adicionaContato">
		Nome: <input type=text name=nome /><br> 
		Email: <input type=text
			name=email /><br> 
		Endereço: <input type=text name=endereco /><br>
		Data Nascimento: <minhaTag:campoData id="dataNascimento" />
		<br> <br /> <input type=submit value="Adicionar Contato" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>