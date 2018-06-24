<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastro</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<%@page import="service.IdiomaService" %>
    <%@page import="model.Idioma" %>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="CadastrarFilme.jsp">Cadastro</a>
                <a class="navbar-brand" href="ListarFilmes.jsp">Filmes</a>
                <a class="navbar-brand" href="ListarFilmesPorIdioma.jsp">Filmes por idioma</a>
            </div>
			<div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="CadastrarIdioma.html">Cadastrar Idioma</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <div id="main" class="container">
        <h3 class="page-header">Cadastrar Filme</h3>

        <form action="controller.do" method="post">
		
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="50" placeholder="nome do filme">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Gênero</label>
                    <input type="text" class="form-control" name="genero" id="genero" required maxlength="50" placeholder="gênero do filme">
                </div>            
            </div>
            <div class="form-check form-check-inline">
              <label for="idiomas">Idiomas</label>
              <br />
              <%for (Idioma idioma : new IdiomaService().listar()) {%>
				  <input class="form-check-input" type="checkbox" name="<%= "idioma" + idioma.getId()%>" value="<%= idioma.getId()%>">
				  <label class="form-check-label" for="inlineCheckbox1"><%= idioma.getNome()%></label>
			  <%}%>
			</div>
			
			<hr />
			
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CadastrarFilme">Salvar</button>
                    <a href="CadastrarFilme.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>