package challagesimpson;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import interfaces.IDataBase;
import interfaces.IPharasesService;
import interfaces.IPhrasesRepository;
import repository.PhrasesRepository;
import service.PhrasesService;
import utility.PharasesUtility;

@Configuration
public class AppConfig {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ObjectMapper GetObjectMapper() 
	{
		return new ObjectMapper();
	};
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Gson GetGson() 
	{
		return new Gson();
	};
	
	@Bean
	public IDataBase GetUtility() 
	{
		return new PharasesUtility();
	};
	
	@Bean
	public IPhrasesRepository GetPhrasesRepository() 
	{
		return new PhrasesRepository();
	};
	
	@Bean
	public IPharasesService GetPharasesService() 
	{
		return new PhrasesService();
	};
	
}
