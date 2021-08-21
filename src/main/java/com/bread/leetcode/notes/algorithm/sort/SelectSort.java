package com.bread.leetcode.notes.algorithm.sort;

import java.util.Arrays;

/**
 * @program: leet-code-notes
 * @description: 选择排序
 * @author: LiuTuo
 * @create: 2021-08-18 11:04
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] array={5,4,3,2,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array){
        int count=0;
        for(int i=0;i<array.length-1;i++){
            count++;
            int min=array[i];
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<min){
                    min=array[j];
                    minIndex=j;
                }
            }
            //没有发生替换，排序可以提前完成
            if(minIndex==i){
                break;
            }
            array[minIndex]=array[i];
            array[i]=min;
        }
        System.out.println("count: "+count);
    }
}
