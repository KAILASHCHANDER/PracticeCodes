package com.sg.assignment.pesistance;

import java.util.ArrayList;
import java.util.List;

import com.sg.assignment.domain.Department;
import com.sg.assignment.domain.Employee;

public class DepartmentInMemoryRepo {

    public static List<Department> departmentList = new ArrayList<>();

    public List<Department> getDepartmentList() {
    	
        return departmentList;
    }

    static  public void addDepartment(Department e){
    	departmentList.add(e);
    }
}
