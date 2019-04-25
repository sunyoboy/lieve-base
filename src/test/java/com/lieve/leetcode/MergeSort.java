package com.lieve.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sunyoboy@gmail.com
 * Date: 19/2/24
 * Time: 上午9:37
 */
public class MergeSort {

    public ListNode merge(ListNode first, ListNode second) {
        ListNode dummyHead;
        ListNode curr;
        dummyHead = new ListNode(0);
        curr = dummyHead;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        curr.next = (first == null) ? second : first;
        return dummyHead.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middleListNode = getMiddleNode(head);
        ListNode secondHalfHead = middleListNode.next;
        middleListNode.next = null;
        return merge(sortList(head), sortList(secondHalfHead));
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

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        String line = "[4,2,1,3]";
        ListNode head = stringToListNode(line);

        ListNode ret = new MergeSort().sortList(head);

        String out = listNodeToString(ret);

        System.out.print(out);
    }

}
