package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/lp2";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    
    /**
     * @since 08/06/2017
     * @author Francielli
     * @return conexao com o banco de dados
     * @throws SQLException 
     */
    public static Connection getConnection(){
            try {
				return DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				throw new RuntimeException("Erro na conexão com o banco de dados!");
			}
    }
    
    public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		System.out.println("Conectado com sucesso!");
	}
    
}
