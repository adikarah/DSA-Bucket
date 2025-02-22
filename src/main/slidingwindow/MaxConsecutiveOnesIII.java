package main.slidingwindow;

/*
    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int prev = 0, curr = 0, ans = 0, cnt = 0;

        while (curr < nums.length) {
            if (nums[curr] == 0) {
                if (cnt < k) {
                    curr += 1;
                    cnt += 1;
                } else {
                    ans = Math.max(ans, curr - prev);
                    cnt = nums[prev] == 0 ? cnt - 1 : cnt;
                    prev += 1;
                }
            } else {
                curr += 1;
            }
        }

        return ans;
    }

    public int longestOnesAnother(int[] nums, int k) {
        int prev = 0, curr = 0;
        int cnt = 0, n = nums.length;
        int ans = 0;

        while(curr < n){
            if(nums[curr] == 0){
                if(cnt < k){
                    cnt += 1;
                    curr += 1;
                }
                else{
                    ans = Math.max(ans, curr - prev);
                    while(prev <= curr && cnt >= k){
                        cnt = nums[prev] == 0 ? cnt - 1 : cnt;
                        prev += 1;
                    }
                }
            }
            else{
                curr += 1;
            }
        }

        ans = Math.max(ans, curr - prev);
        return ans;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(maxConsecutiveOnesIII.longestOnes(nums, k));

        nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        k = 3;
        System.out.println(maxConsecutiveOnesIII.longestOnes(nums, k));
    }
}
