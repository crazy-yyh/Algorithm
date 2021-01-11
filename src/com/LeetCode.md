# LeetCode

## 两数之和---TwoSum--1

### 题目描述

> ```
> 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数
> 并返回它们的数组下标。 
> 
> 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
> 你可以按任意顺序返回答案。 
> 
> 示例 1： 
> 输入：nums = [2,7,11,15], target = 9
> 输出：[0,1]
> 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
> 
> 示例 2： 
> 输入：nums = [3,2,4], target = 6
> 输出：[1,2]
> 
> 示例 3： 
> 输入：nums = [3,3], target = 6
> 输出：[0,1]
> 
> 提示： 
> 
> 2 <= nums.length <= 103 
> -109 <= nums[i] <= 109 
> -109 <= target <= 109 
> 只会存在一个有效答案 
> 
> Related Topics 数组 哈希表 
> ```

### 解题方法

#### 方法一：双重循环

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1;j <= nums.length -1; j++){
                if(target == (nums[i] + nums[j])){
                    return new int[]{i,j};
                }
            }
        }
         return new int[0];
    }
   
}
```

复杂度分析

时间复杂度：O(N^2^)，其中 NN 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。

空间复杂度：O(1)。

#### 方法二： 哈希表

```java
class Solution {
    public int[] twoSum(int[] nums,int target) {

        Map<Integer,Integer> hashmap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {

            if(hashmap.containsKey(target-nums[i])){
                return new int[]{hashmap.get(target-nums[i]),i};
            }
            hashmap.put(nums[i],i);
        }

        return new int[0];

    }
}
```

复杂度分析

时间复杂度：O(N)，其中 N是数组中的元素数量。对于每一个元素 x，我们可以 O(1)地寻找 target - x。

空间复杂度：O(N)，其中 NN 是数组中的元素数量。主要为哈希表的开销。





