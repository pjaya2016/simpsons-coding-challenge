package challagesimpson;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import challagesimpson.datasim.DataBaseSim;
import challagesimpson.utility.CharactersUtility;
import model.Characters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class TestCharacterUtil {

	DataBaseSim DBS;
	CharactersUtility CU;
	
	@Before
	public void SetUp() 
	{
		DBS = mock(DataBaseSim.class);
		seedData();
	}
	
	public void seedData() 
	{
		when(DBS.GetData("Characters_tbl")).thenReturn("{\r\n" + 
				"  \"data\": [{\r\n" + 
				"      \"_id\": \"mockId123\",\r\n" + 
				"      \"firstName\": \"Homer\",\r\n" + 
				"      \"lastName\": \"Simpson\",\r\n" + 
				"      \"picture\": \"http://www.trbimg.com/img-573a089a/turbine/ct-homer-simpson-live-pizza-debate-met-0517-20160516\",\r\n" + 
				"      \"age\": 43\r\n" + 
				"    }]\r\n" + 
				"}");
		
		CU = spy(new CharactersUtility(DBS));
		CU.GetObjectMapper(new ObjectMapper());
		CU.GetObjectMapper(new Gson());
	}
	
	@Test
	public void GetAllCharacters() 
	{		
		ArrayList<Characters> d= CU.get().getData();	
		assertEquals(d.size(),1);
	}
	
	@Test
	public void GetCharacterById() 
	{
		ArrayList<Characters> d= CU.get().getData();
		Characters dw = new ObjectMapper().convertValue(d.get(0), Characters.class);
		assertEquals("mockId123",CU.getById("mockId123").get_id());
	}
	
	@Test
	public void DeleteCharacter() 
	{
		try {
			assertEquals(0,CU.detete("mockId123").size());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void UpdateCharacter() 
	{
		ArrayList<Characters> d= CU.get().getData();
		Characters dw = new ObjectMapper().convertValue(d.get(0), Characters.class);
		dw.setAge(18);
		dw.setFirstName("Jay234");
		try {
			assertEquals("Jay234",CU.updateOrcreate("mockId123", dw).getFirstName());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void CreateCharacter() 
	{
		ArrayList<Characters> d= CU.get().getData();
		Characters dw = new ObjectMapper().convertValue(d.get(0), Characters.class);
		dw.setAge(18);
		dw.set_id("NewId");
		dw.setFirstName("Jay234");
		try {
			assertEquals("NewId",CU.updateOrcreate("NewId", dw).get_id());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
