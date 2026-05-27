package main.slidingwindow;

// Given a binary array nums, return the maximum number of consecutive 1's in the array.

public class MaxConsecutiveOnesI {

    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0, cnt = 0, ans = 0;

        while (curr < nums.length) {
            if (nums[curr] == 1) {
                cnt += 1;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 0;
            }

            curr += 1;
        }

        return Math.max(ans, cnt);
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesI maxConsecutiveOnesI = new MaxConsecutiveOnesI();

        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(maxConsecutiveOnesI.findMaxConsecutiveOnes(nums));

        nums = new int[]{1, 0, 1, 1, 0, 1};
        System.out.println(maxConsecutiveOnesI.findMaxConsecutiveOnes(nums));

    }
}
