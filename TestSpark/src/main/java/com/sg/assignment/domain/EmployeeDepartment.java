package com.sg.assignment.domain;

public class EmployeeDepartment {
	
		
		String empid;
	String departmentId;
	
	
	public EmployeeDepartment(String empid, String departmentId) {
		super();
		this.empid = empid;
		this.departmentId = departmentId;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDepartment other = (EmployeeDepartment) obj;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmployeeDepartmentInfo [empid=" + empid + ", departmentId=" + departmentId + "]";
	}
	
	
	
	

}
