package abstractClass;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public abstract class Utility {
	 protected ObjectMapper objMapper;
	 protected Gson gson;
	 protected static Map<String, String> database = new HashMap<String, String>();
	
	public abstract void GetObjectMapper(ObjectMapper objectMapper) ;
	
	public abstract void GetObjectMapper(Gson gn);
	
	protected abstract String GetFile(String fileName);
	
	protected abstract Object seedInMemoryDataBase(String empId);
}
