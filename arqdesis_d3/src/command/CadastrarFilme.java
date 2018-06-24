package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import service.*;

public class CadastrarFilme implements Command
{
	@Override
	public void executar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		
		Filme filme = inserirFilme(request.getParameter("nome"), request.getParameter("genero"));

		int count = new IdiomaService().listar().size();
		
		for (int i = 1; i <= count; i++) 
		{
			Idioma idioma = new Idioma();
			String value = request.getParameter("idioma" + i);
			
			if(value != null)
			{
				idioma.setId(Integer.parseInt(value));
				filme.getIdiomas().add(idioma);
			}
		}
		
		inserirIdiomasDoFilme(filme);
		
		request.setAttribute("filme", filme);
		request.getRequestDispatcher("FilmeCadastrado.jsp").forward(request, response);
		
	}
	
	public Filme inserirFilme(String nome, String genero)
	{
		Filme filme = new Filme();
		filme.setNome(nome);
		filme.setGenero(genero);

		FilmeService service = new FilmeService();
		service.inserir(filme);
		
		return filme;
	}
	
	public void inserirIdiomasDoFilme(Filme filme)
	{
		IdiomaService service = new IdiomaService();
		
		service.inserirIdiomasDoFilme(filme.getId(), filme.getIdiomas());
	}
	
	 
}















