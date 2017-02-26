package strings;

import com.bucaojit.utils.MemoryUsage;
import com.bucaojit.utils.myTimer;

/*
// Simple test to measure the time difference between String and StringBuilder
// In testing there is quite a noticeable difference by many orders of magnitude 
//   for StringBuilder being faster 

-------------------------------------------------------------------------

 Results (in seconds):
 String concatenation, 10000 iterations,        Elapsed Time: 0.358141191
 StringBuilder concatenation, 10000 iterations, Elapsed Time: 5.92451E-4
 StringBuffer concatenation, 10000 iterations,  Elapsed Time: 5.67814E-4
 
 String concatenation, 100000 iterations,        Elapsed Time: 15.874031301
 StringBuilder concatenation, 100000 iterations, Elapsed Time: 0.005202709
 StringBuffer concatenation, 100000 iterations,  Elapsed Time: 0.006168184
 
 -------------------------------------------------------------------------
 
 Second Test of memory usage, run with only that particular test enabled so that the 
   memory usage of one test will not overlap for the next test:
   
	String concatenation, 100000 iterations, Elapsed Time: 15.542563475
	Used Memory: 376446968
 
	StringBuilder concatenation, 100000 iterations, Elapsed Time: 0.0138839
	Used Memory: 3423952
		
	StringBuffer concatenation, 100000 iterations, Elapsed Time: 0.013648691
	Used Memory: 3423952
	
	StringBuilder and StringBuffer uses the same amount of memory.  
	String uses much more memory for the operation 
	
 -------------------------------------------------------------------------
 
 Other noticeable differences when using StringBuilder (best performing data structure):
 -Use .append() vs +=
 -Use .equals(String) vs ==
 -To convert StringBuilder back to a string use the .toString() method
  
 */

public class TestStringBuilder {
	public final static int ITERATIONS = 100000;
	public final static boolean STRING_TEST = false;
	public final static boolean STRINGBUILDER_TEST = true;
	public final static boolean STRINGBUFFER_TEST = true;
	public static void main(String[] args) {	
		Runtime runtime = Runtime.getRuntime();		
		String theString = "Start";
		StringBuilder theStringBuilder = new StringBuilder("Start");
		StringBuffer theStringBuffer = new StringBuffer("Start");
		int mb = 1024*1024;

		if (TestStringBuilder.STRING_TEST) {
			myTimer.beginTime();
			for(int i = 0; i < TestStringBuilder.ITERATIONS; i++) {
				theString += "More";
			}
			theString += "End";
			System.out.print("String concatenation, " + TestStringBuilder.ITERATIONS + " iterations, ");
			myTimer.endTime();
			MemoryUsage.memUsage(false);
		}
		
		if(TestStringBuilder.STRINGBUILDER_TEST) {
			myTimer.beginTime();
			for(int i = 0; i < TestStringBuilder.ITERATIONS; i++) {
				theStringBuilder.append("More");
			}
			theStringBuilder.append("End");
			System.out.print("StringBuilder concatenation, " + TestStringBuilder.ITERATIONS + " iterations, ");
			myTimer.endTime();
			MemoryUsage.memUsage(false);
		}
		
		if(TestStringBuilder.STRINGBUFFER_TEST) {
			myTimer.beginTime();
			for(int i = 0; i < TestStringBuilder.ITERATIONS; i++) {
				theStringBuilder.append("More");
			}
			theStringBuilder.append("End");
			System.out.print("StringBuffer concatenation, " + TestStringBuilder.ITERATIONS + " iterations, ");
			myTimer.endTime();
			MemoryUsage.memUsage(false);
		}
		
		
		System.out.println("theString Length: " + theString.length());
		System.out.println("theStringBuilder Length: " + theStringBuilder.length());
		System.out.println("theStringBuffer Length: " + theStringBuffer.length());
	}
}
