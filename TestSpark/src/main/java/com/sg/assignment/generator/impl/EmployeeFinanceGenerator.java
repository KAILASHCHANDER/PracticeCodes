package com.sg.assignment.generator.impl;

import java.util.List;

import com.sg.assignment.domain.Employee;
import com.sg.assignment.generator.IGenerator;
import com.sg.assignment.pesistance.EmployeeFinanceRepo;
import com.sg.assignment.pesistance.EmployeeInMemoryRepo;

public class EmployeeFinanceGenerator<EmployeeFinance> {
	
	 private int minCtc= 10000;

	    private int maxCtc=100000;

	    int empIdCounter = 0;
	    double gratuaity;
	    double CTC;
	    double basic;
	    double PF;
	    String empId;
	    
	public void generateFinanceInfo(int size, List<Employee> employeeList) {

	//   public void generate(int size, ) {
	    	int i =0;
	        while(size >0){
	        	
	         empId = employeeList.get(i).getEmpId();
	         CTC =getCTC();
	         basic = CTC*10/100;
	    	 PF = basic*10/100;
	    	 gratuaity = basic*5/100;
	        
	        getFinanceInfo(empId);
	        com.sg.assignment.domain.EmployeeFinance emp =  new com.sg.assignment.domain.EmployeeFinance(empId,CTC,basic, PF,gratuaity);
	        EmployeeFinanceRepo.addFinanceData(emp);
	            size--;
	            i++;
	        }

	    }

	    private void getFinanceInfo(String empid) {
	    	double CTC = getCTC();
	    	double basic = CTC*10/100;
	    	double PF = basic*10/100;
	    	double gratuaity = basic*5/100;
	    	return ;
	    	
	}

		private double getBasic(double CTC) {
	    double basicFinal =CTC*10/100;
		
		return 0;
	}

		private double getGratuaty() {

		return gratuaity;
	}

		private double getCTC() {
			double ctc = minCtc + (int)(Math.random() * ((maxCtc - minCtc) + 1));
	        return ctc;
	    }

	 
	 
	  /*  private String getEmpid(employeeList) {
	        String empid =  "test";
	        return empid;
	    }*/

}
