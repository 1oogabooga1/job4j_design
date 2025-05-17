package ru.job4j.leetcode;

public class MergeTwoLists {
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode dummy = new ListNode();
        ListNode iterator = dummy;
        return result;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;

        ListNode next;

        public ListNode() { }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(ListNode next, int val) {
            this.val = val;
            this.next = next;
        }
    }
}
