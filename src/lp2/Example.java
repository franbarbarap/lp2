package lp2;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Classe utilizada para demonstração da manipulação de datas utilizando a classe GregorianCalendar
 * @since 08/06/2017
 * @author Francielli
 *
 */
public class Example {
	private long id;
	private GregorianCalendar date;
	
	public Example(){
		setDate(new GregorianCalendar());
	}

	/**
	 * @since 08/06/2017
	 * @author Francielli
	 * @return copia do atributo date
	 */
	public GregorianCalendar getDate() {
		return (GregorianCalendar)this.date.clone();
	}

	/**
	 * Atribui a date uma copia da instancia de GregorianCalendar passada como parametro
	 * @since 08/07/2017
	 * @author Francielli
	 * @param date
	 */
	public void setDate(GregorianCalendar date) {
		this.date = (GregorianCalendar)date.clone();
	}
	
	/**
	 * @since 08/07/2017
	 * @author Francielli
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @since 08/07/2017
	 * @author Francielli
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Reescrita do metodo toString da classe Object
	 * @return a data no formato dd/MM/yyyy HH:mm
	 */
	@Override
	public String toString(){
		//especifica o formato da data
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		//retorna uma string que representa a data no formato especificado
	    String dateFormatted = simpleDateFormat.format(this.date.getTime());
	    return "id = " + this.getId() + "; date = " + dateFormatted;
	}
	
	public static void main(String[] args) {
		Example example = new Example();
		System.out.println(example);
	}
}
