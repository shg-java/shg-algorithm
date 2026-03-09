//package com.shg.two_pointers.fast_and_slow_pointer;
//
//import com.shg.algorithm.data_structure.link_list.ListNode;
//
///**
// * LeetCode 876 - 链表的中间节点
// *
// * 题目：给定一个头节点为 head 的非空单链表，返回链表的中间节点。
// *       如果有两个中间节点，则返回第二个中间节点。
// *
// * 思路（快慢指针）：
// *   - 慢指针每次走 1 步，快指针每次走 2 步
// *   - 当快指针到达链表末尾时，慢指针恰好在中间位置
// *
// * 示例：
// *   奇数长度：1 -> 2 -> [3] -> 4 -> 5，中间节点为 3
// *   偶数长度：1 -> 2 -> [3] -> 4 -> 5 -> 6，中间节点为 3（第二个中间节点）
// *
// * 时间复杂度：O(n)
// * 空间复杂度：O(1)
// */
//public class MiddleNode {
//
//    public ListNode middleNode(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        // fast 和 fast.next 均不为 null 时继续前进
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        // 循环结束时 slow 指向中间节点
//        return slow;
//    }
//
//    public static void main(String[] args) {
//        MiddleNode solution = new MiddleNode();
//
//        // 奇数长度：1 -> 2 -> 3 -> 4 -> 5
//        ListNode odd = ListNode.build(1, 2, 3, 4, 5);
//        System.out.print("奇数链表：");
//        ListNode.print(odd);
//        System.out.println("中间节点：" + solution.middleNode(odd).val); // 3
//
//        // 偶数长度：1 -> 2 -> 3 -> 4 -> 5 -> 6
//        ListNode even = ListNode.build(1, 2, 3, 4, 5, 6);
//        System.out.print("偶数链表：");
//        ListNode.print(even);
//        System.out.println("中间节点：" + solution.middleNode(even).val); // 4（第二个中间节点）
//    }
//}
