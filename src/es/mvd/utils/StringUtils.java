package es.mvd.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	// Genera cadena basada en la hora actual con precisión de segundos.
	public static String FastDateFormat () {
		DateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return df.format(new Date());
	}

}
