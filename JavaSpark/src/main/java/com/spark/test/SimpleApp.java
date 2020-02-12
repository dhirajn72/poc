package com.spark.test;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/* SimpleApp.java */

public class SimpleApp {
	public static void main(String[] args) {
		String logFile = "/home/dhiraj/Downloads/Downloads/spark-1.4.1/spark-1.4.1-bin-hadoop2.6/README.md";

		SparkConf conf = new SparkConf().setAppName("JavaSpark").setMaster(
				"local");

		JavaSparkContext sc1 = new JavaSparkContext(conf);
/*		JavaSparkContext sc2 = new JavaSparkContext(conf);
		JavaSparkContext sc3 = new JavaSparkContext(conf);
*/
		JavaRDD<String> rdd = sc1.textFile(logFile);
		System.out.println(rdd.count());
		sc1.close();
		/*sc2.close();
		sc3.close();
		*/

	}
}
