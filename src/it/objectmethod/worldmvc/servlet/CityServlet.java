package it.objectmethod.worldmvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.dao.impl.CityDaoImpl;
import it.objectmethod.worldmvc.domain.City;

@WebServlet("/city")
public class CityServlet extends HttpServlet {

	private static final long serialVersionUID = -3118446594378123909L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idCityStr = req.getParameter("id_city");
		ICityDao cityDao = new CityDaoImpl();
		City city = null;
		try {
			int idCity = Integer.parseInt(idCityStr);
			city = cityDao.getCityById(idCity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("city", city);
		req.getRequestDispatcher("pages/show-city.jsp").forward(req, resp);
	}
}
