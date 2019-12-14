package challagesimpson;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import challagesimpson.datasim.DataBaseSim;
import challagesimpson.utility.PharasesUtility;
import model.Phrases;



public class TestPharaseUtil {

	DataBaseSim DBS;
	PharasesUtility CU;
	
	@Before
	public void SetUp() 
	{
		DBS = mock(DataBaseSim.class);
		seedData();
	}
	
	public void seedData() 
	{
		when(DBS.GetData("Phrases_tbl")).thenReturn("{\r\n" + 
				"  \"data\": [{\r\n" + 
				"      \"_id\": \"mockId123\",\r\n" + 
				"      \"character\": \"59edee68706374dfa957842f\",\r\n" + 
				"      \"phrase\": \"Wait a minute. Bartâ€™s teacher is named â€˜Krabappelâ€™? Oh, Iâ€™ve been calling her â€˜Crandall.â€™ Why didnâ€™t anyone tell me? Ohhh, Iâ€™ve been making an idiot out of myself!\"\r\n" + 
				"    }]\r\n" + 
				"}");
		
		CU = spy(new PharasesUtility(DBS));
		CU.GetObjectMapper(new ObjectMapper());
		CU.GetObjectMapper(new Gson());
	}
	
	@Test
	public void GetAllPharases() 
	{		
		ArrayList<Phrases> d= CU.get().getData();	
		assertEquals(d.size(),1);
	}
	
	@Test
	public void GetPharasesById() 
	{
		ArrayList<Phrases> d= CU.get().getData();
		Phrases dw = new ObjectMapper().convertValue(d.get(0), Phrases.class);
		assertEquals("mockId123",CU.getById("mockId123").get_id());
	}
	
	@Test
	public void DeletePharases() 
	{
		try {
			assertEquals(0,CU.detete("mockId123").size());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void UpdatePharases() 
	{
		ArrayList<Phrases> d= CU.get().getData();
		Phrases dw = new ObjectMapper().convertValue(d.get(0), Phrases.class);
		dw.setCharacter("59edee687");
		try {
			assertEquals("59edee687",CU.updateOrcreate("59edee687", dw).getCharacter());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void CreatePharases() 
	{
		ArrayList<Phrases> d= CU.get().getData();
		Phrases dw = new ObjectMapper().convertValue(d.get(0), Phrases.class);
		dw.setCharacter("car3333");
		dw.set_id("newIdP");
		try {
			assertEquals("newIdP",CU.updateOrcreate("NewId", dw).get_id());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
