package esercizio3;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main3 {
	public static Logger logger = LoggerFactory.getLogger(Main3.class);

	public static void main(String[] args) {
		RegistroPresenze.aggiungiPresenze("Rezzonico", 30);
		RegistroPresenze.aggiungiPresenze("Brazorf", 16);
		RegistroPresenze registroPresenze = new RegistroPresenze();
		try {
			String fileContent = registroPresenze.leggiFile();
			System.out.println(fileContent);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}
}
