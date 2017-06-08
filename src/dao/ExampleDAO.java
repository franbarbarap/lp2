package dao;

import java.util.ArrayList;

import lp2.Example;

/**
 * 
 * Definicao dos metodos necessarios para as classes DAO da classe Example
 * @since 08/06/2017
 * @author Francielli
 *
 */
public interface ExampleDAO {
	public void save(Example example);
	public void delete(Example example);
	public ArrayList<Example> list();
}
