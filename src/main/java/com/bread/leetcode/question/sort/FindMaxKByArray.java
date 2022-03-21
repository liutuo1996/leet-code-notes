package com.bread.leetcode.question.sort;

import java.time.LocalDateTime;

/**
 * @program: leet-code-notes
 * @description: 查找数组中第K大元素
 * @author: LiuTuo
 * @create: 2021-09-11 08:16
 **/
public class FindMaxKByArray {


    public int find(int[] array,int k){
        int r=array.length-1;
        int l=0;
        while (true){
            int p = partition(array, l, r);
            if(p==k-1){
                return array[p];
            }else if(k-1<p){
                //要从左侧查找
                r=p-1;
            }else{
                //从右侧开始查找
                l=p+1;
            }
        }
    }

    /**
     * 从大到小划分区域
     * @param array
     * @param l
     * @param r
     * @return
     */
    public int partition(int[] array,int l,int r){
        int pivot=array[l];
        //指针相遇，循环结束，基准数放在相遇点
        while (l<r){
            //需要从基准数对立面开始查找，否则会导致最终相遇点不正确
            //找到右边比基准数大的下标
           while (l<r && array[r]<=pivot){
               //小的跳过 不用交换
               r--;
           }
           //放入左边
           array[l]=array[r];

           //找到左边比基准数小的下标
           while (l<r && array[l]>=pivot){
               l++;
           }
           //放入右边
           array[r]=array[l];
        }
        array[l]=pivot;
        return l;
    }

}
