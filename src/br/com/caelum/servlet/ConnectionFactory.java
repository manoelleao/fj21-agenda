package br.com.caelum.servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException {
      //  System.out.println("Conectando ao banco");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/testaconexao", "root", "");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String args[]){
    	
    }
}