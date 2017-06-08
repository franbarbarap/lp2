package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lp2.Example;
import utils.Utils;

/**
 * Implementa ExampleDAO usando JDBC
 * @since 08/07/2017
 * @author Francielli
 *
 */
public class JDBCExampleDAO implements ExampleDAO{
	private Connection conn;
	
	public JDBCExampleDAO() {
		this.conn = ConnectionFactory.getConnection();
	}

	/**
	 * Salva um Example no banco de dados
	 * @since 08/06/2017
	 * @author Francielli
	 * @param example
	 */
	@Override
	public void save(Example example) {
		String sql = "INSERT INTO example (date) VALUES (?);";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setTimestamp(1, Utils.toTimestamp(example.getDate()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Exclui um (ou mais) Examples do banco de dados
	 * @since 08/06/2017
	 * @author Francielli
	 * @param example
	 */
	@Override
	public void delete(Example example) {
		String sql = "DELETE FROM example WHERE id = ?;";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, example.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Lista todos os Examples presentes no banco de dados
	 * @since 08/06/2017
	 * @author Francielli
	 * return lista de Examples
	 */
	@Override
	public ArrayList<Example> list() {
		String sql = "SELECT * FROM example;";
		try {
			ArrayList<Example> dates = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Example example = new Example();
				example.setId(rs.getLong("id"));
				example.setDate(Utils.toGregorianCalendar(rs.getTimestamp("date")));
				dates.add(example);
			}
			rs.close();
			stmt.close();
			return dates;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		JDBCExampleDAO exampleDao = new JDBCExampleDAO();
		
		//inserindo dados
		for(int i=0; i<10;i++){
			exampleDao.save(new Example());
		}
		
		//listando os dados
		ArrayList<Example> examples = exampleDao.list();
		for(Example example : examples){
			System.out.println(example);
		}
		System.out.println("Total de Examples: " + examples.size());
		
		//deletando dados
		Example exampleToDelete = examples.get(0);
		System.out.println("Deletando Example: " + exampleToDelete);
		exampleDao.delete(exampleToDelete);
		
		//listando os dados novamente
		examples = exampleDao.list();
		for(Example example : examples){
			System.out.println(example);
		}
		System.out.println("Total de Examples: " + examples.size());
	}
	
}
