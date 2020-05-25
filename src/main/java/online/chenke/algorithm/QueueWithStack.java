package online.chenke.algorithm;

import java.util.Stack;

/**
 * 使用栈实现一个队列
 */
public class QueueWithStack<T> {
    public Stack<T> stackPush;
    public Stack<T> stackPop;

    QueueWithStack(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(T val){
        stackPush.push(val);
        pushToPop();
    }

    //把push栈里面的倒入pop栈里面
    public void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public T pop(){
        if(stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("stack is empty");
        }

        pushToPop();
        return stackPop.pop();
    }

    public static void main(String[] args) {
        QueueWithStack<Double> queue = new QueueWithStack<>();
        int queueLimit = 10;

        Double random;

        for (int i = 0; i < queueLimit; i++) {
            random = i*(Math.random()*10);
            queue.push(random);
            System.out.println(random);
        }

        System.out.println("=========");
        for (int i = 0; i < queueLimit; i++) {
            System.out.println(queue.pop());
        }
    }
}
