/**
 * 
 */
package com.ds.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

/**
 * @author dhiraj
 *
 */
public class ProfileVisitors {
	public static void main(String[] args) {

		try {
			FileWriter writer = new FileWriter(new File("/home/dhiraj/profiles.txt"));

			Scanner scanner = new Scanner(new File("/home/dhiraj/visitors.txt"));
			String line = scanner.nextLine();
			line = line.replaceAll("\"", "");
			System.out.println(line);
			StringTokenizer stringTokenizer1 = new StringTokenizer(line, ",");
			while (stringTokenizer1.hasMoreTokens()) {
				StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer1.nextToken(), "-");
				// System.out.println(stringTokenizer2.nextToken());
				String web = "https://www.facebook.com/";
				writer.write(web + stringTokenizer2.nextToken());
				writer.write("\n");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done !");
	}

}
