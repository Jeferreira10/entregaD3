package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FilmeService;
import model.Filme;
import java.util.List;

public class ListarFilmesPorIdioma implements Command
{
	@Override
	public void executar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{	
		String value = request.getParameter("idioma");
	
		if(value!= null)
		{
			int idIdioma = Integer.parseInt(value);
			request.setAttribute("idiomaPesquisado", idIdioma);
			request.setAttribute("filmes", new FilmeService().listarFilmesPorIdioma(idIdioma));
			request.getRequestDispatcher("ListarFilmesPorIdioma.jsp").forward(request, response);
		}

	}
	
	

}
































