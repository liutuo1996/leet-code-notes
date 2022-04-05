package com.bread.leetcode.array;

/**
 * @program: leet-code-notes
 * @description: 189 轮转数组
 * @author: LiuTuo
 * @create: 2022-04-05 14:45
 **/
public class Rotate {
    public void rotate(int[] nums, int k) {
        if(nums.length==0 || k<1){
            return;
        }
        int n=nums.length;
        int[] newArray=new int[n];
        for(int i=0;i<n;i++){
            newArray[(i+k)%n]=nums[i];
        }
        System.arraycopy(newArray,0,nums,0,n);
    }
}
