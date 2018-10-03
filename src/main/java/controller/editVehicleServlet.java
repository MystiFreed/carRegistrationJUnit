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
 * Servlet implementation class editVehicleServlet
 */
@WebServlet("/editVehicleServlet")
public class editVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editVehicleServlet() {
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
		String act = request.getParameter("doThisToVehicle");
		//String act2 = request.getParameter("doThisToOwner");
		if (act == null) {
			 //no button has been selected
			getServletContext().getRequestDispatcher("/viewAllVehiclesServlet").
			forward(request, response);
			} else if (act.equals("Delete Selected Vehicle")) {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AutoInfo vehToDelete = rh.searchByIDAuto(tempId);
				OwnerInfo ownerToDelete = rh.searchByIDOwner(tempId);
				rh.deleteVehicle(vehToDelete);
				rh.deleteOwner(ownerToDelete);
				getServletContext().getRequestDispatcher("/viewAllVehiclesServlet").forward(request, response);
			} else if (act.equals("Edit Selected Vehicle")) {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AutoInfo vehToEdit = rh.searchByIDAuto(tempId);
				OwnerInfo ownerToEdit = rh.searchByIDOwner(tempId);
				request.setAttribute("vehToEdit", vehToEdit);
				request.setAttribute("ownerToEdit", ownerToEdit);
				getServletContext().getRequestDispatcher("/edit-vehicle.jsp").forward(request, response);
			} 
			}
	}
