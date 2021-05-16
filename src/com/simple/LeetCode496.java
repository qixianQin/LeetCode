package com.simple;

/**
 * @Description: leetCode 496
 * @Author:qixian
 * @Date: 2021/5/9 5:10 下午
 * @Version: v1.0.0
 */
public class LeetCode496 {

    public static void main(String[] args) {
        int[] result = nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 暴力解法： 时间复杂度  O(n^2)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return null;
        }
        int[] result = new int[nums1.length];
        for (int i : result) {
            result[i] = -1;
        }
        if (nums2 == null || nums2.length == 0) {
            return result;
        }
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    
                }
            }
        }
        return result;
    }
}
