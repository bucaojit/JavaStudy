package leetcode.onlinejudge;

/*
 *  Reverse digits of an integer.

	Example1: x = 123, return 321
	Example2: x = -123, return -321
 */

public class ReverseInteger {
	public class Solution {
	    public int reverse(int x) {
	    	
	    	Integer input = new Integer(x);
	    	String inputAsString = input.toString();
	    	
	    	char[] outputCharArr = new char[inputAsString.length()];
	    	int counter = outputCharArr.length - 1;
	    	
	    	for(char value : inputAsString.toCharArray()) {
	    		if(value == '-') {
	    			outputCharArr[0] = '-';
	    			continue;
	    		}
	    		outputCharArr[counter] = value;
	    		counter--;
	    	}
	    	if(Integer.parseInt(new String(outputCharArr)) > Integer.MAX_VALUE || 
	    			Integer.parseInt(new String(outputCharArr)) < Integer.MIN_VALUE) {
	    		System.err.println("Resulting value will not fit into an int");
	    		return 0;
	    	}
	        return Integer.parseInt(new String(outputCharArr));	        
	    }
	}
	
	static public void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		Solution soln = ri.new Solution();
		
		Integer input = -500;
		System.out.println("Value: " + soln.reverse(input));
	}
}
