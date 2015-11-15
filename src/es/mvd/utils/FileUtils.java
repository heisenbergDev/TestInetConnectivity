package es.mvd.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

	// Revisa si el nombre de fichero es válido o no.
	public static boolean isFilenameValid(String file) {
		File f = new File(file);
		try {
			f.getCanonicalPath();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	// Lee fichero con las IP/Puertos a testear	
	public static List<String> leeFicheroIPPuertos(String ficheroIPPuertos) {
		List<String> lines = null;
		if (!(ficheroIPPuertos.isEmpty()) && (isFilenameValid(ficheroIPPuertos))) {
			try {
				lines = Files.readAllLines(Paths.get(ficheroIPPuertos), Charset.forName("UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		return lines;
	}	

	// Guarda una línea en un fichero de texto.
	public static void writeFile(String fileName, String[] lines){
		try {
			File fout = new File(fileName);
			FileOutputStream fos = new FileOutputStream(fout);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			for (String line:lines) {
				osw.write(line);
			}
			osw.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

}
