package com.bread.leetcode.notes.datastructures.queue;

/**
 * @program: leet-code-notes
 * @description: 数组循环队列
 * @author: LiuTuo
 * @create: 2021-07-01 22:03
 **/
public class ArrayQueue {
    /**
     * 不采用取模方式
     * 使用count记录队列个数
     * 利用队列最长长度来判断队头和对尾
     */

    //队列个数
    private int count;

    //队列最大容量
    private int maxSize;

    //队列头部下标
    private int head;

    //队列尾部下标
    private int tail;

    //队列
    private int[] queue;

    /**
     * 初始化队列，定义队列最大容量
     * @param maxSize
     */
    public ArrayQueue(int maxSize){
        queue=new int[maxSize];
        this.maxSize=maxSize;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    private Boolean isEmpty(){
        return count==0;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    private Boolean isFull(){
        return count>=maxSize;
    }

    /**
     * 添加数据进入队列
     * @param value
     */
    private void addQueue(int value) throws Exception {
        if(isFull()){
            //为空抛出异常
            throw new Exception();
        }
        //判断队尾是否超过最大下标
        if(tail==maxSize){
            tail=0;
        }
        queue[tail]=value;
        tail++;
        count++;
    }

    /**
     * 取出数据
     * @return
     */
    private int getQueue() throws Exception {
        if(isEmpty()){
            //为空抛出异常
            throw new Exception();
        }
        //判断是否需要重置队头
        if(head==maxSize-1){
            head=0;
        }
        int result=queue[head];
        head++;
        count--;
        return result;
    }

    /**
     * 展示队列
     */
    private void showQueue(){
        for(int i=head;i<head+count;i++){
            //由于循环队列，不能直接用i，通过取模获得下标位置
            System.out.println(i%maxSize+":"+queue[i%maxSize]);
        }
    }


    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue=new ArrayQueue(5);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.addQueue(5);
        arrayQueue.showQueue();

        arrayQueue.getQueue();
        arrayQueue.getQueue();
        arrayQueue.showQueue();

        arrayQueue.addQueue(6);
        arrayQueue.addQueue(7);
        arrayQueue.showQueue();

    }
}
