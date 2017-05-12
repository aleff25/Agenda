<html>
<body>
	<%@ page import="java.util.*,
		br.com.pcinfo.javaweb.*"%>

	<table>
		<tr>
			<th>NOME</th>
			<th>EMAIL</th>
			<th>ENDEREÇO</th>
			<th>DATA NASCIMENTO</th>
		</tr>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			for (Contato contato : contatos) {
		%>
		
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=contato.dataFormatada()%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>