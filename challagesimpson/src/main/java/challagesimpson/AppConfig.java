package challagesimpson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import challagesimpson.interfaces.IDataBase;
import challagesimpson.interfaces.IRepository;
import challagesimpson.interfaces.IService;
import challagesimpson.repository.CharactersRepository;
import challagesimpson.repository.PhrasesRepository;
import challagesimpson.utility.CharactersUtility;
import challagesimpson.utility.PharasesUtility;
import challagesimpson.datasim.DataBaseSim;
import model.Characters;
import model.Phrases;


public class AppConfig {

	
	@Autowired
	IService<Characters> charactersService;
	
	@Autowired
	IService<Phrases> phrasesService;

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ObjectMapper GetObjectMapper() {
		return new ObjectMapper();
	};
	
	@Bean
	public DataBaseSim GetDatabasesim() {
		return new DataBaseSim();
	};
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Gson GetGson() {
		return new Gson();
	};

	@Bean
	public IDataBase<Phrases> getUtilityPhrases() {
		return new PharasesUtility(GetDatabasesim());
	};

	@Bean
	public IRepository<Phrases> getPhrasesRepository() {
		return new PhrasesRepository();
	};

	@Bean
	public IService<Phrases> getPharasesService() {
		return phrasesService;
	};

	@Bean
	public IDataBase<Characters> getUtilityCharacters() {
		return new CharactersUtility(GetDatabasesim());
	};

	@Bean
	public IRepository<Characters> getCharactersRepository() {
		return new CharactersRepository();
	};

	@Bean
	public IService<Characters> getCharactersService() {
		return charactersService;
	};

	
}
