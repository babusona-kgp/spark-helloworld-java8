package com.ericsson.core.spark.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class WordCount {
	
	public static void main(String[] args) throws Exception {
	    String inputFile = args[0];
	    String outputFile = args[1];
	 
	   // SparkConf conf = new SparkConf().setAppName("wordCount");
	    
	    SparkConf conf = new SparkConf();
		conf.setAppName("Java API demo");
		//conf.setMaster(args[0]);
	//	conf.set("spark.cassandra.connection.host", args[0]);
	    JavaSparkContext sc = new JavaSparkContext(conf);
	    
			ArrayList<String> myList = new ArrayList<String>();
			myList.add("Hii");
			myList.add("Hello");
			myList.add("World");
			
			JavaRDD<String> testRDD = sc.parallelize(myList);
			
			testRDD.collect();
			
			
	    JavaRDD<String> input = sc.textFile(inputFile);
	   
	    JavaRDD<String> words = input.flatMap(
	      new FlatMapFunction<String, String>() {
	        public Iterator<String> call(String x) {
	          return (Iterator<String>) Arrays.asList(x.split(" "));
	        }});
	   
	    JavaPairRDD<String, Integer> counts = words.mapToPair(
	      new PairFunction<String, String, Integer>(){
	        public Tuple2<String, Integer> call(String x){
	          return new Tuple2(x, 1);
	        }}).reduceByKey(new Function2<Integer, Integer, Integer>(){
	            public Integer call(Integer x, Integer y){ return x + y;}});
	   
	    counts.saveAsTextFile(outputFile);
		}

}
