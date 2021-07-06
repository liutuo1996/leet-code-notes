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
    private Node head = new Node(0, "");


    /**
     * 根据ID排序添加节点
     *
     * @param newNode
     */
    public void addNode(Node newNode) {
        //从头部遍历
        Node temp = head;
        //判断id是否已在链表中
        Boolean flag = false;
        //循环查找插入位置
        while (true) {
            if (temp.nextNode == null) {
                break;
            } else if (temp.nextNode.id.equals(newNode.id)) {
                flag = true;
                break;
            } else if (temp.nextNode.id > newNode.id) {
                break;
            }
            temp = temp.nextNode;
        }
        if (flag) {
            return;
        }
        //找到位置插入
        newNode.nextNode = temp.nextNode;
        temp.nextNode = newNode;
    }


    /**
     * 根据节点ID删除
     *
     * @param id
     */
    public void remove(Integer id) {
        //从头部遍历
        Node temp = head;
        //节点是否存在
        Boolean flag = false;

        while (true) {
            if (temp.nextNode == null) {
                break;
            } else if (temp.nextNode.id.equals(id)) {
                //找到需删除节点的上一节点
                flag = true;
                break;
            }
            temp = temp.nextNode;
        }
        //赋值
        temp.nextNode = temp.nextNode.nextNode;
        //被删除节点将被GC回收
    }

    /**
     * 打印节点
     */
    public void show() {
        //从头部遍历
        Node temp = head.nextNode;
        while (temp != null) {
            System.out.println("id: " + temp.getId() + ",name: " + temp.getName());
            temp = temp.nextNode;
        }
    }

    /**
     * 反转队列
     *
     * @param headNode
     */
    public void reverse(Node headNode) {
        //队列为空或者队列只有单个不需要反转
        if (headNode.nextNode == null || headNode.nextNode.nextNode == null) {
            return;
        }
        //获取第一个节点
        Node temp = headNode.nextNode;
        //下一节点
        Node next = null;
        //临时头部
        Node tempHead = new Node(0, "");
        while (temp != null) {
            next = temp.nextNode;
            temp.nextNode = tempHead.nextNode;
            tempHead.nextNode = temp;
            temp = next;
        }
        headNode.nextNode = tempHead.nextNode;
    }

    /**
     * 合并有序链表
     *
     * @param n1
     * @param n2
     * @return
     */
    public Node mergeList(Node n1, Node n2) {
        if (n1.nextNode == null) {
            return n2;
        }

        if (n2.nextNode == null) {
            return n1;
        }

        Node head = null;
        //头部节点为空，统一往下移动一位
        n1 = n1.nextNode;
        n2 = n2.nextNode;

        if (n1.id < n2.id) {
            head = n1;
            n1 = n1.nextNode;
        } else if (n1.id.equals(n2.id)) {
            head = n1;
            n1 = n1.nextNode;
            n2 = n2.nextNode;
        } else {
            head = n2;
            n2 = n2.nextNode;
        }
        Node temp=head;
        while (n1 != null && n2 != null) {
            if(n1.id<n2.id){
                temp.nextNode=n1;
                n1=n1.nextNode;
            }else if(n1.id.equals(n2.id)){
                temp.nextNode=n1;
                n1=n1.nextNode;
                n2=n2.nextNode;
            }else{
                temp.nextNode=n2;
                n2=n2.nextNode;
            }
            temp=temp.nextNode;
        }
        if(n1==null){
            if(temp.id.equals(n2.id)){
                n2=n2.nextNode;
            }
            temp.nextNode=n2;
        }

        if(n2==null){
            if(temp.id.equals(n1.id)){
                n1=n1.nextNode;
            }
            temp.nextNode=n1;
        }
        Node newHead=new Node(0,"");
        newHead.nextNode=head;
        return newHead;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(1, "小明");
        Node node3 = new Node(8, "小白");
        Node node2 = new Node(2, "小黑");
        singleLinkedList.addNode(node1);
        singleLinkedList.addNode(node3);
        singleLinkedList.addNode(node2);


        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        Node node4 = new Node(1, "小明");
        Node node5 = new Node(3, "小红");
        Node node6 = new Node(4, "小绿");
        singleLinkedList2.addNode(node4);
        singleLinkedList2.addNode(node5);
        singleLinkedList2.addNode(node6);

        Node node = singleLinkedList2.mergeList(singleLinkedList.getHead(), singleLinkedList2.getHead());
        //从头部遍历
        Node temp = node.nextNode;
        while (temp != null) {
            System.out.println("id: " + temp.getId() + ",name: " + temp.getName());
            temp = temp.nextNode;
        }
    }


    public static void main1(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(1, "小明");
        Node node3 = new Node(8, "小白");
        Node node2 = new Node(2, "小黑");
        singleLinkedList.addNode(node1);
        singleLinkedList.addNode(node3);
        singleLinkedList.addNode(node2);
        singleLinkedList.addNode(node1);


        Node node4 = new Node(4, "小红");
        singleLinkedList.addNode(node4);
        System.out.println("新增队列。。。");
        singleLinkedList.show();

        singleLinkedList.remove(2);
        System.out.println("删除队列队列。。。");
        singleLinkedList.show();

        System.out.println("反转队列。。。");
        singleLinkedList.reverse(singleLinkedList.getHead());
        singleLinkedList.show();
    }

    /**
     * 节点
     */
    @Data
    private static class Node {
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
