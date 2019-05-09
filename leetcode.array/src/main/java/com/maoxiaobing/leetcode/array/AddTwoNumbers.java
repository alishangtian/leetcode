package com.maoxiaobing.leetcode.array;

import com.alibaba.fastjson.JSONObject;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(8);
        ListNode l12 = new ListNode(2);
        l11.next = l12;
        ListNode l13 = new ListNode(1);
        l12.next = l13;
        ListNode l21 = new ListNode(7);
        ListNode l22 = new ListNode(6);
        l21.next = l22;
        ListNode l23 = new ListNode(5);
        l22.next = l23;

        System.out.println("args = [" + addTwoNumbers(l11, l21).toString() + "]");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        int sb = 10;
        int result = 0;
        do {
            result += Math.pow(sb, i) * (l1.val + l2.val);
            i++;
            l1 = l1.next;
            l2 = l2.next;
        } while (l1 != null && l2 != null);
        do {
            if (l1 != null) {
                result += Math.pow(sb, i) * l1.val;
                l1 = l1.next;
                i++;
            }
        } while (l1 != null);
        do {
            if (l2 != null) {
                result += Math.pow(sb, i) * l2.val;
                l2 = l2.next;
                i++;
            }
        } while (l2 != null);
        for (int j = 0; j < i; j++) {

        }
        return new ListNode(result);
    }
}
