package model;

import java.util.ArrayList;
import java.util.List;

public class Filme 
{
	private int id;
	private String nome, genero;
	private List<Idioma> idiomas;
	
	public Filme() 
	{
		idiomas = new ArrayList<Idioma>();
	}
	
	public Filme(int id, String nome, String genero, List<Idioma> idiomas) 
	{
		setId(id);
		setNome(nome);
		setGenero(genero);
		setIdiomas(idiomas);
	}

	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getGenero() 
	{
		return genero;
	}
	
	public void setGenero(String genero) 
	{
		this.genero = genero;
	}

	public List<Idioma> getIdiomas()
	{
		return idiomas;
	}
	
	public void setIdiomas(List<Idioma> idiomas)
	{
		this.idiomas = idiomas;
	}
	
	

}
