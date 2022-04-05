package com.bread.leetcode.array;

/**
 * @program: leet-code-notes
 * @description: 27 原地移除元素
 * @author: LiuTuo
 * @create: 2022-04-05 14:50
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length<1){
            return 0;
        }
        //双指针
        int index=0;
        int end=nums.length;
        while (index<end){
            if(nums[index]==val){
                int tmp=nums[end-1];
                nums[end-1]=nums[index];
                nums[index]=tmp;
                end--;
            }else{
                index++;
            }
        }
        return index;
    }
}
