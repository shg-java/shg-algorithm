### 快慢指针（同向双指针）

两个指针从同一方向出发，但移动速度不同（一快一慢），利用速度差解决链表和数组中的经典问题。

---

#### 核心模板

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;        // 慢指针走 1 步
    fast = fast.next.next;   // 快指针走 2 步
}
```

---

#### 本包题目

| 文件 | 题目 | LeetCode |
|------|------|----------|
| HasCycle.java | 链表找环 + 找环入口 | 141 / 142 |
| MiddleNode.java | 链表的中间节点 | 876 |
| RemoveDuplicates.java | 删除有序数组/链表中的重复元素 | 26 / 83 |

---

#### 规律总结

- **找环**：快慢指针若相遇则有环；相遇后一个回到 head 同速走，再次相遇即为环入口
- **找中点**：快指针到末尾时，慢指针恰好在中间（常用于归并排序链表）
- **去重**：slow 维护已处理的无重复区间，fast 向前探路写入不同值
