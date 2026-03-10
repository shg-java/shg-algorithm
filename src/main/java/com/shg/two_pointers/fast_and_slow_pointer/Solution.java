package com.shg.two_pointers.fast_and_slow_pointer;


import com.shg.link_list.ListNode;

class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return  slow;
    }
}

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1;

        while (fast< nums.length) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}