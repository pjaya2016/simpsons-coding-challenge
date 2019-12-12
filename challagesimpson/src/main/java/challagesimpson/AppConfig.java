package challagesimpson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import challagesimpson.interfaces.IDataBase;
import challagesimpson.interfaces.IRepository;
import challagesimpson.interfaces.IService;
import challagesimpson.repository.CharactersRepository;
import challagesimpson.repository.PhrasesRepository;
import challagesimpson.service.CharactersService;
import challagesimpson.service.PhrasesService;
import challagesimpson.utility.CharactersUtility;
import challagesimpson.utility.PharasesUtility;
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
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Gson GetGson() {
		return new Gson();
	};

	@Bean
	public IDataBase<Phrases> getUtilityPhrases() {
		return new PharasesUtility();
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
		return new CharactersUtility();
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
