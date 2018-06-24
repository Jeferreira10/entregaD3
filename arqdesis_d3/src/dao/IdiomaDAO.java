package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Filme;
import model.Idioma;

public class IdiomaDAO 
{
	public int inserir(Idioma idioma)
	{
		String sql = "INSERT INTO idiomas (nome) VALUES (?)";
		
		try (Connection conn = ConnectionFactory.retornaConexao();
				PreparedStatement stm = conn.prepareStatement(sql);)
		{
			stm.setString(1, idioma.getNome());
			stm.execute();
			
			sql = "SELECT LAST_INSERT_ID()";
			
			try (PreparedStatement stm2 = conn.prepareStatement(sql);
					ResultSet rs = stm2.executeQuery();)
			{
				if(rs.next())
					idioma.setId(rs.getInt(1));
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return idioma.getId();
	}
	
	public void inserirIdiomasDoFilme(int idFilme, List<Idioma> idiomas)
	{
		String sql = "INSERT INTO filmes_idiomas (idFilme, idIdioma) VALUES (?,?)";
		
		try (Connection conn = ConnectionFactory.retornaConexao();
				PreparedStatement stm = conn.prepareStatement(sql);)
		{
			for (Idioma idioma : idiomas)
			{
				stm.setInt(1, idFilme);
				stm.setInt(2, idioma.getId());
				stm.execute();
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<Idioma> listar()
	{
		List<Idioma> idiomas = new ArrayList<Idioma>();
		
		String sql = "SELECT * FROM idiomas";
		
		try (Connection conn = ConnectionFactory.retornaConexao();
				PreparedStatement stm = conn.prepareStatement(sql);
				ResultSet rs = stm.executeQuery())
		{
			while (rs.next()) 
			{
				Idioma idioma = new Idioma();	
				idioma.setId(rs.getInt("id"));
				idioma.setNome(rs.getString("nome"));
				
				idiomas.add(idioma);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return idiomas;
	}
	
	public List<Idioma> listarIdiomasDoFilme(int idFilme) 
	{
		String sql = "SELECT idioma.* FROM filmes_idiomas filme_idioma " + 
						"INNER JOIN filmes filme " + 
						"ON filme.id = filme_idioma.idFilme " + 
						"INNER JOIN idiomas idioma " + 
						"ON idioma.id = filme_idioma.idIdioma " + 
						"WHERE filme_idioma.idFilme = ?";
		
		List<Idioma> idiomas = new ArrayList<Idioma>();
		
		try (Connection conn = ConnectionFactory.retornaConexao();
				PreparedStatement stm = conn.prepareStatement(sql);) 
		{	
			stm.setInt(1, idFilme);
			
			try (ResultSet rs = stm.executeQuery();) 
			{
				while(rs.next())
				{
					Idioma idioma = new Idioma();
					idioma.setId(rs.getInt("id"));
					idioma.setNome(rs.getString("nome"));	
					
					idiomas.add(idioma);
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
		
		return idiomas;
	}

}
