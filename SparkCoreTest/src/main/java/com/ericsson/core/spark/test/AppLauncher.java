package com.ericsson.core.spark.test;

import java.io.IOException;

import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

public class AppLauncher {

	public static void main(String [] args) throws IOException{
		
		
		System.out.println("AppLauncher started...");
		Process process =  new SparkLauncher()
	      .setSparkHome("/home/earinmo/Downloads/spark-2.1.1-bin-hadoop2.7")
	      .setAppResource("/home/earinmo/Documents/SparkCoreTest-jar-with-dependencies.jar")
	      .setMainClass("com.ericsson.core.spark.test.JavaWordCount")
	      .addAppArgs("/home/earinmo/Downloads/spark-2.1.1-bin-hadoop2.7/README.md","/home/earinmo/Documents/output4")
	      .setMaster("local[*]")
	      .setVerbose(true)
	      .launch();
		
		//System.out.println(process.exitValue());
		
		
	}
}
