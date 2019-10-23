package com.virtusa.view;

import java.io.File;

import java.util.Scanner;
//import org.apache.log4j.Logger;

import com.virtusa.controller.StudentController;
import com.virtusa.model.ClassScheduleModel;
import com.virtusa.model.StudentModel;
import com.virtusa.model.UploadDownloadAssignmentsModel;

public class StudentView {
	
	//Logger log = Logger.getLogger(StudentView.class.getName());
	
	public void studentMenu() {
		
	//	log.info("This is Student View");
		System.out.println("/n");
		
		
		System.out.println("\t\t ======================STUDENT VIEW=======================");
		System.out.println("1.View Class Schedule");
		System.out.println("2.View Examination Schedule");
		System.out.println("3.View Results");
		System.out.println("4.Upload and Download Assignments");
		System.out.println("5.View Placement Calender");
		System.out.println("6.Exit");
		System.out.println("Enter your choice:");
		       
		
		try(Scanner sc=new Scanner(System.in);){
		int choice=sc.nextInt();
		
		switch(choice) {
		
		case 1:viewClassSchedule();
			break;
		case 2:viewExaminationSchedule();
			break;
		case 3:viewResults();
			break;
		case 4:uploadDownloadAssignments();
			break;
		case 5:viewPlacementCalender();
			break;
		case 6:UserView userView=new UserView();
				userView.mainMenu();
				break;
		default:System.out.println("[SELECT APPROPRIATE OPTION]");
			studentMenu();
		}
		}catch(Exception e) {
			System.out.println("!ERROR[SELECT APPROPRIATE OPTION]jh");
		}
	}
	
	

	//12.10.19
	public void viewClassSchedule() {
//		log.info("-----In StudentView class viewClassSchedule method called---");
		System.out.println("/n");
		StudentController studentController =new StudentController();
		try(Scanner scanner=new Scanner(System.in);){
		System.out.println("Please Enter Department Name:");
		String departmentName=scanner.nextLine();
		studentController.retrieveClassSchedule(departmentName);
	}catch(Exception e) {
		e.printStackTrace();
	}	
	}
	
	public void showClassSchedule(StudentModel students) {
	//	log.info("-----In StudentView class showClassSchedule method called---");
		System.out.println("/n");
	System.out.println("=====================================================================================================================");
	System.out.format("%10s%15s%15s%15s%15s \n","Day", "10:00-11:00",  "11:00-12:00", "1:00-2:00", "2:00-3:00");
	System.out.println("=====================================================================================================================");
	System.out.format("%10s%15s%15s%15s%15s \n",students.getClassScheduleModel().getDay(),students.getClassScheduleModel().getFirstHour(),students.getClassScheduleModel().getSecondHour(),students.getClassScheduleModel().getThirdHour(),students.getClassScheduleModel().getFourthHour());
	System.out.println("----------------------------------------------------------------------------------------------------------------------");
	System.out.println("\n");
	StudentView studentView=new StudentView();
	studentView.studentMenu();
	}
	
	public void viewExaminationSchedule() {
	//	log.info("-----In StudentView class viewExamSchedule method called---");
		System.out.println("/n");
		StudentController studentController =new StudentController();
		try(Scanner scanner=new Scanner(System.in);){
		System.out.println("Please Enter Department Name:");
		String departmentName=scanner.nextLine();
		studentController.retrieveExaminationSchedule(departmentName);
	}catch(Exception e) {
		e.printStackTrace();
	}	
	}
	
	public void showExamSchedule(StudentModel students) {
	//	log.info("-----In StudentView class showExamSchedule method called---");
		System.out.println("/n");
		// TODO Auto-generated method stub
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%15s%15s%15s%15s\n","id","type","name","date","subject1","subject2");
		//System.out.printf("Day","First Hour","Second Hour","Third Hour","Fourth Hour");
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%10s%10s%10s%10s\n",students.getExamScheduleModel().getExamId(),students.getExamScheduleModel().getExamType(),students.getExamScheduleModel().getExamName(),students.getExamScheduleModel().getExamDate(),students.getExamScheduleModel().getExamSubject1(),students.getExamScheduleModel().getExamSubject2());
		StudentView studentView=new StudentView();
		studentView.studentMenu();
		
	}
	

	public void viewResults() {
	//	log.info("-----In StudentView class viewResults method called---");
		System.out.println("/n");
		StudentController studentController =new StudentController();

		try(Scanner scanner=new Scanner(System.in);){
			System.out.println("Please Enter Student Id:");	
			int studentId=scanner.nextInt();
		studentController.retrieveResults(studentId);
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
	public void showResults(StudentModel students) {
	//	log.info("-----In StudentView class showResults method called---");
		System.out.println("/n");
		// TODO Auto-generated method stub
		System.out.println(students.getResultsModel().getStudentId());
		//ExamScheduleModel examScheduleModel=new ExamScheduleModel();
		//System.out.println(students.getExamScheduleModel().getExamType());
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%15s%15s%15s%15s%15s\n","Student Id","subject1 name","Subject1 Marks","subject2 name","Subject2 Marks","Pass/Fail");
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%10s%10s%10s%10s%10s\n",students.getResultsModel().getStudentId(),students.getResultsModel().getSubject1Name(),students.getResultsModel().getSubject1Marks(),students.getResultsModel().getSubject2Name(),students.getResultsModel().getSubject2Marks(),students.getResultsModel().getFinalresult());
		System.out.println("\n");
		System.out.println("\n");
		StudentView studentView=new StudentView();
		studentView.studentMenu();
		}
	
	private void uploadDownloadAssignments() {
	//	log.info("-----In StudentView class upladDownloadAssignments method called---");
		System.out.println("/n");
		// TODO Auto-generated method stub
		System.out.println("1.Upload Assignment");
		System.out.println("2.Download Assignment");
		System.out.println("Enter Choice:");
		Scanner scanner=new Scanner(System.in);
		int option=scanner.nextInt();
		
		
		switch(option) {
		
		case 1:
			UploadDownloadAssignmentsModel uploadDownloadAssignmentsModel=new UploadDownloadAssignmentsModel();
			System.out.print("File Name:");
			    String fileName=scanner.next();
			    System.out.print("File path:");
			    String path=scanner.next();
			    StudentController studentController =new StudentController();
			    studentController.uploadAssignments(path);
		case 2:
		}
	}
	
	
	
	public void viewPlacementCalender() {
//		log.info("-----In StudentView class viewPlacementCalender method called---");
		System.out.println("/n");
		StudentController studentController =new StudentController();
		System.out.println("ajd");
		studentController.retrievePlacementCalender();
	}
	
	public void showPlacementCalender(StudentModel students) {
	//	log.info("-----In StudentView class showPlacementCalender method called---");
		System.out.println("/n");
		// TODO Auto-generated method stub
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%15s%15s%15s\n","Company Name","Date","Location","Eligibility Criteria");
		System.out.println("=====================================================================================================================");
		System.out.println(students.getPlacementCalenderModel().getComapanyName());
		System.out.format("%10s%10s%10s%15s \n",students.getPlacementCalenderModel().getComapanyName(),students.getPlacementCalenderModel().getDate(),students.getPlacementCalenderModel().getLocation(),students.getPlacementCalenderModel().getEligibilityCriteria());		
		System.out.println("\n");
		System.out.println("\n");
		StudentView studentView=new StudentView();
		studentView.studentMenu();
	}



	public void uploadSuccess() {
		// TODO Auto-generated method stub
		System.out.println("File uploaded successfully");
	}



	public void uploadUnsuccessful() {
		// TODO Auto-generated method stub
		System.out.println("File upload unsuccessful");
	}
	}

