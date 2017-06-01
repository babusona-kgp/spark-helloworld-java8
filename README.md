# spark-helloworld-java8 
This is a MapReduce example for Spark using Java 8.
JavaWordCount is the class which is reading a input file from commandline argument 
and producing the output in a directory which has to be specify also in commandline argument. The spark-submit command is 


./spark-submit --class com.ericsson.core.spark.test.JavaWordCount --master local[4] /home/earinmo/Documents/SparkCoreTest-jar-with-dependencies.jar /home/earinmo/Downloads/spark-2.1.1-bin-hadoop2.7/README.md /home/earinmo/Documents/output

Also this WordCount job can be submitted to spark programmatically. AppLauncher is the class which submit the job to Spark.
