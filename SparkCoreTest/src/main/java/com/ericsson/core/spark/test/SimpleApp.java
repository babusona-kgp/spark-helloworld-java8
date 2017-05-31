package com.ericsson.core.spark.test;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class SimpleApp {
	
	public static void main(String args[]){
		
		if(args.length==0){
			return;
		}
		String logFile = args[0];
		
		SparkConf conf = new SparkConf().setAppName("SimpleApp");
		JavaSparkContext jsc = new JavaSparkContext(conf);
		
		JavaRDD<String> logData = jsc.textFile(logFile).cache();
		
		  /*long numAs = logData.filter(new Function<String, Boolean>() {
		      public Boolean call(String s) { return s.contains("a"); }
		    }).count();*/
		  
		long numAs = logData.filter(line->line.contains("a")).count();
		
		  /*long numBs = logData.filter(new Function<String, Boolean>() {
		      public Boolean call(String s) { return s.contains("b"); }
		    }).count();*/
		
		long numBs = logData.filter(line->line.contains("b")).count();
		
		System.out.println("**********************");
		
		System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
		
		System.out.println("**********************");
		    
		    jsc.stop();
		
	}

}
