<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produtos</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<form class="form-horizontal" role="form" method="post">
		<div class="page-header">
			<h1>Cadastro de Produto</h1>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="nome">Nome
				Produto:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nome"
					placeholder="Informe o nome">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="preco">Preço:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="preco"
					placeholder="Informe o valor">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>
		</div>
	</form>
</html>