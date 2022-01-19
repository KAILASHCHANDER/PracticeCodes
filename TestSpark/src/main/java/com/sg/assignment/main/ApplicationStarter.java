package com.sg.assignment.main;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.SparkSession.Builder;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;

import static org.apache.spark.sql.functions.*;

import com.sg.assignment.domain.Department;
import com.sg.assignment.domain.Employee;
import com.sg.assignment.domain.EmployeeDepartment;
import com.sg.assignment.domain.EmployeeFinance;
import com.sg.assignment.generator.IGenerator;
import com.sg.assignment.generator.impl.DepartmentGenrator;
import com.sg.assignment.generator.impl.EmployeeDeptInfoGenerator;
import com.sg.assignment.generator.impl.EmployeeFinanceGenerator;
import com.sg.assignment.generator.impl.EmployeeGenerator;
import com.sg.assignment.pesistance.DepartmentInMemoryRepo;
import com.sg.assignment.pesistance.EmployeeDepartmentInfoRepo;
import com.sg.assignment.pesistance.EmployeeFinanceRepo;
import com.sg.assignment.pesistance.EmployeeInMemoryRepo;
import com.sg.assignment.processing.EmployeeDataProcessor;
import com.sg.assignment.utils.ExceptionMessanger;
import com.sg.assignment.utils.QueryConstants;



public class ApplicationStarter { 
	private static Logger log = Logger.getLogger(ApplicationStarter.class);
	
    public static void main(String[] args) throws ExceptionMessanger {
    	
    try {
    	 
    	EmployeeDataProcessor executor = new EmployeeDataProcessor();
    	executor.process();
    //	processTest();
    	
    }catch (Exception e)
	{
	    e.printStackTrace();
	    log.error("Error Occured in the Processing");
	    throw new ExceptionMessanger("Pleasse check the logs for Exception message");
	}
  
}
    
    private static void processTest() {
    		SparkSession spark = new Builder().appName("EmployeeInformationsApp").master("local[*]").getOrCreate();
    			JavaSparkContext sc = new JavaSparkContext(spark.sparkContext());
    	       
    	        int employeeSize =1000;
    	        IGenerator<Employee> employeeGenerator = new EmployeeGenerator();
    	        System.out.println("*************Employee Information Generation Starts here***********");
    	        employeeGenerator.generate(employeeSize);
    	        System.out.println("Employee Info:");
    	        EmployeeInMemoryRepo.employeeList.forEach(employee->
    	                        System.out.println(employee)
    	                );
    	        
    	        System.out.println("*************Department Information Generation Starts here***********");
    	        IGenerator<Department> departmentGenerator =  new DepartmentGenrator();
    	        departmentGenerator.generate(5);
    	        System.out.println("Department Info:");
    	        DepartmentInMemoryRepo.departmentList.forEach(department->
    	        System.out.println(department)
    	        		);
    	        
    	        EmployeeFinanceGenerator<EmployeeFinance> employeeFinanceGenerator = new EmployeeFinanceGenerator();
    	        System.out.println("*************EmployeeFinance Information Generation Starts here***********");
    	        employeeFinanceGenerator.generateFinanceInfo(employeeSize , EmployeeInMemoryRepo.employeeList );
    	        System.out.println("EmployeeFinance Info:");
    	        EmployeeFinanceRepo.employeeFinanceInfoList.forEach(empfinance->
    	        System.out.println(empfinance)
    	        		);
    	        System.out.println("*************EmployeeDeprt Information Generation Starts here***********");
    	        EmployeeDeptInfoGenerator<EmployeeDepartment> employeeDeptInfoGenerator = new EmployeeDeptInfoGenerator();
    	        employeeDeptInfoGenerator.generateEmpDeptInfo(employeeSize , EmployeeInMemoryRepo.employeeList );
    	        System.out.println("EmployeeDept Info:");
    	        EmployeeDepartmentInfoRepo.empDeptInfo.forEach(empDeptInfo->
    	        System.out.println(empDeptInfo)
    	        		);
    	        
    	        
    	        JavaRDD<Employee> perJavaRDD = sc.parallelize( EmployeeInMemoryRepo.employeeList);
    	      
    	        
    	        // DataFrame
    	        Encoder<Employee> employeeEncoder = Encoders.bean(Employee.class);
    	        Dataset<Employee> employeeDF = spark.createDataset( EmployeeInMemoryRepo.employeeList, employeeEncoder);
    	        employeeDF.printSchema();
    	        employeeDF.show();
    	        employeeDF.write().format("csv").mode(SaveMode.Overwrite);
    	        Encoder<Department> departmentEncoder = Encoders.bean(Department.class);
    	        Dataset<Department> departmentDF = spark.createDataset( DepartmentInMemoryRepo.departmentList, departmentEncoder);
    	        departmentDF.printSchema();
    	        departmentDF.show();
    	        
    	        Encoder<EmployeeFinance> empFinanceEncoder = Encoders.bean(EmployeeFinance.class);
    	        Dataset<EmployeeFinance> empFinanceDF = spark.createDataset(EmployeeFinanceRepo.employeeFinanceInfoList, empFinanceEncoder);
    	        empFinanceDF.printSchema();
    	        empFinanceDF.show();
    	        
    	        Encoder<EmployeeDepartment> empDeptEncoder = Encoders.bean(EmployeeDepartment.class);
    	        Dataset<EmployeeDepartment> empDepartmentDF = spark.createDataset(EmployeeDepartmentInfoRepo.empDeptInfo, empDeptEncoder);
    	        empDepartmentDF.printSchema();
    	        empDepartmentDF.show();
    	        
    	       
    	        Dataset<Employee> dfForAge1 = employeeDF.filter(col("age").gt(40));
    	        dfForAge1.show(false);
    	        
    	        System.out.println("Calculate the Employee info with age > 40 and Ctc > 30k - USING DF");
    	        
    	        Dataset<Row> dfForAge = employeeDF.filter(col(QueryConstants.COLUMN_AGE).gt(QueryConstants.AGE_FILTER2))
    	        		       		.join(empFinanceDF.filter(col(QueryConstants.COLUMN_CTC).gt(QueryConstants.CTC_FILTER)), "empId");
    	        dfForAge.show(false);
    	        
    	      /*  Dataset<Row> dfForAge = employeeDF.filter(col("age").gt(lit(40))).join(empFinanceDF, scala.collection.JavaConverters.asScalaIteratorConverter(Arrays.asList( "empId").iterator()).asScala().toSeq(), "inner");
    	        dfForAge.show(false);*/
    	        
    	        //SQL Way--
    	        System.out.println("Calculate the Employee info with age > 40 and Ctc > 30k - USING SQL");
    	        employeeDF.createOrReplaceTempView("EmployeeTempTable");
    	        empFinanceDF.createOrReplaceTempView("EmpFinanceTempTable");
    	        Dataset<Row> dfForAgeUsingSQL = spark.sql("select * from EmployeeTempTable emp INNER JOIN EmpFinanceTempTable empf ON emp.empId == empf.empId where emp.age >40 and ctc>30000.0");
    	        
    	        dfForAge.show(false);      
    	        dfForAgeUsingSQL.show(false);
    	        System.out.println("Calculate the Employee info with age > 35 and gratuity < 800");
    	        Dataset<Row> deptWithMaxEmployee = employeeDF.filter(col(QueryConstants.COLUMN_AGE).gt(QueryConstants.AGE_FILTER))
    	        			.join(empFinanceDF.filter(col(QueryConstants.COLUMN_GRATUITY).lt(QueryConstants.GRATUITY_FILTER)), "empId");
    	       
    	               
    	    //    Dataset<Row> deptWithMaxEmployee1= deptWithMaxEmployee.join(empDepartmentDF,scala.collection.JavaConverters.asScalaIteratorConverter(Arrays.asList( "empId").iterator()).asScala().toSeq(), "inner");
    	        Dataset<Row> deptWithMaxEmployee1= deptWithMaxEmployee.join(empDepartmentDF,"empId");
    	       
    	        deptWithMaxEmployee1 =deptWithMaxEmployee1.groupBy("departmentId")
    	        					.agg(count("empId").as("totalEmployee"));
    	        deptWithMaxEmployee1.show(10);
    	        deptWithMaxEmployee1=deptWithMaxEmployee1.orderBy("totalEmployee").sort(desc("totalEmployee")).limit(1);
    	     
    	        deptWithMaxEmployee1.show(10);
    }
}
    