package com.shg.link_list;

import java.util.List;

/**
  Definition for singly-linked list.
 */

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode build(List<Integer> items) {
        if (items == null || items.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(items.get(0));
        ListNode current = head;
        for (int i = 1; i < items.size(); i++) {
            Integer item = items.get(i);
            current.next = new ListNode(item);
            current = current.next;
        }
        return head;

    }
}