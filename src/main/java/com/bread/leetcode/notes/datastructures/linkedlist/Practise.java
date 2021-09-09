package com.bread.leetcode.notes.datastructures.linkedlist;

import javafx.beans.binding.When;
import lombok.Data;

import java.util.Stack;

/**
 * @program: leet-code-notes
 * @description: 练习
 * @author: LiuTuo
 * @create: 2021-08-28 11:39
 **/
public class Practise {

    /**
     * 初始化单链表
     * @param arr
     */
    private SingleNode initSingleList(int[] arr){
        SingleNode singleHead=new SingleNode();
        SingleNode temp=null;
        for (int i = 0; i <arr.length ; i++) {
            SingleNode singleNode=new SingleNode(arr[i]);
            if(i==0){
                singleHead.next=singleNode;
            }else{
                temp.next=singleNode;
            }
            temp=singleNode;
        }
        return singleHead;
    }

    /**
     * 单链表打印
     */
    private void singleListShow(SingleNode singleHead){
        SingleNode temp=singleHead.getNext();
        while (temp!=null){
            System.out.println(temp.getVal());
            temp=temp.getNext();
        }
    }

    private static String test=new String("test");

    public static void main(String[] args) {
        Practise practise=new Practise();
        /*int[] arr={2,3,7,5,4};
        SingleNode singleNode = practise.initSingleList(arr);
        practise.reverse(singleNode);
        practise.singleListShow(singleNode);*/

        /*int[] arr1={2,3,4,5};
        int[] arr2={1,6};

        SingleNode sn1 = practise.initSingleList(arr1);
        SingleNode sn2 = practise.initSingleList(arr2);
        SingleNode mergesingle = practise.mergesingle(sn1, sn2);
        practise.singleListShow(mergesingle);*/

    }

    /**
     * 单链表反转
     * @param singleHead
     */
    private void reverse(SingleNode singleHead){
        SingleNode pre=null;
        SingleNode temp=singleHead.getNext();
        while (temp!=null){
            SingleNode next=temp.next;
            temp.next=pre;
            pre=temp;
            temp=next;
        }
        singleHead.setNext(pre);
    }

    /**
     * 合并有序列表
     * @param sn1
     * @param sn2
     * @return
     */
    private SingleNode mergesingle(SingleNode sn1,SingleNode sn2){
        if (sn1.getNext() == null) {
            return sn2;
        }

        if (sn2.getNext() == null) {
            return sn1;
        }

        SingleNode singleHead=new SingleNode();
        sn1=sn1.getNext();
        sn2=sn2.getNext();

        SingleNode temp=null;
        if(sn1.getVal()<=sn2.getVal()){
            singleHead.next=sn1;
            sn1=sn1.next;
        }else{
            singleHead.next=sn2;
            sn2=sn2.next;
        }
        temp=singleHead.getNext();
        while (sn1!=null && sn2!=null){
            if(sn1.getVal()<=sn2.getVal()){
                temp.next=sn1;
                sn1=sn1.next;
            }else{
                temp.next=sn2;
                sn2=sn2.next;
            }
            temp=temp.getNext();
        }

        if(sn1==null){
            temp.setNext(sn2);
        }

        if(sn2==null){
            temp.setNext(sn1);
        }

        return singleHead;
    }

    /**
     * 判断链表中环
     * @param singleHead
     * @return
     */
    private Boolean hasLoop(SingleNode singleHead){
        SingleNode fast=singleHead.getNext();
        SingleNode slow=singleHead.getNext();

        while (fast!=null && fast.getNext()!=null){
            fast=fast.getNext().getNext();
            slow=slow.getNext();
            if(fast.getVal()==slow.getVal()){
                return true;
            }
        }
        return false;
    }

    /**
     * 删除链表倒数n位
     * @param n
     */
    private SingleNode removeEnd(SingleNode singleHead,int n){
        SingleNode fast=singleHead.next;
        SingleNode slow=singleHead.next;
        for(int i=0;i<n;i++){
            fast=fast.getNext();
            if(fast==null){
                return singleHead;
            }
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return singleHead;
    }

    /**
     * 寻找链表中间节点
     * @param singleHead
     * @return
     */
    private SingleNode findMedian(SingleNode singleHead){
        SingleNode fast=singleHead.getNext();
        SingleNode slow=singleHead.getNext();
        while (fast!=null && fast.getNext()!=null){
            fast=fast.next.next;
            slow=slow.getNext();
        }
        if(fast!=null){
            slow=slow.next;
        }
        return slow;
    }


    /**
     * 单链表结构
     */
    @Data
    class SingleNode{
        private int val;
        private SingleNode next;

        public SingleNode(int val) {
            this.val = val;
        }

        public SingleNode(){

        }
    }
}
