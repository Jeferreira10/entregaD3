<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Filmes</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<%@page import="service.*" %>
    <%@page import="model.*" %>
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
        <h3 class="page-header">Filmes</h3>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Filme</th>
		      <th scope="col">Gênero</th>
		      <th scope="col">Idioma</th>
		    </tr>
		  </thead>
		  <tbody>
		  <%! private String idiomas = "";%>
	  	  <%for (Filme filme : new FilmeService().listar()) {%>
			  	<tr>
			      <td><%=filme.getNome()%></td>
			      <td><%=filme.getGenero()%></td>
			      
			      <%for (Idioma idioma : new IdiomaService().listarIdiomasDoFilme(filme.getId())) { 
			    	  idiomas += idioma.getNome() + ", ";
			      }
			      idiomas = idiomas.substring(0, idiomas.length() - 2);%>
			      <td><%= idiomas%></td>
			      <%idiomas = ""; %>
			    </tr>
	  	  <%}%>
		    
		  </tbody>
		</table>
        
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>