package it.objectmethod.worldmvc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.dao.impl.CityDaoImpl;
import it.objectmethod.worldmvc.domain.City;

@WebServlet("/list-cities")
public class ListCityServlet extends HttpServlet {

	private static final long serialVersionUID = -3050354518677187361L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<City> list = new ArrayList<>();
		ICityDao cityDao = new CityDaoImpl();
		list = cityDao.getCitiesByMinPopulation(1000000);
		req.setAttribute("cityList", list);
		req.getRequestDispatcher("pages/show-cities.jsp").forward(req, resp);
	}

}
