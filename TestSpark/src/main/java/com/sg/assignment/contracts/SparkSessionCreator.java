package com.sg.assignment.contracts;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.spark.sql.SparkSession;


import com.sg.assignment.utils.ExceptionMessanger;


public class SparkSessionCreator {
	 private static Logger log = Logger.getLogger(SparkSessionCreator.class);

	    private SparkSession spark;
	    public SparkSession getSpark() {
	        return spark;
	    }

	
	    public SparkSessionCreator() throws ExceptionMessanger {    
			this.spark = SparkSession.builder()
	                .master("local")
	                .appName("EmployeeInformationsApp")
	                .getOrCreate();
	   }

	    public void cleanUp()
	    {
	        spark.stop();
	    }

}
