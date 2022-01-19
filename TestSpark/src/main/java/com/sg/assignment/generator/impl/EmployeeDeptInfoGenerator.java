package com.sg.assignment.generator.impl;

import java.util.List;

import com.sg.assignment.domain.Employee;
import com.sg.assignment.domain.EmployeeDepartment;
import com.sg.assignment.pesistance.EmployeeDepartmentInfoRepo;




public class EmployeeDeptInfoGenerator<EmployeeDepartmentInfo> {
	
	    String empId;
	    String departmentId;
	
	public void generateEmpDeptInfo(int size, List<Employee> employeeList) {

		//   public void generate(int size, ) {
		    	int i =0;
		        while(size >0){
		        empId = employeeList.get(i).getEmpId();
		        com.sg.assignment.domain.EmployeeDepartment empDeptId =  new com.sg.assignment.domain.EmployeeDepartment(empId, getDeptId(i));
		        EmployeeDepartmentInfoRepo.addEmployee(empDeptId);
		            size--;
		            i++;
		        }

		    }

	private String getDeptId(int i) {
		if(i<500) {
			//TO_DO - Pass the department list and supply instead of hardcoded value
			departmentId = new String[]{"100",  "200"}[(int)(Math.random()*2)];
	      
		}
		else {
			departmentId= new String[]{"300",  "400","500"}[(int)(Math.random()*3)];
	       // return departName;
		}
		  return departmentId;

	}

	    

}
