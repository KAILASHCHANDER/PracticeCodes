package com.sg.assignment.pesistance;

import java.util.ArrayList;
import java.util.List;

import com.sg.assignment.domain.Employee;
import com.sg.assignment.domain.EmployeeFinance;

public class EmployeeFinanceRepo {
	
	 public static List<EmployeeFinance> employeeFinanceInfoList = new ArrayList<>();

	    public List<EmployeeFinance> getEmployeeList() {
	        return employeeFinanceInfoList;
	    }

	    static  public void addFinanceData(EmployeeFinance e){
	    	employeeFinanceInfoList.add(e);
	    }

}
