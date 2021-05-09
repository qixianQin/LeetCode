package com.medium;

/**
 * @Description: LeetCode19  删除链表倒数第N个节点
 * @Author:qixian
 * @Date: 2021/4/29 10:17 上午
 * @Version: v1.0.0
 */
public class LeetCode19 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next  = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head ) {
            return null;
        }
        ListNode pre = head;
        ListNode current = head;
        ListNode beforeNthListNode = null;

        while(n > 0) {
//            beforeNthListNode =
        }

        return head;

    }
}
