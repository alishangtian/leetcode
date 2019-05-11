package com.maoxiaobing.leetcode.array;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        System.out.println("twoSum result =  " + JSONObject.toJSONString(twoSum(nums, target)) + " ");
    }

    /**
     * @param nums
     * @param target
     * @return
     * @result 执行用时 : 8 ms, 在Two Sum的Java提交中击败了86.58% 的用户
     * 内存消耗 : 37.8 MB, 在Two Sum的Java提交中击败了83.09% 的用户
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int j;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey((j = target - nums[i]))) {
                return new int[]{i, map.get(j)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
