package com.lieve.leetcode;

/**
 * Created by IntelliJ IDEA.
 * User: sunyoboy@gmail.com
 * Date: 19/2/24
 * Time: 上午10:18
 */
public class MergeSort2 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next ==null) {
            return head;
        }
        int count = 0;
        ListNode p = head;
        while(p != null) {
            ++count;
            p = p.next;
        }

        int mid = count >> 1;
        ListNode l = head;
        ListNode r = null;
        ListNode p2 = head;
        int countHalf = 0;
        while(p2 !=null ) {
            ++countHalf;
            ListNode next = p2.next;
            if(countHalf == mid) {
                p2.next = null;
                r = next;
            }
            p2 = next;
        }
        // now we have two parts, l and r
        // merge together;
        return merge(sortList(l), sortList(r));
    }

    public ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        /**
         * 快慢指针
         */
        ListNode fast;
        ListNode slow;
        fast = slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode p1 = l;
        ListNode p2 = r;
        ListNode fakeHead = new ListNode(0);
        ListNode pNew = fakeHead;
        while(p1 != null && p2 !=null) {
            if(p1 == null) {
                pNew.next = new ListNode(p2.val);
                p2 = p2.next;
                pNew = pNew.next;
            } else if (p2 == null) {
                pNew.next = new ListNode(p1.val);
                p1 = p1.next;
                pNew = pNew.next;
            } else {
                if(p1.val < p2.val) {
                    pNew.next = new ListNode(p1.val);
                    p1 = p1.next;
                    pNew = pNew.next;
                } else if (p1.val == p2.val) {
                    pNew.next = new ListNode(p1.val);
                    pNew.next.next = new ListNode(p2.val);
                    p1 = p1.next;
                    p2 = p2.next;
                    pNew = pNew.next.next;
                } else {
                    pNew.next = new ListNode(p2.val);
                    p2 = p2.next;
                    pNew = pNew.next;
                }
            }
        }

        return fakeHead.next;
    }
}
