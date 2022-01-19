package com.sg.assignment.utils;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import com.sg.assignment.domain.Department;
import com.sg.assignment.domain.Employee;

public class DFWriter {
	//String csvName="Test";
	public static void writeToCsv(SparkSession spark, Dataset<Row> dataset, String csvName) {
		dataset.write().format("csv").mode(SaveMode.Overwrite).option("header",true).option("sep",",").save(csvName+".csv");
		
		
	}
	
	

}
