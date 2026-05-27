package main.hashmap;

import java.util.HashMap;

public class LongestSubarrayWithEqual0sand1s {

    private int longestSubarrayWithEqual0and1s(int[] arr) {

        int sm = 0;
        int curr = 0;
        int mx = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        while (curr < arr.length) {
            if (arr[curr] == 0) {
                sm -= 1;
            } else {
                sm += 1;
            }

            if (sm == 0) {
                mx = curr + 1;
            } else {
                if (mp.getOrDefault(sm, -1) != -1) {
                    mx = Math.max(mx, curr - mp.get(sm));
                } else {
                    mp.put(sm, curr);
                }
            }
            curr += 1;
        }
        return mx;
    }

    public static void main(String[] args) {
        LongestSubarrayWithEqual0sand1s longestSubarrayWithEqual0sand1s = new LongestSubarrayWithEqual0sand1s();
        int[] arr = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println(longestSubarrayWithEqual0sand1s.longestSubarrayWithEqual0and1s(arr));
    }
}
