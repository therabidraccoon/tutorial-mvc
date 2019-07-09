package it.objectmethod.worldmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.worldmvc.config.ConnectionFactory;
import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.domain.City;

public class CityDaoImpl implements ICityDao {

	@Override
	public City getCityById(int idCity) {
		City city = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM city WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCity);
			rs = stmt.executeQuery();
			while (rs.next()) {
				city = new City();
				city.setId(rs.getInt("ID"));
				city.setCountryCode(rs.getString("CountryCode"));
				city.setName(rs.getString("Name"));
				city.setDistrict(rs.getString("District"));
				city.setPopulation(rs.getInt("Population"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}			
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}	
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return city;
	}

}
