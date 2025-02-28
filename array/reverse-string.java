// Reverse a String
/**

You are given a string s, and your task is to reverse the string.

Examples:

Input: s = "Geeks"
Output: "skeeG"

Input: s = "for"
Output: "rof"

Input: s = "a"
Output: "a"

Constraints:
1 <= s.size() <= 106
s contains only alphabetic characters (both uppercase and lowercase).

**/

class Solution {
    public static String reverseString(String s) {
                
        char[] c = s.toCharArray();
        
        int i = 0;
        int j = s.length() -1 ;
        while(i < j) {
            char temp = c[j];
            c[j] = c[i];
            c[i] = temp;
            i++;
            j--;
        }
        return String.valueOf(c);


    }
}
