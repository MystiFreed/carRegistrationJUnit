package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AutoInfo;
import model.OwnerInfo;
import model.RegistrationJunction;

/**
 * Servlet implementation class addNewEntryServlet
 */
@WebServlet("/addNewEntryServlet")
public class addNewEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewEntryServlet() {
        super();
        
    }

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationHelper rh = new RegistrationHelper();
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String vin = request.getParameter("vin");
		AutoInfo vehicle = new AutoInfo(make, model, year, vin);
		rh.addVehicle(vehicle);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		OwnerInfo owner = new OwnerInfo(firstName, lastName);
		rh.addOwner(owner);
		
		rh.setJunctionID(vehicle, owner);
		getServletContext().getRequestDispatcher("/addNewEntry.html").forward(request, response);
	}

}
