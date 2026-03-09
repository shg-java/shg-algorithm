## 滑动窗口
核心思想
  滑动窗口是一种用于处理数据、字符串中连续子序列问题的技巧。通过维护一个可伸缩的窗口
在数据上滑动，避免暴力嵌套循环，将时间复杂度从O(N2)降至O(N)
## 两种类型
### 固定的窗口大小
窗口大小固定为K，整体向右滑动
```
[a b c] d e f g     初始窗口
a [b c d] e f g    右移一步
a  b [c d e] f g   右移一步
```

```
def fixed_window(arr, k):
    n = len(arr)
    if n < k:
        return []
    
    window_sum = sum(arr[:k])   # 初始化第一个窗口
    result = [window_sum]

    for i in range(k, n):
        window_sum += arr[i]        # 新元素进入窗口
        window_sum -= arr[i - k]    # 旧元素离开窗口
        result.append(window_sum)
    
    return result
```
### 可变窗口大小（更常用）
左右双指针 left、right，根据条件动态收缩/扩展窗口。
```
left                right
  ↓                   ↓
[ a  b  c  d  e  f  g ]
     ↓        ↓
   left      right    收缩后
```

