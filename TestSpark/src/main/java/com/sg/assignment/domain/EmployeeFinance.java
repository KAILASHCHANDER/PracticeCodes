package com.sg.assignment.domain;

public class EmployeeFinance {
	
	  String empId;

      double ctc;

      double basic;

      double gratuity;
      double pf;

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public EmployeeFinance(String empId, double ctc, double basic,  double pf ,double gratuity) {
		super();
		this.empId = empId;
		this.ctc = ctc;
		this.basic = basic;
		this.pf = pf;
		this.gratuity = gratuity;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public double getCtc() {
		return ctc;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getGratuity() {
		return gratuity;
	}

	public void setGratuity(double gratuity) {
		this.gratuity = gratuity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(basic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ctc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		temp = Double.doubleToLongBits(gratuity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		EmployeeFinance other = (EmployeeFinance) obj;
		if (Double.doubleToLongBits(basic) != Double.doubleToLongBits(other.basic))
			return false;
		if (Double.doubleToLongBits(ctc) != Double.doubleToLongBits(other.ctc))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (Double.doubleToLongBits(gratuity) != Double.doubleToLongBits(other.gratuity))
			return false;
		if (Double.doubleToLongBits(pf) != Double.doubleToLongBits(other.pf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeFinance [empId=" + empId + ", ctc=" + ctc + ", basic=" + basic + ", pf=" + pf + " gratuity=" + gratuity + "]";
	}
      

}
