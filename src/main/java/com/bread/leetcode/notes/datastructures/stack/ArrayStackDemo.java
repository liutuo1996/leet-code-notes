package com.bread.leetcode.notes.datastructures.stack;

/**
 * @program: leet-code-notes
 * @description: 数组实现栈
 * @author: LiuTuo
 * @create: 2021-07-13 21:36
 **/
public class ArrayStackDemo {
    //栈最大容量
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //表示栈顶
    private int top=-1;

    public ArrayStackDemo(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }

    /**
     * 判断栈是否已满
     * @return
     */
    public Boolean isFull(){
        return top>=maxSize-1;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public Boolean isEmpty(){
        return top<0;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value){
        if(isFull()){
            throw new RuntimeException("栈已满！");
        }

        top++;
        stack[top]=value;
    }

    /**
     * 出栈
     */
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈无数据！");
        }
        int result=stack[top];
        stack[top]=0;
        top--;
        return result;
    }

    /**
     * 打印栈
     */
    public void list(){
        for(int i=top;i>-1;i--){
            System.out.println(stack[i]);
        }
    }

    /**
     * 返回栈顶
     * @return
     */
    public int peek(){
        return stack[top];
    }
}
