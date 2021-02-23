package it.objectmethod.worldmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.worldmvc.config.ConnectionFactory;
import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.domain.City;

public class CityDaoImpl implements ICityDao {

	@Override
	public City getCityById(int idCity) {
		Connection conn = ConnectionFactory.getConnection();
		City city = null;

		String sql = "SELECT * FROM city WHERE ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, idCity);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				city = new City();
				city.setId(rs.getInt("ID"));
				city.setCountryCode(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getInt("Population"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return city;
	}

	@Override
	public List<City> getCitiesByMinPopulation(int population) {
		Connection conn = ConnectionFactory.getConnection();
		List<City> cities = new ArrayList<City>();
		String sql = "SELECT * FROM city WHERE Population > ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, population);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				City city = new City();
				city.setId(rs.getInt("ID"));
				city.setCountryCode(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setPopulation(rs.getInt("Population"));
				cities.add(city);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cities;
	}

}
