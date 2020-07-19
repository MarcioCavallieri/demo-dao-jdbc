package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	private static Connection con = null;
	
	public static Connection getConnection() {
		if (con == null) {
			Properties prop = carregarPropriedades();
			String url = prop.getProperty("dburl");
			
			try
			{			  
				con = DriverManager.getConnection(url, prop);
			}
			catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		
		return con;
	}
	
	private static Properties carregarPropriedades() {
		try(FileInputStream fs = new FileInputStream("db.properties"))
		{
			Properties prop = new Properties();
			prop.load(fs);
			
			return prop;
		}
		catch(IOException e) {
			throw new DBException(e.getMessage());
		}
	}
	
	public static void fecharConexao() {
		if (con != null) {
			try {
				con.close();
			}
			catch (SQLException e) {
				throw new DBException(e.getMessage());			
			}
		}
	}
	
	public static void fecharStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void fecharPreparedStatement(PreparedStatement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void fecharResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
}
