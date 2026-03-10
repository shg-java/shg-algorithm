package com.shg.recursion.normal;


import com.google.common.collect.Lists;
import com.shg.link_list.ListNode;

import java.util.ArrayList;

class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(Lists.newArrayList(2, 1, 3));
        SwapPairs swapPairs = new SwapPairs();
        swapPairs.swapPairs(head);
    }

}