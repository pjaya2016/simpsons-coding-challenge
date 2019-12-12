package abstract_class;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import challagesimpson.Application;

public abstract class Utility {
	protected ObjectMapper objMapper;
	protected Gson gson;
	protected static Map<String, String> database = new HashMap<String, String>();
	
	@Value("${table.pharase}")
	private String pharaseTableName;

	@Value("${table.characters}")
	private String charactersTableName;
	
	@Value("${file.phrases}")
	private String pharaseFilePath;
	
	@Value("${file.characters}")
	private String charactersFilePath;
	
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


		if (!database.containsKey(pharaseTableName)) {
			String phrasesData = GetFile(pharaseFilePath);
			database.put(pharaseTableName, phrasesData);
		}
		
		if (!database.containsKey(charactersTableName)) {
			String charactersData = GetFile(charactersFilePath);
			database.put(charactersTableName, charactersData);
		}
		
		return database.get(tblName);
	}
}
