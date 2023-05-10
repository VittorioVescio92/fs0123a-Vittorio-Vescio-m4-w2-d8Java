package esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	private String name;
	private int nPresenze;
	private static Map<String, Integer> registroPresenze = new HashMap<>();
	private static File file = new File("info.txt");

	public static void aggiungiPresenze(String name, int nPresenze) {
		try {
			registroPresenze.put(name, nPresenze);
			FileUtils.writeStringToFile(file, name + "@" + nPresenze + "#" + System.lineSeparator(), "UTF-8", true);
		} catch (IOException e) {
			Main3.logger.info(e.getMessage());
		}
		System.out.println("Hai aggiunto le presenze di " + name);
	}

	public String leggiFile() throws IOException {
		if (file.exists()) {
			String content = FileUtils.readFileToString(file, "UTF-8");
			return content;
		} else {
			System.out.println("FILE NON TROVATO!");
			return "";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getnPresenze() {
		return nPresenze;
	}

	public void setnPresenze(int nPresenze) {
		this.nPresenze = nPresenze;
	}

	public static Map<String, Integer> getRegistroPresenze() {
		return registroPresenze;
	}

	public static void setRegistroPresenze(Map<String, Integer> registroPresenze) {
		RegistroPresenze.registroPresenze = registroPresenze;
	}
}
