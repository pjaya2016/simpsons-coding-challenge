package abstract_class;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import challagesimpson.Application;

public abstract class Utility {
	protected ObjectMapper objMapper;
	protected Gson gson;
	protected static Map<String, String> database = new HashMap<String, String>();

	public abstract void GetObjectMapper(ObjectMapper objectMapper);

	public abstract void GetObjectMapper(Gson gn);

	protected String GetFile(String fileName) {
		ClassLoader classLoader = new Application().getClass().getClassLoader();

		File file = new File(classLoader.getResource(fileName).getFile());

		String content = "";
		try {
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return content;

	}

	protected Object seedInMemoryDataBase(String tblName) {

		if (!database.containsKey("Phrases_tbl")) {
			String phrasesData = GetFile("Files/phrases.json");
			database.put("Phrases_tbl", phrasesData);
		}
		
		if (!database.containsKey("Characters_tbl")) {
			String charactersData = GetFile("Files/characters.json");
			database.put("Characters_tbl", charactersData);
		}
		
		return database.get(tblName);
	}
}
