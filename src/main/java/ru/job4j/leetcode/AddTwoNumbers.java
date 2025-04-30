package ru.job4j.leetcode;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return fromReversedIntToListNode(fromListNodeToReverseInt(l1).add(fromListNodeToReverseInt(l2)));
    }

    public static BigInteger fromListNodeToReverseInt(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = listNode;
        while (curr != null) {
            sb.insert(0, curr.val);
            curr = curr.next;
        }
        return new BigInteger(sb.toString());
    }

    public static ListNode fromReversedIntToListNode(BigInteger num) {
        if (num.equals(BigInteger.ZERO)) {
            return new ListNode(0);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (num.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divAndRemainder = num.divideAndRemainder(BigInteger.TEN);
            int digit = divAndRemainder[1].intValue();
            current.next = new ListNode(digit);
            current = current.next;
            num = divAndRemainder[0];
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + (next != null ? " -> " + next : "");
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(1);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
