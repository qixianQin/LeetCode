package com.simple;

/**
 * @Description: leetCode 496
 * @Author:qixian
 * @Date: 2021/5/9 5:10 下午
 * @Version: v1.0.0
 */
public class LeetCode496 {

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
            boolean hasNext = false;
            for (int j : nums2) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    hasNext = true;
                    break;
                }
            }
            if (!hasNext) {
                result[i] = -1;
            }
            hasNext = false;
        }
        return result;
    }
}
