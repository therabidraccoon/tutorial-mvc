package it.objectmethod.worldmvc.validators;

import it.objectmethod.worldmvc.domain.City;

public class CityValidator {
	
    public boolean validate(City city) {
    	boolean valid = true;
    	if(city.getPopulation() < 0) {
    		valid = false;
    	}
    	return valid;
    }

}
