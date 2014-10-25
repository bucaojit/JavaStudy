package leetcode.onlinejudge;

/**
 * Created by Oliver on 10/21/14.
 */

/*
   Given a string, find the length of the longest substring without repeating characters.
   For example, the longest substring without repeating letters for "abcabcbb" is "abc",
   which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstrWithoutRepeats {
    public int lengthOfLongestSubstring(String s) {
        int[] charInt = new int[256 + 1];
        int max = 0;
        int currentCounter = 0;
        int index;
        //String sCopy = s.toLowerCase();
        String sCopy = s;
        /*
            Cases:
            1) at the start, the length is 1.
            2) if value is repeated, check if within this count run
                  -how to check if it is repeated:
                   if last index of current character is within i-currentCounter

               example:
                   a  b  c  a  r  k  b
                   1  2  3  1

                   current 'a' is 3, last 'a' is 0, counter is 3
                   3 - 0 = 3, 3 <= max of 3 so max remains 3, but counter is reset
         */

        /*
         * Initial attempt: didn't work, Need to figure out when the value is within the current run but at the
         * beginning, don't need to reset the counter at that point.
         *
        for(int i = 0; i < sCopy.length(); i++) {
            index = (int)sCopy.charAt(i);

            if(charInt[index] == 0) {
                // First time hitting value
                currentCounter++;
                charInt[index] = i+1;
                max = Math.max(currentCounter, max);
                continue;
            }

            if(charInt[index] > i-currentCounter-1) {
                currentCounter = 1;
            }
            else {
                currentCounter++;
                max = Math.max(currentCounter, max);
            }
            charInt[index] = i+1;
            //System.out.println(index);
        }
        */

        for(int i = 0; i < sCopy.length(); i++) {
            index = (int)sCopy.charAt(i);

            if(charInt[index] == 0) {
                // First time hitting value
                currentCounter++;
                charInt[index] = i+1;
                max = Math.max(currentCounter, max);
                continue;
            }

            //if(charInt[index] > i-currentCounter-1) {
            char e = sCopy.charAt(i);
            int j = charInt[index];
            if(charInt[index] > i-currentCounter) {
                currentCounter = i - charInt[index] + 1;
            }
            else {
                currentCounter++;
                max = Math.max(currentCounter, max);
            }
            charInt[index] = i+1;
            //System.out.println(index);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstrWithoutRepeats myclass = new LongestSubstrWithoutRepeats();

        System.out.println(myclass.lengthOfLongestSubstring("abcabcbb"));
    }
}
