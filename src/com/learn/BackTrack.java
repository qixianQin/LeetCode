package com.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 回溯算法框架
 * @Author:qixian
 * @Date: 2021/5/16 4:11 下午
 * @Version: v1.0.0
 */
public class BackTrack {

    private static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}).toString());
    }


    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        // 记录 路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 路径： 记录在 track 中
     * 选择列表： nums 中不存在于  track 的那些元素
     * 结束条件： nums 中的元素全都在 track 中出现
     * @param nums
     * @param track
     */
    public static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }

    }

}
