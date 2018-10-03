package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AutoInfo;
import model.OwnerInfo;

/**
 * Servlet implementation class registrationEditorServlet
 */
@WebServlet("/registrationEditorServlet")
public class registrationEditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationEditorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationHelper rh = new RegistrationHelper();

		//String make = request.getParameter("make");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String vin = request.getParameter("vin");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));

		AutoInfo vehToUpdate = rh.searchByIDAuto(tempId);
		vehToUpdate.setMake(make);
		vehToUpdate.setModel(model);
		vehToUpdate.setYear(year);
		vehToUpdate.setVin(vin);
		rh.updateVehicle(vehToUpdate);
		OwnerInfo ownerToUpdate = rh.searchByIDOwner(tempId);
		ownerToUpdate.setFirstName(firstName);
		ownerToUpdate.setLastName(lastName);
		rh.updateOwner(ownerToUpdate);
		getServletContext().getRequestDispatcher("/viewAllVehiclesServlet").forward(request, response);
		doGet(request, response);
	}
}
