package com.bread.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet-code-notes
 * @description: 350题  两个数组的交集
 * @author: LiuTuo
 * @create: 2022-03-21 11:01
 **/
public class ArrayIntersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> markMap=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            markMap.put(nums1[i],markMap.getOrDefault(nums1[i],0)+1);
        }
        int index=0;
        int[] result=new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            Integer count = markMap.getOrDefault(nums2[i], 0);
            if(count>0){
                markMap.put(nums2[i],--count);
                result[index]=nums2[i];
                index++;
            }else{
                markMap.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }
}
