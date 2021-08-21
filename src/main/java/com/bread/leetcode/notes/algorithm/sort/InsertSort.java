package com.bread.leetcode.notes.algorithm.sort;

import java.util.Arrays;

/**
 * @program: leet-code-notes
 * @description: 插入排序
 * @author: LiuTuo
 * @create: 2021-08-18 16:25
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] array={12,4,32,2,33};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array){
        //从第二个下标开始插入
        for (int i = 1; i < array.length; i++) {
            //获取当前需要插入的值
            int insertVal=array[i];
            //获取首先需要比较的值
            int insertIndex=i-1;
            //循环与当前下标前数据比较
            while (insertIndex>=0 && insertVal<array[insertIndex]){
                //将更大的数据往后移动一位
                array[insertIndex+1]=array[insertIndex];
                //继续判断
                insertIndex--;
            }
            //循环结束，将当前数字放入对应位置，insertIndex表示insertVal前一个下标
            array[insertIndex+1]=insertVal;
        }
    }
}
