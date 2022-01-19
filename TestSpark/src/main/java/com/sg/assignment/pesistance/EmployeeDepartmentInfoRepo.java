package com.sg.assignment.pesistance;

import java.util.ArrayList;
import java.util.List;

import com.sg.assignment.domain.EmployeeDepartment;

public class EmployeeDepartmentInfoRepo {
	 public static List<EmployeeDepartment> empDeptInfo = new ArrayList<>();

	    public List<EmployeeDepartment> getEmployeeList() {
	        return empDeptInfo;
	    }

	    static  public void addEmployee(EmployeeDepartment e){
	    	empDeptInfo.add(e);
	    }
	}