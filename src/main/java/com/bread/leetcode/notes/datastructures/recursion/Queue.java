package com.bread.leetcode.notes.datastructures.recursion;

/**
 * @program: leet-code-notes
 * @description: N皇后  回溯算法
 * @author: LiuTuo
 * @create: 2021-08-11 11:24
 **/
public class Queue {
    /**
     * 皇后个数，行数列数
     */
    int max=8;

    /**
     * 初始化数组
     */
    int[] array=new int[max];

    /**
     * 解法总数
     */
    static int count;

    public static void main(String[] args) {
        Queue queue=new Queue();
        queue.check(0);
        System.out.println("共有 "+count+" 种算法");
    }


    /**
     * 判断下子位置是否合规
     * @param n 表示行,放置第n个皇后
     * @return
     */
    private Boolean judge(int n){
        for (int i=0;i<n;i++){
            //array[i]==array[n] 表示在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i]) 判断是否在同一斜线
            //n为递增，无需判断是否在同一行
            if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 核心方法，递归得出所有解法
     * @param n 放置第N个皇后
     */
    private void check(int n){
        //所有皇后已经放置完，打印解法
        if(n==max){
            print();
            return;
        }
        //循环列，查看是否合法，合法就放置下一个皇后
        for(int i=0;i<max;i++){
            array[n]=i;
            if(judge(n)){
                //放置成功，开始放下一个皇后
                check(n+1);
            }
        }
    }

    /**
     * 解法输出
     */
    private void print(){
        //总数增加
        count++;
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+"  ");
        }
        System.out.println();
    }
}
