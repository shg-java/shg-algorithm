package com.shg.sort;

/**
 * @Description TODO
 * @Date 2025/11/24 16:29
 * @Created by sunhongguang
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Check {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = getNumbers(l1) + getNumbers(l2);
        return getListNode(sum);
    }
    
    public ListNode getListNode(int sum){
        int temp = sum/10;
        ListNode result =  new ListNode();
        result.val = sum%10;
        if(temp != 0){
            ListNode  parent = getListNode(temp);
            parent.next = result;
        }
        return result;
    }
    public int getNumbers(ListNode listNode){
        int unit = 1;
        int result;
        ListNode currentNode = listNode;
        do {
            result = currentNode.val * unit;
            unit = unit * 10;
            currentNode = currentNode.next;
        }while(listNode.next != null);
        return result;
    }
}
