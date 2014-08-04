package deque;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of time intervals in any order, merge all overlapping 
 * intervals into one and output the result which should have only 
 * mutually exclusive intervals. Let the intervals be represented as 
 * pairs of integers for simplicity. 
 * 
 * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. 
 * The intervals {1,3} and {2,4} overlap with each other, so they 
 * should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} 
 * should be merged and become {5, 8}
 */

/*
 * Notes: This implementation uses the fact that when the intervals are 
 *        sorted by first value, if interval 'i' does not overlap 'i-1',
 *        then interval 'i+1' will not overlap 'i-1'.
 */

/*
 * Algorithm to implement:
 *      1) Sort the intervals
 *      2) Push the first interval onto the stack
 *      3) 3a) If next interval does NOT overlap with interval on the stack, then 
 *             push that next interval onto the stack
 *         3b) If interval 'i' DOES overlap with interval on the stack 'i-1', then 
 *             check if the interval 'i' has a greater second value.  If so, then
 *             replace the second value of 'i-1' with 'i'.
 *      4) When no more intervals to check, the stack will contain all the overlaps
 */
public class OverlappingIntervals {
	List<Interval> intervals;
	
	public OverlappingIntervals() {
		intervals = new ArrayList<Interval>();
	}
	
	public void sortIntervals() {
		// Simple sort, then more complex
	}
	
	public static void main (String[] arg) {
		
	}
	
	public class Interval {
		public int begin;
		public int end;
		
		public Interval(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
	}
}
