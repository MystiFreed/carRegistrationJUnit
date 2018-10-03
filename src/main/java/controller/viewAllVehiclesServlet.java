// Mysti Freed, mrfreed@dmacc.edu
// 10/2/2018
// This servlet works in combination with the vehicleList.jsp, AutoInfo.java and CarRegistrationRun.java programs to view all
// vehicles in the MySQL Database webcarregistration via the auto_info table

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllVehicles
 */
@WebServlet("/viewAllVehiclesServlet")
public class viewAllVehiclesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllVehiclesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationHelper rh = new RegistrationHelper();
		request.setAttribute("allVehicles", rh.displayVehicles());
		if(rh.displayVehicles().isEmpty()){
			request.setAttribute("allVehicles", " ");
		}
		getServletContext().getRequestDispatcher("/vehicleList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
