//package com.shg.two_pointers.fast_and_slow_pointer;
//
//import com.shg.algorithm.data_structure.link_list.ListNode;
//
//import java.util.Arrays;
//
///**
// * 删除重复元素（快慢指针）
// *
// * ──────────────────────────────────────────────
// * 题目一：LeetCode 26 - 删除有序数组中的重复项
// * ──────────────────────────────────────────────
// * 给一个升序数组 nums，原地删除重复元素，返回不重复元素的个数 k。
// *
// * 思路：
// *   - slow 指向已处理的无重复区间末尾，fast 向前探路
// *   - 当 nums[fast] != nums[slow] 时，将 fast 的值写到 slow+1，slow 前进
// *
// * ──────────────────────────────────────────────
// * 题目二：LeetCode 83 - 删除排序链表中的重复元素
// * ──────────────────────────────────────────────
// * 给一个排好序的链表，删除所有重复的节点，使每个值只出现一次。
// *
// * 思路：
// *   - slow 指向当前无重复链表的末尾节点
// *   - fast 向前探路，找到与 slow 值不同的节点后，接到 slow 后面
// *
// * 时间复杂度：均为 O(n)
// * 空间复杂度：均为 O(1)
// */
//public class RemoveDuplicates {
//
//    // ── LeetCode 26：有序数组去重 ──────────────────────────────
//
//    public int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int slow = 0;
//        for (int fast = 1; fast < nums.length; fast++) {
//            if (nums[fast] != nums[slow]) {
//                slow++;
//                nums[slow] = nums[fast];
//            }
//        }
//        return slow + 1; // 不重复元素个数
//    }
//
//    // ── LeetCode 83：排序链表去重 ──────────────────────────────
//
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) return null;
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (fast != null) {
//            if (fast.val != slow.val) {
//                slow.next = fast; // 将不重复节点接到 slow 后面
//                slow = slow.next;
//            }
//            fast = fast.next;
//        }
//        slow.next = null; // 断开后续可能残留的重复节点
//        return head;
//    }
//
//    public static void main(String[] args) {
//        RemoveDuplicates solution = new RemoveDuplicates();
//
//        // ── 数组去重测试 ──
//        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5};
//        int k = solution.removeDuplicates(nums);
//        System.out.println("有序数组去重：");
//        System.out.println("不重复元素个数 k = " + k);
//        System.out.println("结果数组前 k 位：" + Arrays.toString(Arrays.copyOf(nums, k)));
//        // 期望输出：[1, 2, 3, 4, 5]
//
//        System.out.println();
//
//        // ── 链表去重测试 ──
//        ListNode list = ListNode.build(1, 1, 2, 3, 3, 4, 4, 5);
//        System.out.print("排序链表去重前：");
//        ListNode.print(list);
//        ListNode result = solution.deleteDuplicates(list);
//        System.out.print("排序链表去重后：");
//        ListNode.print(result);
//        // 期望输出：1 -> 2 -> 3 -> 4 -> 5
//    }
//}
