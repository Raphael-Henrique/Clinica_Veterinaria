<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("consultas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Listagem e edição</title>
</head>
<body>
	<h1>Listagem de consultas</h1>

	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link active"
			aria-current="page" href="Index.html">Novo registro</a></li>
	</ul>
	<div class="container-fluid text-center">
		<table class="table table-bordered" style="margin-top: 60px;">
			<thead class="thead-dark">
				<tr>
					<th>Id consulta</th>
					<th>Nome do cliente</th>
					<th>Nome do pet</th>
					<th>Id tipo do pet</th>
					<th>Id do veterinário</th>
					<th>Data da consulta</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getId_consulta()%></td>
					<td><%=lista.get(i).getNome_cliente()%></td>
					<td><%=lista.get(i).getNome_pet()%></td>
					<td><%=lista.get(i).getId_anim()%></td>
					<td><%=lista.get(i).getId_vet()%></td>
					<td><%=lista.get(i).getData_consulta()%></td>
					<td><a
						style="text-decoration: none; background-color: white; color: black;"
						href="edit?id_consulta=<%=lista.get(i).getId_consulta()%>"><i
							class="bi bi-pencil-fill"></i></a> <a
						style="text-decoration: none; background-color: white; color: black;"
						href="javascript: confirmar(<%=lista.get(i).getId_consulta()%>)"><i
							class="bi bi-x-lg"></i></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<div class="container-fluid text-center">
		<h1>Editar consultas</h1>
	</div>

	<div class="container">
		<form name="frmConsulta" action="update"
			style="max-width: 500px; margin: 0 auto;">
			<div class="form-group">
				<input type="text" name="id_consulta" class="form-control" readonly
					value="<%out.print(request.getAttribute("id_consulta"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputNome_Cliente">Nome do cliente:</label> <input
					type="text" name="nome_cliente" class="form-control"
					placeholder="Nome do cliente"
					value="<%out.print(request.getAttribute("nome_cliente"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputNome_Pet">Nome do pet:</label> <input
					type="text" name="nome_pet" class="form-control"
					placeholder="Nome do pet"
					value="<%out.print(request.getAttribute("nome_pet"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputId_Anim">Id tipo do animal:</label> <input
					type="text" name="id_anim" class="form-control"
					placeholder="Id tipo do animal"
					value="<%out.print(request.getAttribute("id_anim"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputId_Vet">Id do veterinário:</label> <input
					type="text" name="id_vet" class="form-control"
					placeholder="Id do veterinário"
					value="<%out.print(request.getAttribute("id_vet"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputData_Consulta">Data da consulta:</label> <input
					type="text" name="data_consulta" class="form-control"
					placeholder="Data da consulta:(DD/MM/AAAA)"
					value="<%out.print(request.getAttribute("data_consulta"));%>">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary" onclick="validar()">Salvar</button>
			</div>
		</form>
	</div>


	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">

	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
	<script src="scripts/Confirmador.js"></script>
</body>
</html>