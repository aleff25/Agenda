<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<td>${tarefa.id}</td>
	<td>${tarefa.descricao}</td>
	<td>Finalizada</td>
	<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
			pattern="dd/MM/yyyy" /></td>
	<td><a href="alterarTarefa?id=${tarefa.id}">Alterar</a></td>
	<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>

</body>
</html>