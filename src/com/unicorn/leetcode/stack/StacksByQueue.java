package com.unicorn.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack <T>{

    private Queue<T> queue1;
    private Queue<T> queue2;

    public MyStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(T x){

        Queue<T> emptyQueye = queue1.isEmpty()? queue1: queue2;
        Queue<T> queue = queue1.isEmpty()? queue2: queue1;
        emptyQueye.add(x);
        while( !queue.isEmpty()){
            emptyQueye.add(queue.poll());
        }


    }

    public T peek(){
        Queue<T> queue = queue1.isEmpty()? queue2: queue1;
        return queue.peek();
    }

    public T pop(){
        Queue<T> queue = queue1.isEmpty()? queue2: queue1;
        return queue.poll();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }


}

public class StacksByQueue {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("first");
        stack.push("second");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("third");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }

}
