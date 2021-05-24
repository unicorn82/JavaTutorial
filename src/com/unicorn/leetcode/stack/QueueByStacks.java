package com.unicorn.leetcode.stack;

import java.util.Stack;



class MyQueue <T> {
    Stack<T> stack1;
    Stack<T> stack2;
    /** Initalize your data structure here.  **/
    public <T> MyQueue(){
        stack1 = new Stack();
        stack2 = new Stack();

    }

    /** Push element x to the back of queue **/
    public void push(T x){
        stack1.push(x);

    }

    /** Removes the element from in front of queue and returns that element **/
    public T pop(){
        T ele = peek();
        if (ele != null){
            return stack2.pop();
        }
        return ele;

    }

    /** Get the front element **/
    public T peek(){
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Return whether the queue is empty. **/
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }


}

public class QueueByStacks {

    public static void main(String[] args) {
        System.out.println("start");
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.push("first");
        myQueue.push("second");
        System.out.println(myQueue.peek());
        myQueue.push("third");
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }





}
