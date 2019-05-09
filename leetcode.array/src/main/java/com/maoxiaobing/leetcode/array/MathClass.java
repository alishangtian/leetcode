package com.maoxiaobing.leetcode.array;

public class MathClass {
    public static void main(String[] args) {
//        System.out.println(new Double(Math.pow(10, 2)).intValue());
        int result = 595;
        System.out.println("args = [" + (result = result - ((result - (result / 10) * 10))) + "]");
    }
}
