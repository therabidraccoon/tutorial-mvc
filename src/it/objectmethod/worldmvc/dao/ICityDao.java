package it.objectmethod.worldmvc.dao;

import java.util.List;

import it.objectmethod.worldmvc.domain.City;

public interface ICityDao {

	public City getCityById(int idCity);

	public List<City> getCitiesByMinPopulation(int population);

}
