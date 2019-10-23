package com.virtusa.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.helper.FactoryAdminService;

/**
 * Servlet implementation class AddPlacements
 */
@WebServlet("/AddPlacements")
public class AddPlacements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlacements() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id =	Integer.parseInt(request.getParameter("placement_Id"));
		String companyName = request.getParameter("company_name");
		String date = request.getParameter("date");
		double percentage = Double.parseDouble(request.getParameter("percentage"));
		boolean result = FactoryAdminService.createAdminService().addPlacementsService(id, companyName, date, percentage);
		System.out.println(result);
		 if(result==true)
		 {
			// System.out.print("<p>Data Added Successfully!!!!!!");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Succesfully.jsp");
			 doGet(request, response);
		 }
		 else
		 {
			 //System.out.print("<p>Data Added Successfully!!!!!!");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Unsuccesfull.html");
			 doGet(request, response);
		 }
		
		
		
		doGet(request, response);
	}

}
