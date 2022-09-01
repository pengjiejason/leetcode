package com.jason.leetcode;

import java.util.ArrayList;

/**
 *
 * @author jason
 * @date 2022/8/31
 */
public class _234_PalindromeLinkedList {

    public static void main(String[] args) {
//        System.out.println(isPalindrome1(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))))));
        System.out.println(isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1, null)))))));
        System.out.println(isPalindrome2(new ListNode(1, new ListNode(2,null ))));
    }

    /**
     * 解法不是很好.
     * 空间复杂度O(n), 时间复杂度O(3/2n)
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        if (head.next == null) {
            return true;
        }
        ListNode index = head;
        while (index != null) {
            list.add(index.val);
            index = index.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if(list.get(i) != list.get(list.size()-1-i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * O(1), O(n)
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null) {
            return true;
        }
        ListNode half = null;
        while (fast != null && fast.next != null)  {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = half;
            half = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (half != null) {
            if (half.val != slow.val) {
                return false;
            }
            half = half.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
     public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
