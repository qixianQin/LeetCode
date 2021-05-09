package com.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: LeetCode136
 * @Author:qixian
 * @Date: 2021/4/19 11:15 下午
 * @Version: v1.0.0
 */
public class LeetCode136 {

    public static void main(String[] args) {
//        System.out.println(findNumber(new int[]{2,2,1}));
//        System.out.println(findNumber(new int[]{4,1,2,1,2}));
        System.out.println(findNumber2(new int[]{2,2,1}));
        System.out.println(findNumber2(new int[]{4,1,2,1,2}));
    }


    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/single-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int findNumber(int[] nums) {
        int signal = 0;
        for (int num : nums) {
            signal ^= num;
        }
        return signal;
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public static int findNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    count++;
                    break;
                }
            }
            if (count == 1) {
                return nums[i];
            }
            count = 1;
        }
        return -1;
    }

    /**
     * 空间换时间， 使用 HashMap 存储
     * @param nums
     * @return
     */
    public static int findNumber3(int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

        }
        return -1;
    }
}
