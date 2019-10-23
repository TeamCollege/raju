package com.virtusa.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.helper.FactoryAdminService;
import com.virtusa.service.AdminService;
import com.virtusa.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
	AdminServiceImpl adminServiceImpl;
	AdminService adminService;
	FactoryAdminService factoryAdminService;
    public AdminServlet() {
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
		//String action = request.getParameter("action");
		//if(action.contentEquals("addevents"))
		//{
			int id =	Integer.parseInt(request.getParameter("event_Id"));
			String eventName = request.getParameter("event_name");
			String date = request.getParameter("event_date");
			String location = request.getParameter("location");
			boolean result = factoryAdminService.createAdminService().addEventsService(id,eventName, date, location);
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
			
			//}
		
		
	}

}
