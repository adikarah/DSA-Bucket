package main.slidingwindow;

/*
 * Given a string input of length n, find the length of the longest substring without
 * repeating characters i.e return a substring that does not have any repeating characters.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestDistinctSubsequence {

    public static int uniqueSubstrings(String input) {
        //write your code here
        Set<Character> charSet = new HashSet<>();
        int ans = 0;
        int prev = 0, curr = 1;
        charSet.add(input.charAt(prev));

        while (curr < input.length()) {
            char ch = input.charAt(curr);

            if (charSet.contains(ch)) {
                ans = Math.max(ans, curr - prev);
                charSet.remove(input.charAt(prev));
                prev += 1;
            } else {
                charSet.add(ch);
                curr += 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(LongestDistinctSubsequence.uniqueSubstrings(str));

        str = "aaaa";
        System.out.println(LongestDistinctSubsequence.uniqueSubstrings(str));
    }
}
