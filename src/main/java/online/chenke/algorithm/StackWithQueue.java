package online.chenke.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现一个栈
 */
public class StackWithQueue<T> {
    public Queue<T> queue;
    public Queue<T> assistQueue;

    StackWithQueue(){
        queue = new LinkedList<>();
        assistQueue = new LinkedList<>();
    }

    public void push(T val){
        queue.add(val);
    }

    public T pop(){
        while (queue.size()>1){
            assistQueue.add(queue.poll());
        }

        T finalVal = queue.poll();
        Queue<T> tmp = queue;
        queue = assistQueue;
        assistQueue = tmp;

        return finalVal;
    }

    public static void main(String[] args) {
        StackWithQueue<Double> stack = new StackWithQueue();
        int stackLimit = 10;

        Double random;

        for (int i = 0; i < stackLimit; i++) {
            random = i*(Math.random()*10);
            stack.push(random);
            System.out.println(random);
        }

        System.out.println("=========");
        for (int i = 0; i < stackLimit; i++) {
            System.out.println(stack.pop());
        }

    }
}
