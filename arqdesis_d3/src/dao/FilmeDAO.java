package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Filme;;

public class FilmeDAO 
{
	public int inserir(Filme filme)
	{
		String sql = "INSERT INTO filmes (nome, genero) VALUES (?,?)";
		
		try (Connection conn = ConnectionFactory.retornaConexao();
				PreparedStatement stm = conn.prepareStatement(sql);)
		{
			stm.setString(1, filme.getNome());
			stm.setString(2, filme.getGenero());
			stm.execute();
			
			sql = "SELECT LAST_INSERT_ID()";
			
			try (PreparedStatement stm2 = conn.prepareStatement(sql);
					ResultSet rs = stm2.executeQuery();)
			{
				if(rs.next())
					filme.setId(rs.getInt(1));
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return filme.getId();
	}
	
	public List<Filme> listar()
	{
		List<Filme> filmes = new ArrayList<Filme>();
		
		String sql = "SELECT * FROM filmes";
		
		try (Connection conn = ConnectionFactory.retornaConexao();
				PreparedStatement stm = conn.prepareStatement(sql);
				ResultSet rs = stm.executeQuery())
		{
			while (rs.next()) 
			{
				Filme filme = new Filme();	
				filme.setId(rs.getInt("id"));
				filme.setNome(rs.getString("nome"));
				filme.setGenero(rs.getString("genero"));
				
				filmes.add(filme);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return filmes;
	}
	
	public List<Filme> listarFilmesPorIdioma(int idIdioma)
	{
		List<Filme> filmes = new ArrayList<Filme>();
		
		String sql = "SELECT filme.* FROM filmes_idiomas filme_idioma " +
						"INNER JOIN filmes filme " + 
						"ON filme.id = filme_idioma.idFilme " + 
						"INNER JOIN idiomas idioma " + 
						"ON idioma.id = filme_idioma.idIdioma " + 
						"WHERE idioma.id = ?";
		
		
		try (Connection conn = ConnectionFactory.retornaConexao();
				PreparedStatement stm = conn.prepareStatement(sql);)
		{
			stm.setInt(1, idIdioma);
			
			try(ResultSet rs = stm.executeQuery();) 
			{
				while (rs.next()) 
				{
					Filme filme = new Filme();	
					filme.setId(rs.getInt("id"));
					filme.setNome(rs.getString("nome"));
					filme.setGenero(rs.getString("genero"));
					
					filmes.add(filme);
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return filmes;
	}

}




























