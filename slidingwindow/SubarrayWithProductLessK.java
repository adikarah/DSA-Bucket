package main.slidingwindow;

public class SubarrayWithProductLessK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length;
        int mult = 1, ans = 0;

        while (right < n) {
            mult *= nums[right++];
            while (left < right && mult >= k) {
                mult /= nums[left++];
            }

            ans += (right - left);
        }

        return ans;
    }

    public static int numSubArrayProductLessThanKWithZerosAndNegative(int[] nums, int k) {
        int left = 0, right = 0;
        int mul = 1, cnt = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                mul = 1;
                left = right + 1;
                right += 1;
                continue;
            }

            mul *= nums[right];

            /* if (mul < 0) {
                while (left <= right && mul < 0) {
                    mul /= nums[left++];
                }
            } */

            while (left <= right && mul > k) {
                mul /= nums[left++];
            }

            if (mul < k) {
                cnt += (right - left + 1);
            }

            right++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(numSubArrayProductLessThanKWithZerosAndNegative(new int[]{10, -5, 2, 6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{10, -5, 2, 6}, 100));
    }
}
