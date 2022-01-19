package com.sg.assignment.generator.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sg.assignment.domain.Department;
import com.sg.assignment.generator.IGenerator;
import com.sg.assignment.pesistance.DepartmentInMemoryRepo;
import com.sg.assignment.pesistance.EmployeeInMemoryRepo;

public class DepartmentGenrator implements IGenerator<Department> {
	
	 private int minDept= 100;

	    private int maxDept=105;

	    int deptIdCounter = 0;
	    
	/*@Override
    public void generate(int size) {
        while(size >0){
            com.sg.assigment.domain.Department dept =  new com.sg.assigment.domain.Department( getDepartmentId(),getDepartmentName());
            DepartmentInMemoryRepo.addDepartment(dept);
            size--;
        }

    }*/
	
	@Override
    public void generate(int size) {
		 DepartmentInMemoryRepo.addDepartment(new com.sg.assignment.domain.Department( "101","IT"));
		 DepartmentInMemoryRepo.addDepartment(new com.sg.assignment.domain.Department( "102","INFRA"));
         DepartmentInMemoryRepo.addDepartment(new com.sg.assignment.domain.Department( "103","HR"));
         DepartmentInMemoryRepo.addDepartment(new com.sg.assignment.domain.Department( "104","ADMIN"));
         DepartmentInMemoryRepo.addDepartment(new com.sg.assignment.domain.Department( "105","FIN"));
        }
	
	private String getDepartmentId() {
        String deptid = new String[]{"100", "200", "300", "400", "500"}[(int)(Math.random()*5)];
        return deptid;
    }


    private String getDepartmentName() {
    	String departName = new String[]{"IT",  "INFRA", "HR", "ADMIN", "FIN"}[(int)(Math.random()*5)];
        return departName;

    }

}
