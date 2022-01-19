package com.sg.assignment.domain;

public  class Employee {

        String empId;

        String firstName;

        String lastName;

        int age;


        public Employee(String empId, String firstName, String lastName, int age) {
            this.empId = empId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getEmpId() {
            return empId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            if (age != employee.age) return false;
            if (empId != null ? !empId.equals(employee.empId) : employee.empId != null) return false;
            if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
            return lastName != null ? lastName.equals(employee.lastName) : employee.lastName == null;
        }

        @Override
        public int hashCode() {
            int result = empId != null ? empId.hashCode() : 0;
            result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + age;
            return result;
        }

        @Override
        public String toString() {
            return "Employee[" +
                    "empId='" + empId + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ']';
        }
    }