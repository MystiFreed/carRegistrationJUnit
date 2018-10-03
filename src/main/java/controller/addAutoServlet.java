// Mysti Freed, mrfreed@dmacc.edu
// 10/2/2018
// This servlet works in combination with the addAutoInfo.html, AutoInfo.java and CarRegistrationRun.java programs to add a
// vehicle to the MySQL Database webcarregistration via the auto_info table

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AutoInfo;

/**
 * Servlet implementation class addAutoServlet
 */
@WebServlet("/addAutoServlet")
public class addAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAutoServlet() {
        super();
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String vin = request.getParameter("vin");
		AutoInfo vehicle = new AutoInfo(make, model, year, vin);
		RegistrationHelper rh = new RegistrationHelper();
		rh.addVehicle(vehicle);
		getServletContext().getRequestDispatcher("/addAutoInfo.html").forward(request, response);
	}
}
