// Mysti Freed, mrfreed@dmacc.edu
// 10/2/2018
// This servlet works in combination with the addOwnerInfo.html, OwnerInfo.java and CarRegistrationRun.java programs to add an
// owner to the MySQL Database webcarregistration via the owner_info table

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OwnerInfo;
import model.RegistrationJunction;

/**
 * Servlet implementation class addOwnerServlet
 */
@WebServlet("/addOwnerServlet")
public class addOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOwnerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		OwnerInfo owner = new OwnerInfo(firstName, lastName);
		RegistrationJunction junctionID = new RegistrationJunction();
		RegistrationHelper rh = new RegistrationHelper();
		rh.addOwner(owner);
		rh.setJunctionID(junctionID);
		getServletContext().getRequestDispatcher("/addNewEntry.html").forward(request, response);
	}
}
