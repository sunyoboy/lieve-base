package com.lieve.leetcode;

/**
 * Created by IntelliJ IDEA.
 * User: sunyoboy@gmail.com
 * Date: 19/2/24
 * Time: 下午12:47
 */
public class InsertSort {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);;
        ListNode curr;
        ListNode prev;
        ListNode next;
        prev = dummy = head;
        curr = head;
        next = head.next;
        while (curr != null && next != null) {
            if (next.val <= curr.val) {
                prev.next = curr.next;
                curr.next = next.next;
                next.next = curr;
            }
        }
        return dummy;
    }

    public static void main(String[] args) {
        String line = "[4,2,1,3]";
        ListNode head = new MergeSort().stringToListNode(line);
        System.out.println(new InsertSort().insertionSortList(head));
    }
}
