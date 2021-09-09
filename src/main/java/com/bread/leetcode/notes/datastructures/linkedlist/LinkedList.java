package com.bread.leetcode.notes.datastructures.linkedlist;

import lombok.Data;
import org.w3c.dom.Node;

import javax.sound.midi.Soundbank;


/**
 * @program: leet-code-notes
 * @description: 判断一个字符串是否回文字符串
 * @author: LiuTuo
 * @create: 2021-08-27 16:01
 **/
public class LinkedList {
    private static Node frist=new Node("");

    public static void main(String[] args) {
        String s="abcd";
        Node node=null;
        //将字符串转化为链表
        for (int i=0;i<s.length();i++){
            if(i==0){
                frist=new Node(s.charAt(i)+"");
                node=frist;
            }else{
                Node n=new Node(s.charAt(i)+"");
                node.nextNode=n;
                node=n;
            }
        }
        //快慢节点
        Node fast=frist;
        Node slow=frist;

        //反转
        Node prev = null;

        while (fast!=null && fast.nextNode!=null){
            fast=fast.nextNode.nextNode;
            //反转前段链表
            Node next=slow.nextNode;
            slow.nextNode=prev;
            prev=slow;
            //慢节点停在中心位
            slow=next;
        }

        //如果为奇数字符串，slow下移一位
        if (fast!=null){
            slow=slow.nextNode;
        }

        Boolean b=true;

        //慢节点继续往后遍历，与之前反转的前段链表做比较
        while (slow!=null){
            if(!prev.getVal().equals(slow.getVal())){
                b=false;
                break;
            }
            prev=prev.nextNode;
            slow=slow.nextNode;
        }
        if(b){
            System.out.println("是回文字");
        }else{
            System.out.println("不是回文字");
        }
    }

/**
     * 节点
     */
    @Data
    private static class Node {
        //节点业务数据
        private String val;

        //指向下一节点
        private LinkedList.Node nextNode;

        public Node(String val) {
            this.val = val;
        }
    }

    public static void show(Node node){
        while (node!=null){
            System.out.println(node.getVal());
            node=node.nextNode;
        }
    }
}
