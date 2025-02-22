package main.hashmap;

import java.util.HashMap;

public class SubarrayWithDivisionEqualsK {

    public int subarrayDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        // this is for the case when we reach end from begin
        mp.put(0, 1);

        int sm = 0;
        int ans = 0;

        for (int num : nums) {
            sm += num;

            int rem = (sm % k + k) % k;
            ans += mp.getOrDefault(rem, 0);
            mp.put(rem, mp.getOrDefault(rem, 0) + 1);

        }

        return ans;
    }
}
