package com.bread.leetcode.notes.datastructures.linkedlist;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @program: leet-code-notes
 * @description: 单链表
 * @author: LiuTuo
 * @create: 2021-07-04 23:45
 **/
@Data
public class SingleLinkedList {
    /**
     * 链表头结点
     */
    private Node head=new Node(0,"");


    /**
     * 根据ID排序添加节点
     * @param newNode
     */
    public void addNode(Node newNode){
        //从头部遍历
        Node temp=head;
        //判断id是否已在链表中
        Boolean flag=false;
        //循环查找插入位置
        while (true){
            if(temp.nextNode==null){
                break;
            }else if(temp.nextNode.id.equals(newNode.id)){
                flag=true;
                break;
            }else if(temp.nextNode.id>newNode.id){
                break;
            }
            temp=temp.nextNode;
        }
        if(flag){
            return;
        }
        //找到位置插入
        newNode.nextNode=temp.nextNode;
        temp.nextNode=newNode;
    }


    /**
     * 根据节点ID删除
     * @param id
     */
    public void remove(Integer id){
        //从头部遍历
        Node temp=head;
        //节点是否存在
        Boolean flag=false;

        while (true){
            if(temp.nextNode==null){
                break;
            }else if(temp.nextNode.id.equals(id)){
                //找到需删除节点的上一节点
                flag=true;
                break;
            }
            temp=temp.nextNode;
        }
        //赋值
        temp.nextNode=temp.nextNode.nextNode;
        //被删除节点将被GC回收
    }

    /**
     * 打印节点
     */
    public void show(){
        //从头部遍历
        Node temp=head.nextNode;
        while (temp!=null){
            System.out.println("id: "+temp.getId()+",name: "+temp.getName());
            temp=temp.nextNode;
        }
    }


    public static void main(String[] args) {
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        Node node1=new Node(1,"小明");
        Node node3=new Node(8,"小白");
        Node node2=new Node(2,"小黑");
        singleLinkedList.addNode(node1);
        singleLinkedList.addNode(node3);
        singleLinkedList.addNode(node2);
        singleLinkedList.addNode(node1);


        Node node4=new Node(4,"小红");
        singleLinkedList.addNode(node4);
        singleLinkedList.show();

        singleLinkedList.remove(2);
        singleLinkedList.show();
    }

    /**
     * 节点
     */
    @Data
    private static class Node{
       //节点业务数据
       private Integer id;
       private String name;

       //指向下一节点
       private Node nextNode;

       //初始化构造器
        public Node(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
