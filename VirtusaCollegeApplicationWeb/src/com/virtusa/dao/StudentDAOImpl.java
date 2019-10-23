package com.virtusa.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.ClassSchedule;
import com.virtusa.entities.ExamSchedule;
import com.virtusa.entities.PlacementCalender;
import com.virtusa.entities.Results;
import com.virtusa.entities.Student;
import com.virtusa.entities.UploadDownloadAssignments;
import com.virtusa.integrate.ConnectionManager;


public class StudentDAOImpl implements StudentDAO {
	//12.10.19  
	
	  public Student getClassSchedule(String departmentName)throws  ClassNotFoundException, SQLException{ 
		  Connection	 connection=ConnectionManager.openConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet = null;
			switch(departmentName) {
			case "cse":
				resultSet = statement.executeQuery("select * from cse_class_schedule");
				break;
			case "ece":
				resultSet = statement.executeQuery("select * from ece_class_schedule");
				break;
			case "eee":       
				resultSet = statement.executeQuery("select * from eee_class_schedule");
				break;
			}
			Student students=new Student();
			  while(resultSet.next()) {
				  ClassSchedule classSchedule=new ClassSchedule();
				  classSchedule.setDay(resultSet.getString("day"));
				  classSchedule.setFirstHour(resultSet.getString("first_hour"));
				  classSchedule.setSecondHour(resultSet.getString("second_hour"));
				  classSchedule.setThirdHour(resultSet.getString("third_hour"));
				  classSchedule.setFourthHour(resultSet.getString("fourth_hour"));
				  
				  students.setClassSchedule(classSchedule);
				  
				  } ConnectionManager.closeConnection(); 
				  return students;
		  
 }
	  
	  @Override
		public List<ClassSchedule> handleClassSchedule(String departmentName) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
		  Connection	 connection=ConnectionManager.openConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet = null;
			switch(departmentName) {
			case "cse":
				resultSet = statement.executeQuery("select * from cse_class_schedule");
				break;
			case "ece":
				resultSet = statement.executeQuery("select * from ece_class_schedule");
				break;
			case "eee":       
				resultSet = statement.executeQuery("select * from eee_class_schedule");
				break;
			}
			
			  ClassSchedule classSchedule=new ClassSchedule();
			  List<ClassSchedule> classScheduleList=new ArrayList<ClassSchedule>();
			  while(resultSet.next()) {
				  classSchedule.setDay(resultSet.getString("day"));
				  classSchedule.setFirstHour(resultSet.getString("first_hour"));
				  classSchedule.setSecondHour(resultSet.getString("second_hour"));
				  classSchedule.setThirdHour(resultSet.getString("third_hour"));
				  classSchedule.setFourthHour(resultSet.getString("fourth_hour"));
				  
				  classScheduleList.add(classSchedule);
			  }ConnectionManager.closeConnection();
			return classScheduleList;
		}
	
	  
	  
	  
	  public Student getExaminationSchedule(String departmentName) throws ClassNotFoundException, SQLException {
		  
		  
			Connection	 connection=ConnectionManager.openConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet = null;
			switch(departmentName) {
			case "cse":
				resultSet = statement.executeQuery("select * from cse_exam_schedule");
				break;
			case "ece":
				resultSet = statement.executeQuery("select * from ece_exam_schedule");
				break;
			case "eee":       
				resultSet = statement.executeQuery("select * from eee_exam_schedule");
				break;
			}
			Student students=new Student();
			  while(resultSet.next()) {
			  
				  ExamSchedule examSchedule=new ExamSchedule();
				  examSchedule.setExamId(resultSet.getString("exam_id"));
				  examSchedule.setExamType(resultSet.getString("exam_type"));
				  examSchedule.setExamName(resultSet.getString("exam_name"));
				 examSchedule.setExamDate(resultSet.getDate("exam_date"));
				  examSchedule.setExamSubject1(resultSet.getString("exam_subject1"));
				  examSchedule.setExamSubject2(resultSet.getString("exam_subject2"));
			  
			  
			  students.setExamSchedule(examSchedule);
			  
			  } ConnectionManager.closeConnection(); 
			  return students;	  
		  
	  }
	  
		@Override
		public Student getResults(int studentId) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			Connection	 connection=ConnectionManager.openConnection(); 
			  PreparedStatement statement=connection.prepareStatement("select * from results ");
	
			  ResultSet resultSet=statement.executeQuery();
			  Student students=new Student();
			  while(resultSet.next()) {
			  
			
				 Results results=new Results();
				 results.setStudentId(resultSet.getInt("student_id"));
				 results.setSubject1Name(resultSet.getString("subject1_name"));
				 results.setSubject1Marks(resultSet.getInt("subject1_marks"));
				 results.setSubject2Name(resultSet.getString("subject2_name"));
				 results.setSubject2Marks(resultSet.getInt("subject2_marks"));
				 results.setFinalresult(resultSet.getString("final_result"));
			  
			  
			  students.setResults(results);
			  System.out.println(students);
			  } ConnectionManager.closeConnection(); 
			  return students;

		}
		
		@Override
		public Student getPlacementCalender() throws ClassNotFoundException, SQLException {
			Connection	 connection=ConnectionManager.openConnection(); 
			  PreparedStatement statement=connection.prepareStatement("select * from placement_calender ");
	
			  ResultSet resultSet=statement.executeQuery();
			  Student students=new Student();
			  while(resultSet.next()) {
				  PlacementCalender placementCalender=new PlacementCalender();
				  System.out.println(resultSet.getString("company_name"));
				  System.out.println(resultSet.getDate("date"));
				  placementCalender.setComapanyName(resultSet.getString("company_name"));
				  placementCalender.setDate(resultSet.getDate("date"));
				  placementCalender.setLocation(resultSet.getString("location"));
				  placementCalender.setEligibilityCriteria(resultSet.getString("eligibility_criteria"));
				  
				  students.setPlacementCalender(placementCalender);
				  System.out.println(students);
			  }ConnectionManager.closeConnection(); 
			  System.out.println("going from dao");
			  return students;
		}

		@Override
		public boolean handleRetrieveUploadAssignments(String path)
				throws ClassNotFoundException, SQLException, FileNotFoundException{
			// TODO Auto-generated method stub

			UploadDownloadAssignments uploadDownloadAssignments= new UploadDownloadAssignments();
			File file=new File(path);
			System.out.println(path);
		//	Reader reader=new FileReader(file)
			 Connection connection=ConnectionManager.openConnection(); 
			PreparedStatement st=
					connection.prepareStatement("insert into FileTable values(?,?,?)");
			st.setInt(1, uploadDownloadAssignments.getFileId());
			st.setString(2, uploadDownloadAssignments.getFileName());
			 int s=(int)file.length();
			 System.out.println(file.length());
			 Reader fis=new FileReader(file);
	         st.setCharacterStream(3,fis,s);
			//st.setCharacterStream(3, reader);
			int rows=st.executeUpdate();
			System.out.println("yessss");
			ConnectionManager.closeConnection();
			if(rows>0)
				return true;
			else
			
			return false;
		}



		
	  
}
