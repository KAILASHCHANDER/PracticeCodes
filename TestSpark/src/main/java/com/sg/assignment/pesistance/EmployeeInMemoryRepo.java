package com.sg.assignment.pesistance;

import java.util.ArrayList;
import java.util.List;

import com.sg.assignment.domain.Employee;

public class EmployeeInMemoryRepo {

    public static List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    static  public void addEmployee(Employee e){
        employeeList.add(e);
    }
}
