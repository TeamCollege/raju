package com.virtusa.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.virtusa.helper.FactoryApplicantService;
import com.virtusa.model.ApplicantModel;
import com.virtusa.service.ApplicantService;

public class ApplicantModelValidator {

public boolean validate(ApplicantModel model) {
		
		boolean result=false;
		
		if(validString(model.getFirstName()) && validString(model.getLastName()) && validDouble(model.getTenthPercentage()) 
				&& validDouble(model.getInterPercentage()) && validEmail(model.getEmail()) ){
			result=true;
		}
		return result;
	}

	public boolean validDouble(double Percentage) {
		boolean result = false;
		if(Percentage>0.0 && Percentage<=100.0)
			result=true;
		return result;
	}        
	 
	public boolean emailExists(String email) {
		ApplicantService applicantService=FactoryApplicantService.createApplicantService();
		List<ApplicantModel> applicantModelList=applicantService.retrieveApplicants();
		for(ApplicantModel applicantModel:applicantModelList) {
			
			if(applicantModel.getEmail().contentEquals(email)) {
				return true;
			}
		}
		return false;
	}
      
	public boolean validString(String val) {
	
		boolean result=false;
		char chars[]=val.toCharArray();
		List<Character> alphabets=new ArrayList<>();
		for(int i=97;i<=122;i++) {
			alphabets.add((char)i);
		}
		for(int i=65;i<=90;i++) {
			alphabets.add((char)i);
		}
	
		for(char ch:chars) {
			if(alphabets.contains(ch)) 
				result=true;
			else 
				return false;
		}
		return result;
	}

	public boolean validAadhar(String Aadhar) {
		try {
			int length = 0;
			long data = Long.parseLong(Aadhar);
			while(data!=0){
				data = data/10;
				length++;
			}
			if(length!=12)
				throw new Exception(); 
			} 
		catch (Exception e) {
			return false;
			}
		return true;
	}

	public boolean validPhone(String phone) {
		Pattern p = Pattern.compile("[6-9][0-9]{9}"); 
        Matcher m = p.matcher(phone); 
        return (m.find() && m.group().equals(phone)); 
	}
	
	public boolean validEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    return email.matches(regex);
	}
	public boolean validDepartment(String departmentName) {
		boolean result=false;

		if(departmentName.equals("cse")|| departmentName.equals("ece") || departmentName.equals("eee"))
			result=true;
		return result;
	}

	public boolean validNumber(int number) {
		boolean result=false;
		String data=String.valueOf(number);
		if(data.matches(".*[0-9]")) 
		{
			return true;
		}
		else
		{
		return false;
	}
		}

		public boolean validNumber(String number) {
			 boolean result=false;
			try {
				int data = Integer.parseInt(number);
				result =false;
				} 
			catch (NumberFormatException e) {
				return false;
				}
			return true;
		}
		
		
		
		
		
		
		
		
	
	
}