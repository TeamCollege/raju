package com.virtusa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.virtusa.entities.Applicant;
import com.virtusa.entities.Faculty;
import com.virtusa.entities.Student;
import com.virtusa.integrate.ConnectionManager;

public class AdminDAOImpl implements AdminDAO 
{
	@Override
	public boolean storeApprovedApplicantDetailsDAO(Applicant app)throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?");
		statement.setInt(1, app.getApplicantNumber());
		statement.setString(2, app.getFirstName());
		statement.setString(3, app.getLastName());
		statement.setDate(4, Date.valueOf(app.getDateOfBirth()));
		statement.setString(5, app.getEmailAddress());
		statement.setString(6, app.getPhoneNumber());
		statement.setDouble(7, app.getTenthPercentage());
		statement.setDouble(8, app.getInterPercentage());
		statement.setString(9, app.getDepartmentName());
		statement.setString(10, app.getAadharNumber());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0)
			return true;
		else
			return false;           
	}

	@Override
	public boolean storeStudentDetailsDAO(Student student) throws SQLException
	{
		try(Connection connection=ConnectionManager.openConnection();)
		
		{     
		//student.forEach( (object)->{
			String sql="insert into students values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement=
				connection.prepareStatement(sql);
		preparedStatement.setInt(1, student.getStudentId());
		preparedStatement.setString(2, student.getFirstName());
		preparedStatement.setString(3, student.getLastName());
		preparedStatement.setString(4, student.getEmailAddress());
		preparedStatement.setString(5, student.getPhoneNumber());
		preparedStatement.setDouble(6, student.getTenthPercentage());
		preparedStatement.setDouble(7, student.getInterPercentage());
		preparedStatement.setString(8, student.getAadharNumber());
		preparedStatement.setDate(9,  Date.valueOf(student.getDateOfBirth()));
		preparedStatement.setString(10, student.getDepartmentName());
		int rows = preparedStatement.executeUpdate();
		if(rows>0)
			System.out.println("Stduent Details are inserted into table successfully");
		else
			System.out.println("Failed to store the data");
		}
		catch(Exception e) {
			
		}
	
	//});
		
	}
		catch(Exception e) {
			
		}
		return true;
	}
	@Override
	public boolean updateStudentDetailsDAO(int id, String firstName) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("update students set first_name=? where student_id=?");
		statement.setString(1, firstName);
		statement.setInt(2, id);
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0)
			return true;
		else
		return false;
		
	}

	@Override
	public boolean deleteStudentDetailsDAO(String studentId) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("delete from students where student_id=?");
		preparedStatement.setString(1, studentId);
		int rows = preparedStatement.executeUpdate();
		if(rows>0)
			return true;
		else    
			return false;
	}
	@Override
	public List<Student> viewStudentDetailsDAO(int studentId2) throws ClassNotFoundException, SQLException
	{
		Student student = new Student();
		List<Student> studentList = new ArrayList<Student>();
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("select * from students where student_id=?");
		preparedStatement.setInt(1, studentId2);
		ResultSet resultSet =  preparedStatement.executeQuery();
		while(resultSet.next())
		{
			student.setStudentId(resultSet.getInt("student_id"));
			student.setFirstName(resultSet.getString("first_name"));
			student.setLastName(resultSet.getString("last_name"));
			//student.setDateOfBirth(resultSet.getDate("DOB"));
			student.setEmailAddress(resultSet.getString("email_id"));
			student.setPhoneNumber(resultSet.getString("phone_number"));
			student.setTenthPercentage(resultSet.getDouble("tenth_percentage"));
			student.setInterPercentage(resultSet.getDouble("inter_percentage"));
			student.setDepartmentName(resultSet.getString("department_name"));
			//student.setAadharNUmber(resultSet.getString("aadhar_number"));
			studentList.add(student);
			
		}
		return studentList;
	}
	
       
	@Override
	public boolean storeFacultyDetailsDAO(Faculty faculty) throws ClassNotFoundException, SQLException 
	{
		
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("insert into faculty values(?,?,?,?,?,?,?,?)");
		preparedStatement.setString(1, faculty.getFacultyId());
		preparedStatement.setString(2, faculty.getFirstName());
		preparedStatement.setString(3, faculty.getLastName());
		preparedStatement.setDate(4, Date.valueOf( faculty.getDateOfBirth()));
		preparedStatement.setString(5, faculty.getEmailAddress());
		preparedStatement.setString(6, faculty.getPhoneNumber());
		preparedStatement.setString(7, faculty.getDepartmentName());
		preparedStatement.setDouble(8, faculty.getSalary());
		int rows = preparedStatement.executeUpdate();
		if(rows>0)
			return true;
		else
			return false;
	}
	@Override
	public boolean updateFacultyDetailsDAO(String phoneNumber , int id) throws ClassNotFoundException, SQLException
	{
		
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("update faculty set phone_number=? where faculty_id=?");
		statement.setString(1, phoneNumber);
		statement.setInt(2, id);
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0)
			return true;
		else
		return false;
	}
	@Override
	public boolean deleteFacultyDetailsDAO(int facultyId) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("delete from faculty where faculty_id=?");
		preparedStatement.setInt(1, facultyId);
		int rows = preparedStatement.executeUpdate();
		if(rows>0)
			return true;
		else
			return false;
	}
	@Override
	public boolean viewFacultyDetailsDAO(int facultyId2) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("select * from faculty where faculty_id=?");
		preparedStatement.setInt(1, facultyId2);
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		return false;
	}

	@Override
	public boolean addEventsDAO(int id, String name, String date, String location) throws ClassNotFoundException, SQLException
	{

				Connection connection=ConnectionManager.openConnection();

		PreparedStatement preparedStatement=
				connection.prepareStatement("insert into  events values(?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
	preparedStatement.setString(3, date);

			preparedStatement.setString(4, location);
		int rows = preparedStatement.executeUpdate();
		if(rows>0) {
			System.out.println("Events data is stored Successfully");
			return true;}
			
		else {
			System.out.println("Events data is stored Successfully");
			return false;
		}     
				
	}

	@Override
	public boolean deleteEventsDAO(int eventId) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("delete from events where event_id=?");
		preparedStatement.setInt(1, eventId);
		int rows = preparedStatement.executeUpdate();
		if(rows>0) {
			System.out.println("Events data is deleted Successfully");
			return true;}
			
		else {
			System.out.println("Events data is not delete Successfully");
			return false;
		}     
	}

	@Override
	public boolean addPlacementsDAO(int id, String companyName, String date, double percentage) throws ClassNotFoundException, SQLException
	{

		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("insert into  placements values(?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, companyName);

		preparedStatement.setString(3, date);

		preparedStatement.setDouble(4, percentage);
		int rows = preparedStatement.executeUpdate();
		if(rows>0)
			return true;
		else
			return false;
				
	}

	@Override
	public boolean deletePlacementsDAO(int placementId) throws ClassNotFoundException, SQLException 
	{
		
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("delete from placements where placement_id=?");
		preparedStatement.setInt(1, placementId);
		int rows = preparedStatement.executeUpdate();
		if(rows>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean addDepartmentDAO(int id, String name) throws ClassNotFoundException, SQLException 
	{
		
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("insert into courses values(?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		int rows = preparedStatement.executeUpdate();
		if(rows>0)
			return true;
		else
			return false;
		
	}

	@Override
	public boolean deleteDepartmentDAO(int courseId) throws ClassNotFoundException, SQLException 
	{
	
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=
				connection.prepareStatement("delete from courses where course_id=?");
		preparedStatement.setInt(1, courseId);
		int rows = preparedStatement.executeUpdate();
		if(rows>0)
			return true;
		else
			return false;
	}
	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
