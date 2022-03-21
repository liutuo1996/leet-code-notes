package com.bread.leetcode.notes.algorithm.sort;


import java.util.Arrays;

/**
 * @program: leet-code-notes
 * @description: 快速排序
 * @author: LiuTuo
 * @create: 2021-08-21 21:06
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr,int start,int end){
        //排序条件
        if(start<end){
            //默认基准数
            int stard=arr[start];
            //记录排序指针
            int low=start;
            int hight=end;
            //指针重合，结束循环
            while (low<hight){
                /**
                 * 要从基准值对立面开始循环查找，否则会造成数据比较栈溢出或者排序不正确的情况
                 * 因为有low<hight条件限制，如果还从low开始遍历，在最终相遇时会有 array[low] > stard基准数
                 */

                //找到右边比基准数小的数组指针
                while (low<hight && arr[hight]>=stard){
                    hight--;
                }

                //替换，第一轮，low指向基准数，即基准数替换到右边
                arr[low]=arr[hight];

                //找左边比基准数大的下标
                while (low<hight && arr[low]<=stard){
                    low++;
                }

                //找到了，进行替换
                arr[hight]=arr[low];
            }

            //结束循环，low与hight重合位置，即为基准数位置
            arr[low]=stard;
            //继续排序左边的数
            sort(arr,start,low);
            //继续排序右边的数
            sort(arr,low+1,end);
        }
    }
}
