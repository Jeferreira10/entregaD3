package service;

import java.util.List;

import model.Filme;
import dao.FilmeDAO;

public class FilmeService 
{
	private FilmeDAO dao;
	
	public FilmeService()
	{
		dao = new FilmeDAO();
	}
	
	public void inserir(Filme filme)
	{
		dao.inserir(filme);
	}
	
	public List<Filme> listar()
	{
		return dao.listar();
	}
	
	public List<Filme> listarFilmesPorIdioma(int idIdioma)
	{
		return dao.listarFilmesPorIdioma(idIdioma);
	}
}
