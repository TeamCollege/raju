package com.virtusa.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.converter.DateConverter;
import com.virtusa.helper.FactoryAdminService;
import com.virtusa.model.FacultyModel;
import com.virtusa.service.AdminService;
import com.virtusa.service.AdminServiceImpl;

/**
 * Servlet implementation class AddFaculty
 */
@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminServiceImpl adminServiceImpl;
	AdminService adminService;
	FactoryAdminService factoryAdminService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFaculty() {
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
		
		DateTimeFormatter formatter = null;
		LocalDate localDate = null;
		String id = request.getParameter("faculty_Id");
		String firstName=request.getParameter("first_name");
    	String lastName=request.getParameter("last_name");
    	String dob=request.getParameter("dob");
    	formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        localDate = LocalDate.parse(dob, formatter);
    	String email=request.getParameter("email_id");
    	String phoneNumber=request.getParameter("phone_number");
    	String departmentName=request.getParameter("department_name");
    	//double salary = Double.parseDouble(request.getParameter("salary"));
    	int salary =Integer.parseInt(request.getParameter("salary"));
    	FacultyModel facultyModel = new FacultyModel();
    	facultyModel.setFacultyId(id);
    	facultyModel.setFirstName(firstName);
    	facultyModel.setLastName(lastName);
    	facultyModel.setDateOfBirth(localDate);
    	facultyModel.setEmail(email);
    	facultyModel.setPhoneNumber(phoneNumber);
    	facultyModel.setDepartmentName(departmentName);
    	facultyModel.setSalary(salary);
    	
    	String result = factoryAdminService.createAdminService().addFacultyService(facultyModel);
    	if(result.contentEquals("success"))
    	{
    		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Succesfully.jsp");
			 doGet(request, response);
    	}
    	
    	
    	
    	
    	
    	doGet(request, response);
	}

}
