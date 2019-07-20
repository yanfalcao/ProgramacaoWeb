package dao;

import java.sql.*;

public class Authentication {
	private String user;
	private String password;
	private Connection c;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	private String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getConnect(){
	     try {
			Class.forName("org.postgresql.Driver");
			this.c = DriverManager
				    .getConnection("jdbc:postgresql://localhost:5433/Authentication",
				    "postgres", "*******");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	    
		return true;
	}
	
	public String getValidation(){
		if(this.getConnect()){
			try {
				PreparedStatement validator = this.c.prepareStatement("select * "
																	+ "from login "
																	+ "where login.user = ? "
																	+ "and login.password = ?");
				validator.setString(1, this.getUser());
				validator.setString(2, this.getPassword());
				ResultSet result = validator.executeQuery();
			
				if(result.next())
					return "Login efetuado com sucesso";
				else
					return "--- Usuário ou senha incorretos ---";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return e.toString();
			}
		}
		return "--- Erro de conexão com o banco ---";
	}
}
