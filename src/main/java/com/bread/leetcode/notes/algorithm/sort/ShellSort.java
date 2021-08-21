package com.bread.leetcode.notes.algorithm.sort;

import java.util.Arrays;

/**
 * @program: leet-code-notes
 * @description: 希尔排序
 * @author: LiuTuo
 * @create: 2021-08-20 15:55
 **/
public class ShellSort{


    public static void main(String[] args) {
        int[] array={90,22,3,11,4,544,223};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array){
        //循环分组,分组颗粒度逐渐减少
        for(int grep=array.length/2;grep>0;grep/=2){
            for(int i=grep;i<array.length;i++){
                int j=i;
                int indexVal=array[j];
                if(array[j]<array[j-grep]){
                    while (j-grep>=0 && indexVal<array[j-grep]){
                        array[j]=array[j-grep];
                        j-=grep;
                    }
                    array[j]=indexVal;
                }
            }
        }

    }
}
