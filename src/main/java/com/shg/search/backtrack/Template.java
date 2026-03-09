package com.shg.search.backtrack;

public class Template {

    /*public void backtrack(参数){
        // 终止条件（收集结果 或 剪枝）
        if (满足终止条件){
            // 收集结果
            result.add(new ArrayList<>(path))
            return;
        }
        // 2.遍历选择列表
        for(选择：选择列表){
            // 做选择
            path.add(选择);
            // 标记已使用（如需要）
            // 递归
            backtrack(下一层参数);
            // 5.撤销选择
            path.removeLast();
            // 取消标记（如需）
        }
    }*/
    /*List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    // 子集问题
    List<List<Integer>> subsets(int[] nums) {

    }

    void backtrack(int[] nums,int start){
        result.add(new ArrayList<>(path));// 每个节点都收集
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums, i + 1); // i+1避免使用同意袁旭
            path.removeLast(); // 回溯
        }
    }*/
}

