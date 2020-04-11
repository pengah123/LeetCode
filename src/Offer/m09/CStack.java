package Offer.m09;

import java.util.LinkedList;
import java.util.Queue;
/*两个队列实现一个栈*/
public class CStack {
    public Queue<Integer> que1;
    public Queue<Integer> que2;
    int size;
    public CStack(){
        que1=new LinkedList<>();
        que2=new LinkedList<>();
        size=0;
    }
    public void appendTail(int value) {

       que1.offer(value);
       size++;
    }

    public int deleteHead() {
        if(size==0){
            return -1;
        }
        for (int i = 1; i < size; i++) {
            que2.offer(que1.poll());
        }
        size--;
        int i=que1.poll();
        while(!que2.isEmpty()){
            que1.offer(que2.poll());
        }
        return i;
    }
}
