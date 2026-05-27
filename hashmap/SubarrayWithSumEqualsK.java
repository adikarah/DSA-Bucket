package main.hashmap;

import java.util.HashMap;

public class SubarrayWithSumEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        // this is for the case when we reached k sum from start to end
        mp.put(0, 1);

        int cnt = 0, sum = 0;

        for(int num: nums){
            sum += num;

            cnt += mp.getOrDefault(sum-k, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }
}
