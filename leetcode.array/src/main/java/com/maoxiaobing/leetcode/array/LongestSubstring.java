package com.maoxiaobing.leetcode.array;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String str = "abcdefghijk";
        System.out.println("result =  " + JSONObject.toJSONString(lengthOfLongestSubstring(str)) + " ");
    }

    /**
     * @param str
     * @return
     * @result 执行用时 : 291 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了8.73% 的用户
     * 内存消耗 : 160.3 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了5.00% 的用户
     */
    public static int lengthOfLongestSubstring(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        Set<String> charSet = new HashSet<String>();
        int sizeBefore;
        int longestSize = 0;
        Map<String, Integer> indexMap = new HashMap<String, Integer>();
        String cur;
        while (i < chars.length) {
            sizeBefore = charSet.size();
            charSet.add((cur = String.valueOf(chars[i])));
            if (charSet.size() == sizeBefore) {
                if (longestSize < charSet.size()) {
                    longestSize = charSet.size();

                }
                charSet.clear();
                i = indexMap.get(cur) + 1;
                indexMap.clear();
                continue;
            } else {
                longestSize = longestSize < charSet.size() ? charSet.size() : longestSize;
                indexMap.put(cur, i);
            }
            i++;
        }
        return longestSize;
    }
}
