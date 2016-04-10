package com.bigwavedata.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;


// http://docs.oracle.com/javase/tutorial/essential/io/file.html
// http://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html
/*
 *  Using Java 7 features for files 
 */
public class files {

	
	public class lineReader {
		String filename;
		
		public lineReader(String filename) {
			this.filename = filename;
			Charset charset = Charset.forName("US-ASCII");
			//BufferedReader reader = Files.newBufferedReader(this.filename, charset)
		}
		
		public String readLine() {
			// Try with resource statement
			/*
			try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			    String line = null;
			    while ((line = reader.readLine()) != null) {
			        System.out.println(line);
			    }
			} catch (IOException x) {
			    System.err.format("IOException: %s%n", x);
			}
			*/
			return new String();
		}
	}
}
