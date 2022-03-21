package com.bread.leetcode.notes.algorithm.sort;

import java.util.Arrays;

/**
 * @program: leet-code-notes
 * @description: 计数排序
 * @author: LiuTuo
 * @create: 2021-09-16 10:30
 **/
public class CountingSort {

    public static void main(String[] args) {
        int[] arr={8,5,1,9,3,2,3,3};
        sort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int length=arr.length;
        if(length<2){
            return;
        }

        //找到最大数，进行分桶
        int max=arr[0];
        for(int i=1;i<length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }

        //计数数组
        int[] countArr=new int[max+1];
        //计数
        for(int i=0;i<length;i++){
            countArr[arr[i]]=countArr[arr[i]]+1;
        }


        //累计
        for(int i=1;i<countArr.length;i++){
            countArr[i]=countArr[i]+countArr[i-1];
        }
        System.out.println(Arrays.toString(countArr));
        //临时数组
        int[] temp=new int[length];
        for(int i=0;i<length;i++){
            int index=countArr[arr[i]]-1;
            temp[index]=arr[i];
            countArr[arr[i]]--;
        }
        System.out.println(Arrays.toString(temp));

        for(int i=0;i<length;i++){
            arr[i]=temp[i];
        }
    }
}
