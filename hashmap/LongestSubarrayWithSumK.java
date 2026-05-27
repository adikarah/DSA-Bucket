package main.hashmap;

import java.util.HashMap;

public class LongestSubarrayWithSumK {

    private int longestSubarrayWithSumK(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int curr = 0;
        int sm = 0;
        int mx = 0;
        while (curr < arr.length) {
            sm += arr[curr];

            if (sm == k) {
                mx = curr + 1;
            } else {
                if (mp.getOrDefault(sm - k, -1) != -1) {
                    mx = Math.max(mx, curr - mp.get(sm - k));
                } else {
                    mp.put(sm, curr);
                }
            }
            curr += 1;
        }

        return mx;
    }

    public static void main(String[] args) {
        LongestSubarrayWithSumK longestSubarrayWithSumK = new LongestSubarrayWithSumK();
        System.out.println(longestSubarrayWithSumK.longestSubarrayWithSumK(new int[]{10, 5, 2, 7, 1, -10}, 15));
    }
}
