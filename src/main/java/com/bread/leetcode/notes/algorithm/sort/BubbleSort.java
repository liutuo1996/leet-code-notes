package com.bread.leetcode.notes.algorithm.sort;

/**
 * @program: leet-code-notes
 * @description: 冒泡排序
 * @author: LiuTuo
 * @create: 2021-08-18 07:51
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] array=new int[]{9,2,3,1,6,8};

        int temp=0;
        for(int i=0;i<array.length;i++){
            Boolean noChange=true;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    noChange=false;
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            //未发生改变，提前退出
            if(noChange){
                break;
            }
        }

        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }
}
