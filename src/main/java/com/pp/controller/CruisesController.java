package com.pp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pp.model.Cruise;
import com.pp.model.Yacht;
import com.pp.repository.CruisesRepository;
import com.pp.repository.YachtsRepository;
import com.pp.service.CruiseService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/CruisesController")
public class CruisesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CruiseService cruiseService = CruiseService.getInstance();
	CruisesRepository cruisesRepository = CruisesRepository.getInstance();
	YachtsRepository yachtsRepository = YachtsRepository.getInstance();
	String task = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		task = request.getParameter("task");
		if (task == null)
			task = "listCruises";

		switch (task) {
		case "addCruise":
			createCruise(request, response);
			break;
		case "listCruises":
			listCruises(request, response);
			break;
		case "showCruise":
			showCruise(request, response);
			break;
		case "editCruise":
			editCruise(request, response);
			break;
		case "updateCruise":
			updateCruise(request, response);
			break;
		case "deleteCruise":
			deleteCruise(request, response);
			break;
		case "addRandomCruise":
			Cruise cruise = cruiseService.getRandomCruise();
			cruisesRepository.saveCruise(cruise);
			listCruises(request, response);
			break;
		case "addYacht":
			createYacht(request, response);
			break;
		case "listYachts":
			listYachts(request, response);
			break;
		case "showYacht":
			showYacht(request, response);
			break;
		case "editYacht":
			editYacht(request, response);
			break;
		case "updateYacht":
			updateYacht(request, response);
			break;
		case "deleteYacht":
			deleteYacht(request, response);
			break;

		default:
			System.out.println("Switch defaulf");
			listCruises(request, response);
			break;
		}

	}

	private void listCruises(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Cruise> cruises = cruisesRepository.getAllCruises();
		request.setAttribute("cruisesList", cruises);
		request.getRequestDispatcher("cruises-list.jsp").forward(request, response);

	}

	private void showCruise(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cruiseId"));
		request.setAttribute("cruise", cruisesRepository.getCruise(id));
		request.getRequestDispatcher("cruise-view.jsp").forward(request, response);

	}

	private void createCruise(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cruise cruise = new Cruise();
		cruise.setCaptainName(request.getParameter("captainName"));
		cruise.setLocation(request.getParameter("location"));
		cruise.setDistance(Integer.parseInt(request.getParameter("distance")));
		if (request.getParameter("yachtId") != null) {
			int yachtId = Integer.parseInt(request.getParameter("yachtId"));
			Yacht yacht = yachtsRepository.getYacht(yachtId);
			cruise.setYacht(yacht);
		}
		cruisesRepository.saveCruise(cruise);
		listCruises(request, response);
	}

	private void editCruise(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cruiseId"));
		Cruise cruise = cruisesRepository.getCruise(id);
		request.setAttribute("cruiseToUpdate", cruise);
		List<Yacht> yachts = yachtsRepository.getAllYachts();
		request.setAttribute("yachtsList", yachts);
		request.getRequestDispatcher("cruise-update-form.jsp").forward(request, response);

	}

	private void updateCruise(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cruise cruise = getCruiseFromRequest(request, response);
		cruisesRepository.updateCruise(cruise);
		showCruise(request, response);
	}

	private void deleteCruise(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cruiseId"));
		cruisesRepository.deleteCruise(id);
		listCruises(request, response);
	}

	private Cruise getCruiseFromRequest(HttpServletRequest request, HttpServletResponse response) {
		Cruise cruise = new Cruise();
		cruise.setId(Integer.parseInt(request.getParameter("cruiseId")));
		cruise.setCaptainName(request.getParameter("captainName"));
		cruise.setLocation(request.getParameter("location"));
		cruise.setDistance(Integer.parseInt(request.getParameter("distance")));
		System.out.println(request.getParameter("yachtId"));
		if (request.getParameter("yachtId") != null && Integer.parseInt(request.getParameter("yachtId")) != 0) {
			System.out.println("W ifie " + request.getParameter("yachtId"));
			int yachtId = Integer.parseInt(request.getParameter("yachtId"));
			Yacht yacht = yachtsRepository.getYacht(yachtId);
			cruise.setYacht(yacht);
		}
		return cruise;
	}

	// -----------------Yacht-------------------

	private void listYachts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Yacht> yachts = yachtsRepository.getAllYachts();
		request.setAttribute("yachtsList", yachts);
		request.getRequestDispatcher("yachts-list.jsp").forward(request, response);

	}

	private void showYacht(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("yachtId") != null) {
			int yachtId = Integer.parseInt(request.getParameter("yachtId"));
			int cruiseId = Integer.parseInt(request.getParameter("cruiseId"));
			request.setAttribute("yacht", yachtsRepository.getYacht(yachtId));
			System.out.println(cruiseId);
			request.setAttribute("cruiseId", cruiseId);
			request.getRequestDispatcher("yacht-view.jsp").forward(request, response);
		}

	}

	private void createYacht(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Yacht yacht = new Yacht();
		yacht.setYachtName(request.getParameter("yachtName"));
		yacht.setModel(request.getParameter("model"));
		yacht.setLength(Float.parseFloat(request.getParameter("length")));
		yacht.setBerths(Integer.parseInt(request.getParameter("berths")));

		yachtsRepository.saveYacht(yacht);
		listYachts(request, response);
	}

	private void editYacht(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("yachtId"));
		Yacht yacht = yachtsRepository.getYacht(id);
		List<Yacht> yachts = yachtsRepository.getAllYachts();
		request.setAttribute("yachtsList", yachts);
		request.setAttribute("yachtToUpdate", yacht);
		request.getRequestDispatcher("yacht-update-form.jsp").forward(request, response);

	}

	private void updateYacht(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Yacht yacht = new Yacht();
		yacht.setId(Integer.parseInt(request.getParameter("yachtId")));
		yacht.setYachtName(request.getParameter("yachtName"));
		yacht.setModel(request.getParameter("model"));
		yacht.setLength(Float.parseFloat(request.getParameter("length")));
		yacht.setBerths(Integer.parseInt(request.getParameter("berths")));
		yachtsRepository.updateYacht(yacht);
		listYachts(request, response);
	}

	private void deleteYacht(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("yachtId"));
		yachtsRepository.deleteYacht(id);
		listYachts(request, response);
	}

}
