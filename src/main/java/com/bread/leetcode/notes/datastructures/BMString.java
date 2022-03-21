package com.bread.leetcode.notes.datastructures;

/**
 * @program: leet-code-notes
 * @description: BM算法（字符串匹配）
 * @author: LiuTuo
 * @create: 2021-10-27 10:57
 **/
public class BMString  {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Integer i=null;
        if(i<=0){
            System.out.println(i);
        }
    }
}
