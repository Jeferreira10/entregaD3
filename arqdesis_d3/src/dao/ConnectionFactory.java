package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException ex) 
		{
			throw new RuntimeException(ex);
		}
				
	}
	
	public static Connection retornaConexao() throws SQLException
	{
		return DriverManager.
				getConnection("jdbc:mysql://localhost:3306/arqdesis_d3?autoReconnect=true&useSSL=false", "root", "123456");
		
	}
	
	
}
