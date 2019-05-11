package com.maoxiaobing.leetcode.array;

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
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(9);
        l11.next = l12;
        ListNode l13 = new ListNode(9);
        l12.next = l13;
        ListNode l21 = new ListNode(8);
        System.out.println("args = [" + addTwoNumbers2(l11, l21).toString() + "]");
    }

    /**
     * 考虑进位下的链表循环
     *
     * @param l1
     * @param l2
     * @return
     * @result 执行用时 : 11 ms, 在Add Two Numbers的Java提交中击败了75.22% 的用户
     * 内存消耗 : 41.9 MB, 在Add Two Numbers的Java提交中击败了93.28% 的用户
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int forward = 0;
        ListNode head = null, current = null;
        do {
            int result = 0;
            result += l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
            result += forward;
            forward = result > 9 ? 1 : 0;
            if (null == head) {
                head = new ListNode(result % 10);
                current = head;
                continue;
            }
            current.next = new ListNode(result % 10);
            current = current.next;
        } while (l1 != null && l2 != null);
        while (l1 != null) {
            int result = 0;
            result += l1.val + forward;
            forward = result > 9 ? 1 : 0;
            current.next = new ListNode(result % 10);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int result = 0;
            result += l2.val + forward;
            forward = result > 9 ? 1 : 0;
            current.next = new ListNode(result % 10);
            current = current.next;
            l2 = l2.next;
        }
        if (forward == 1) {
            current.next = new ListNode(1);
        }
        return head;
    }
}
