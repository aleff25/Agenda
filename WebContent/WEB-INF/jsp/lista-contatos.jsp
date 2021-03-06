<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="cabecalho.jsp" />

<table>
	<c:forEach var="contato" items="${contatos}">
		<tr>
			<td>${contato.nome}</td>
			<td><c:choose>
					<c:when test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:when>
					<c:otherwise>
					Email n�o informado!
				</c:otherwise>
				</c:choose></td>
			<td>${contato.endereco}</td>
			<td><fmt:formatDate value="${contato.dataNascimento.time}"
					pattern="dd/MM/yyyy" /></td>

			<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
		</tr>
	</c:forEach>
</table>
<c:import url="rodape.jsp" />