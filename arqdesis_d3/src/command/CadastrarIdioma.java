package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Idioma;
import service.IdiomaService;

public class CadastrarIdioma implements Command
{
	@Override
	public void executar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		
		inserirIdioma(request.getParameter("idioma"));
		request.getRequestDispatcher("CadastrarFilme.jsp").forward(request, response);
		
	}
	
	public Idioma inserirIdioma(String nome)
	{
		Idioma idioma = new Idioma();
		idioma.setNome(nome);

		IdiomaService service = new IdiomaService();
		service.inserir(idioma);
		
		return idioma;
	}

}
