package challagesimpson;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import interfaces.IDataBase;
import interfaces.IService;
import model.Characters;
import model.Phrases;
import interfaces.IRepository;
import repository.CharactersRepository;
import repository.PhrasesRepository;
import service.CharactersService;
import service.PhrasesService;
import utility.CharactersUtility;
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
	public IDataBase<Phrases> getUtilityPhrases() 
	{
		return new PharasesUtility();
	};
	
	@Bean
	public IRepository<Phrases> getPhrasesRepository() 
	{
		return new PhrasesRepository();
	};
	
	@Bean
	public IService<Phrases> getPharasesService() 
	{
		return new PhrasesService();
	};
	
	@Bean
	public IDataBase<Characters> getUtilityCharacters() 
	{
		return new CharactersUtility();
	};
	
	@Bean
	public IRepository<Characters> getCharactersRepository() 
	{
		return new CharactersRepository();
	};
	
	@Bean
	public IService<Characters> getCharactersService() 
	{
		return new CharactersService();
	};
	
}
