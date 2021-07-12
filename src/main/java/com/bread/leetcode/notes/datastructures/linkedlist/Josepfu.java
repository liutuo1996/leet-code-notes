package com.bread.leetcode.notes.datastructures.linkedlist;

import lombok.Data;

/**
 * @program: leet-code-notes
 * @description: 单向环形链表解决约瑟夫问题
 * @author: LiuTuo
 * @create: 2021-07-08 22:10
 **/
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(2,3,5);
    }
}

class CircleSingleLinkedList{
    //头部节点
    private Boy first=null;

    /**
     * 创建环形链表
     * @param nums 链表节点数量
     */
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("节点数量不能少于1");
            return;
        }
        //辅助变量
        Boy curBoy=null;
        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.next=first;
                curBoy=first;
            }else{
                curBoy.next=boy;
                boy.next=first;
                curBoy=curBoy.next;
            }
        }
    }

    /**
     * 打印环形链表
     */
    public void show(){
        if(first==null){
            System.out.println("链表为空");
            return;
        }

        //辅助变量
        Boy curBoy=first;
        while (true){
            System.out.println("第 "+curBoy.getNo()+" 个孩子");
            if(curBoy.next==first){
                break;
            }
            curBoy=curBoy.next;
        }
    }

    /**
     * 核心出圈方法
     * @param startNo 从第几个男孩开始报数
     * @param countNum 报数 需要小于nums
     * @param nums 男孩数量
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(first==null || startNo<1 || startNo>nums){
            System.out.println("参数错误");
            return;
        }
        //循环获取尾结点
        Boy tailBoy=first;
        while (true){
            if(tailBoy.getNext()==first){
                break;
            }
            tailBoy=tailBoy.getNext();
        }

        //从第几个开始数，头尾节点共同位移
        for(int i=0;i<startNo-1;i++){
            first=first.getNext();
            tailBoy=tailBoy.getNext();
        }

        //开始报数，循环淘汰出男孩
        while (tailBoy!=first){
            for(int i=0;i<countNum-1;i++){
                first=first.getNext();
                tailBoy=tailBoy.getNext();
            }
            System.out.println("编号为："+first.getNo()+" 小朋友出圈");
            first=first.getNext();
            tailBoy.setNext(first);
        }
        //最后一位小朋友
        System.out.println("编号为："+first.getNo()+" 小朋友出圈");
    }


    @Data
    class Boy{
        //男孩编号
        private Integer no;
        private Boy next;

        public Boy(Integer no) {
            this.no = no;
        }
    }
}

