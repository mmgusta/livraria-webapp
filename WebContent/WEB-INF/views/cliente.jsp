<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente</title>
<spring:url value="/cliente/salva" var="salva"></spring:url>
<spring:url value="/cliente/altera/" var="altera"></spring:url>
<spring:url value="/cliente/deleta/" var="deleta"></spring:url>

<link href='<spring:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.4.1.min.js"/>'></script>
<script src='<spring:url value="/resources/js/bootstrap.min.js"/>'></script>

</head>
<body>
	<div class="container">
		<h1>Cliente</h1>
		<hr>
		
		<form:form action="${salva}" modelAttribute="cliente">
			<form:hidden path="id"/>
			
			<div class="form-group">
				<label>Nome</label><br />
				<form:input path="nome" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label>Telefone</label><br />
				<form:input path="telefone" cssClass="form-control"/>
			</div>
			
			<input type="submit" class="btn btn-primary" value="${cliente.id == 0 ? 'Cadastrar' : 'Alterar' }"/>
			
			<c:if test="${cliente.id ne 0}">
				<input type="submit" class="btn btn-outline-secondary" name="cancela" value="Cancelar"/>
			</c:if>
			
		</form:form>
		
		<c:if test="${not empty clientes}">
			<table class="table mt-3">
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th colspan="2">Ações</th>
				</tr>
				<c:forEach var="cliente" items="${clientes}">
					<tr>
						<td style="width:10%">${cliente.id}</td>
						<td style="width:50%">${cliente.nome}</td>
						<td style="width:30%">${cliente.telefone}</td>
						<td style="width:5%"><a href="${altera}${cliente.id}" class="btn btn-warning">Alterar</a></td>
						<td style="width:5%"><a href="${deleta}${cliente.id}" class="btn btn-danger"
												onclick="return confirm('Deseja deletar esse cliente?');">Deletar</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</c:if>
	</div>
</body>
</html>