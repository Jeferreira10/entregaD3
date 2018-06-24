package service;

import java.util.List;

import dao.IdiomaDAO;
import model.Idioma;

public class IdiomaService 
{
	private IdiomaDAO dao;
	
	public IdiomaService()
	{
		dao = new IdiomaDAO();
	}
	
	public void inserir(Idioma idioma)
	{
		dao.inserir(idioma);
	}
	
	public void inserirIdiomasDoFilme(int idFilme, List<Idioma> idiomas)
	{
		dao.inserirIdiomasDoFilme(idFilme, idiomas);
	}
	
	public List<Idioma> listar()
	{
		return dao.listar();
	}
	
	public List<Idioma> listarIdiomasDoFilme(int idFilme)
	{
		return dao.listarIdiomasDoFilme(idFilme);
	}
}
