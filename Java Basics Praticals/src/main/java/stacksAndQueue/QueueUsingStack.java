package stacksAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingStack {
    /*
    https://leetcode.com/problems/implement-queue-using-stacks/description/
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(5);
        myQueue.push(6);
        System.out.println("pop :"+myQueue.pop());
    }


}
class MyQueue {

    public MyQueue() {

    }
    Stack<Integer> read = new Stack<>();
    Stack<Integer> write = new Stack<>();

    public void push(int x) {
        write.push(x);
    }

    public int pop() {
        if(this.empty()) return -1;
        if(read.isEmpty()){
            transfer(read,write);
        }
        return read.pop();
    }

    void transfer (Stack<Integer> read, Stack<Integer> write){
        while(!write.isEmpty()){
            read.push(write.pop());
        }
    }
    public int peek() {
        if(this.empty()) return -1;
        if(read.isEmpty()){
            transfer(read,write);
        }
        return read.peek();
    }

    public boolean empty() {
        if(read.isEmpty() && write.isEmpty()) return true;
        return false;
    }

}
class MyStack {

    Queue<Integer> read = new LinkedList<>();
    Queue<Integer> write = new LinkedList<>();

    public void push(int x) {
        write.offer(x);
    }

    public int pop() {
        if(this.empty()) return -1;
        if(read.isEmpty()){
            transfer(read,write);
        }
        return read.poll();
    }

    void transfer (Queue<Integer> read, Queue<Integer> write){
        while(!write.isEmpty()){
            read.offer(write.poll());
        }
    }

    public boolean empty() {
        if(read.isEmpty() && write.isEmpty()) return true;
        return false;
    }

    public MyStack() {

    }

    public int top() {
        if(this.empty()) return -1;
        if(read.isEmpty()){
            transfer(read,write);
        }
        return read.peek();
    }

}
