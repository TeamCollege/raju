 package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.virtusa.dao.AdminDAO;
import com.virtusa.dao.AdminDAOImpl;
import com.virtusa.dao.ApplicantDAOImpl;
import com.virtusa.entities.Applicant;
import com.virtusa.entities.Faculty;
import com.virtusa.entities.Student;
import com.virtusa.helper.FactoryAdminDAO;
import com.virtusa.model.ApplicantModel;
import com.virtusa.model.FacultyModel;
import com.virtusa.model.StudentModel;

public class AdminServiceImpl implements AdminService
{
	AdminDAO adminDAO;
	public AdminServiceImpl()
	{
		this.adminDAO=FactoryAdminDAO.createAdminDAO();
	}

	@Override
	public void approveApplicantService(int applicantNumber) 
	{
		Applicant applicant = new Applicant();
		ArrayList<Applicant> applicants = new ArrayList<Applicant>();
		applicant.getApplicantNumber();
		System.out.println(applicant.getApplicantNumber());
		applicant.getFirstName();
		applicant.getLastName();
		applicant.getEmailAddress();
		applicant.getPhoneNumber();
		applicant.getTenthPercentage();
		applicant.getInterPercentage();
		applicant.getDepartmentName();
		applicant.getAadharNumber();
		applicants.add(applicant);
		Iterator<Applicant> iterator = applicants.iterator();
		while(iterator.hasNext())
		{
			Applicant app = (Applicant)iterator.next();
			if(app.getApplicantNumber()==applicantNumber)
			{
				if(app.getTenthPercentage()>=60.00 && app.getInterPercentage()>=60.00)
				{
					try {
						adminDAO.storeApprovedApplicantDetailsDAO(app);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("-----Applicant is Eligible to take Admissions and has been Approve-----");
					
					
				}
				else
				{
					System.out.println("------Applicant is Not Eligible to take Admissions and has been rejected------");
				}
			}      
			else
			{
				System.out.println("------Applicant Number Not Found------");
			}
		}    
	}	
		//applicantModel=applicantDAOImpl.retrieveApplicant();
		/*if(applicantModel.getTenthPercentage()>60.00 && applicantModel.getInterPercentage()>60.00)
		{
			System.out.println("Applicant is eligible for the admission");
			System.out.println("Applicant Approved Successful ");
		}
		else
		{
			System.out.println("Applicant not eligible");
		}
	}*/
       
	@Override
	public String addStudentService(StudentModel studentModel)
	{
		List<Student> studentList = new ArrayList<Student>();
		Student student = new Student();
		student.setStudentId(studentModel.getStudentId()); 
		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setEmailAddress(studentModel.getEmail());
		student.setPhoneNumber(studentModel.getPhoneNumber());
		student.setTenthPercentage(studentModel.getTenthPercentage());
		student.setInterPercentage(studentModel.getInterPercentage());
		student.setAadharNumber(studentModel.getAadharNumber());
		student.setDateOfBirth(studentModel.getDateOfBirth());
		//student.setCourseName(studentModel.getCourseName());
		student.setDepartmentName(studentModel.getDepartmentName());
		studentList.add(student);
		String result = "failed";
		try {
			boolean stored = adminDAO.storeStudentDetailsDAO(student);
			if(stored)
				result = "success";
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  result;
	}

	@Override
	public boolean deleteStudentService(int studentId) 
	{
		boolean result = false;
		//List<Student> studentList = new ArrayList<Student>();
		//studentList.remove(studentId);
		try {
			result = adminDAO.deleteStudentDetailsDAO(studentId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void updateStudentService(int id, String firstName) 
	{
		try {
			adminDAO.updateStudentDetailsDAO(id, firstName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Student> viewStudentService(int studentId2)
	{
		List<Student> students = null;
		try {
		 students	=adminDAO.viewStudentDetailsDAO(studentId2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
		
	}

	@Override
	public String addFacultyService(FacultyModel facultyModel)
	{
		Faculty faculty = new Faculty();
		faculty.setFacultyId(facultyModel.getFacultyId());
		faculty.setFirstName(facultyModel.getFirstName());
		faculty.setLastName(facultyModel.getLastName());
		faculty.setDateOfBirth(facultyModel.getDateOfBirth());
		faculty.setEmailAddress(facultyModel.getEmail());
		faculty.setPhoneNumber(facultyModel.getPhoneNumber());
		faculty.setDepartmentName(facultyModel.getDepartmentName());
		faculty.setSalary(facultyModel.getSalary());
		String result = "failed";
		try {
			boolean stored = adminDAO.storeFacultyDetailsDAO(faculty);
			if(stored)
				result = "success";
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("!ERROR[Storing data failed due to some internal issue]");
		}
		
		return result;
		
	}
	
	@Override
	public boolean updateFacultyService(String phoneNumber,int id)
	{
		boolean result = false;
		try {
			result = adminDAO.updateFacultyDetailsDAO(phoneNumber, id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteFacultyService(int facultyId)
	{
		boolean result = false;
		//List<Faculty> facultyList = new ArrayList<Faculty>();
		//facultyList.remove(facultyId);
		try {
			result = adminDAO.deleteFacultyDetailsDAO(facultyId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public void viewFacultyService(int facultyId2)
	{
		try {
			adminDAO.viewFacultyDetailsDAO(facultyId2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public boolean addEventsService(int id ,String name, String date, String location)
	{
		boolean result = false;
		try {
			result = adminDAO.addEventsDAO(id ,name, date, location);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteEventsService(int eventId) 
	{
		boolean result = false;
		try {
			result = adminDAO.deleteEventsDAO(eventId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addPlacementsService(int id, String companyName, String date, double percentage)
	{
		boolean result = false;
		try {
			result = adminDAO.addPlacementsDAO(id, companyName, date, percentage);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deletePlacementsService(int placementId)
	{
		boolean result = false;
		
		try {
			result = adminDAO.deletePlacementsDAO(placementId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void addDepartmentService(int id, String name)
	{
		try {
			adminDAO.addDepartmentDAO(id, name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteDepartmentService(int courseId)
	{
		try {
			adminDAO.deleteDepartmentDAO(courseId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	

	

	
	
	
	
	

	
	
	
	

	
	

}  
