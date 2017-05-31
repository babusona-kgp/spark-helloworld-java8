package com.ericsson.core.spark.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.launcher.SparkLauncher;

import scala.Tuple2;

public class JavaWordCount {

	public static void main(String [] args){
		
		SparkConf conf = new SparkConf().setAppName("Spark count");
		JavaSparkContext jsc = new JavaSparkContext(conf);
		
		JavaRDD<String> lines = jsc.textFile(args[0]);
		JavaRDD<String> words =
		    lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
		JavaPairRDD<String, Integer> counts =
		    words.mapToPair(w -> new Tuple2<String, Integer>(w, 1))
		         .reduceByKey((x, y) -> x + y);
		
		
		counts.saveAsTextFile(args[1]);
		System.out.println("************************");
		System.out.println("File is saved to : "+args[1]);
		jsc.close();
	}
}
