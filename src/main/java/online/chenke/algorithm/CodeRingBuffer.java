package online.chenke.algorithm;

/**
 * ringbuffer
 */
public class CodeRingBuffer {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.push(4);
        myQueue.push(5);
        myQueue.push(6);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.pop());
    }

    static class MyQueue{
        public int limit;
        public int size = 0;
        public int[] valArr;
        public int pushIndex=0;
        public int popIndex=0;

        MyQueue(int limit){
            valArr = new int[limit];
            this.limit = limit;
        }

        public void push(int val){
            if(size==limit){
                throw new RuntimeException("满了");
            }

            size++;
            valArr[pushIndex] = val;
            pushIndex = nextIndex(pushIndex);
        }

        public int pop(){
            if(size==0){
                throw new RuntimeException("空了");
            }

            int val = valArr[popIndex];
            size--;

            popIndex = nextIndex(popIndex);
            return val;
        }

        private int nextIndex(int index){
            return index<limit-1?index+1:0;
        }
    }
}
