package com.shg.two_pointers.fast_and_slow_pointer;

import com.shg.algorithm.data_structure.link_list.ListNode;

/**
 * LeetCode 141 - 环形链表（链表找环）
 *
 * 题目：给定一个链表，判断链表中是否有环。
 *
 * 思路（Floyd 判圈算法）：
 *   - 慢指针每次走 1 步，快指针每次走 2 步
 *   - 若链表有环，快慢指针一定会在环内相遇
 *   - 若无环，快指针会先到达 null
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 进阶 - LeetCode 142：找到环的入口节点
 *   - 相遇后，将其中一个指针重置到 head
 *   - 两指针同速前进，再次相遇点即为环的入口
 */
//public class HasCycle {
//
//    /** 判断链表是否有环 */
//    public boolean hasCycle(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 进阶：找到环的入口节点（LeetCode 142）
//     * 数学原理：设头到入口距离为 a，入口到相遇点距离为 b，环剩余长度为 c
//     *           相遇时：slow 走了 a+b，fast 走了 a+b+n*(b+c)
//     *           因为 fast = 2*slow，推出 a = n*(b+c) - b = (n-1)*(b+c) + c
//     *           即 a ≡ c (mod 环长)，所以从 head 和相遇点同速走，会在入口相遇
//     */
//    public ListNode detectCycle(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                // 找到相遇点后，一个指针回到 head，同速前进
//                ListNode finder = head;
//                while (finder != slow) {
//                    finder = finder.next;
//                    slow = slow.next;
//                }
//                return finder; // 环的入口
//            }
//        }
//        return null; // 无环
//    }
//
//    public static void main(String[] args) {
//        HasCycle solution = new HasCycle();
//
//        // 构建有环链表: 1 -> 2 -> 3 -> 4 -> 5 -> (回到3)
//        ListNode head = ListNode.build(1, 2, 3, 4, 5);
//        ListNode node3 = head.next.next;   // 节点3
//        ListNode node5 = head.next.next.next.next; // 节点5
//        node5.next = node3;                // 制造环：5 指向 3
//
//        System.out.println("有环链表 - hasCycle: " + solution.hasCycle(head));  // true
//        ListNode entrance = solution.detectCycle(head);
//        System.out.println("环的入口节点值: " + (entrance != null ? entrance.val : "null")); // 3
//
//        // 无环链表
//        ListNode noLoop = ListNode.build(1, 2, 3, 4, 5);
//        System.out.println("无环链表 - hasCycle: " + solution.hasCycle(noLoop)); // false
//    }
//}
