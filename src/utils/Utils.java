package utils;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
 * Classe que agrupa metodos uteis para todos o projeto
 * @since 08/07/2017
 * @author Francielli
 *
 */
public class Utils {
	/**
	 * Converte um GregorianCalendar em um objeto da classe java.sql.Timestamp
	 * @sincce 08/06/2017
	 * @author Francielli
	 * @param date
	 * @return date
	 */
	public static Timestamp toTimestamp(GregorianCalendar date){
		return new Timestamp(date.getTimeInMillis());
	}
	
	/**
	 * Converte um java.sql.Timestamp em GregorianCalendar
	 * @sincce 08/06/2017
	 * @author Francielli
	 * @param date
	 * @return gregorianCalendar
	 */
	public static GregorianCalendar toGregorianCalendar(Timestamp date){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar;
	}
	
	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar();
		System.out.println(date);
		Timestamp timestamp = Utils.toTimestamp(date);
		System.out.println(timestamp);
		GregorianCalendar newCalendar = Utils.toGregorianCalendar(timestamp);
		System.out.println(newCalendar);
	}
}
