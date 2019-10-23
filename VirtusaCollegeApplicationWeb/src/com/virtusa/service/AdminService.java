package com.virtusa.service;

import com.virtusa.model.FacultyModel;
import com.virtusa.model.StudentModel;

public interface AdminService 
{
	public void approveApplicantService(int applicantNumber);
	public String addStudentService(StudentModel studentModel);
	public void deleteStudentService(String studentId);
	public void updateStudentService(int id, String firstName);
	public void viewStudentService(int studentId2);
	public String addFacultyService(FacultyModel facultyModel);       
	public boolean deleteFacultyService(int facultyId);
	public boolean updateFacultyService(String phoneNumber, int id);
	public void viewFacultyService(int facultyId2);
	public boolean addEventsService(int id, String name, String date, String location);
	public boolean deleteEventsService(int eventId);
	public boolean addPlacementsService(int id, String companyName, String date, double percentage);
	public boolean deletePlacementsService(int placementId);
	public void addDepartmentService(int id, String name);
	public void deleteDepartmentService(int courseId);
	     
	
    
}
