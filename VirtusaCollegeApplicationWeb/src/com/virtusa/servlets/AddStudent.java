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

import com.virtusa.helper.FactoryAdminService;
import com.virtusa.model.StudentModel;
import com.virtusa.service.AdminService;
import com.virtusa.service.AdminServiceImpl;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminServiceImpl adminServiceImpl;
	AdminService adminService;
	FactoryAdminService factoryAdminService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
		int id = Integer.parseInt(request.getParameter("student_Id"));
		String firstName=request.getParameter("first_name");
    	String lastName=request.getParameter("last_name");
    	String email=request.getParameter("email_id");
    	String phoneNumber=request.getParameter("phone_number");
    	double tenthPercentage = Double.parseDouble(request.getParameter("tenth_percentage"));
    	double interPercentage = Double.parseDouble(request.getParameter("inter_percentage"));
    	String aadharNumber = request.getParameter("aadhar_number");
    	String dob=request.getParameter("dob");
    	formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        localDate = LocalDate.parse(dob, formatter);
    	String departmentName=request.getParameter("department_name");
    	StudentModel studentModel = new StudentModel();
    	studentModel.setStudentId(id);
    	studentModel.setFirstName(firstName);
    	studentModel.setLastName(lastName);
    	studentModel.setEmail(email);
    	studentModel.setPhoneNumber(phoneNumber);
    	studentModel.setTenthPercentage(tenthPercentage);
    	studentModel.setInterPercentage(interPercentage);
    	studentModel.setAadharNumber(aadharNumber);
    	studentModel.setDateOfBirth(localDate);
    	studentModel.setDepartmentName(departmentName);
    	
    	String result =  factoryAdminService.createAdminService().addStudentService(studentModel);
    	if(result.contentEquals("success"))
    	{
    		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Succesfully.jsp");
			 doGet(request, response);
    	}
    	
    	
    	
    	
		doGet(request, response);
	}

}
