package interfaces;

import java.util.ArrayList;

import model.Data;
import model.Phrases;

public interface IPharasesService {

	Data<Phrases> findAll();
	 
	Phrases findById(String id);

	ArrayList<Phrases> deleteById(String id);
	
	Phrases save(Phrases p);

}