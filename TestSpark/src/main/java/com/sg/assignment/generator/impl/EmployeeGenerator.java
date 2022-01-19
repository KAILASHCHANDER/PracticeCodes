package com.sg.assignment.generator.impl;

import com.sg.assignment.generator.IGenerator;
import com.sg.assignment.pesistance.EmployeeInMemoryRepo;

public class EmployeeGenerator<Employee> implements IGenerator {

    private int minAge= 18;

    private int maxAge=60;

    int empIdCounter = 1;

    @Override
    public void generate(int size) {
        while(size >0){
            com.sg.assignment.domain.Employee emp =  new com.sg.assignment.domain.Employee(getEmpid(),getFirtName(),getlastname(),getAge());
            EmployeeInMemoryRepo.addEmployee(emp);
            size--;
        }

    }

    private int getAge() {
        int age = minAge + (int)(Math.random() * ((maxAge - minAge) + 1));
        return age;
    }

    private String getlastname() {
        String lName =  "lName"+ empIdCounter;
        return lName;

    }

    private String getFirtName() {
        String fName =  "TestName_"+ empIdCounter++;
        return fName;

    }

    private String getEmpid() {
        String empid =  "EMPID_"+ empIdCounter;
        return empid;
    }


}
