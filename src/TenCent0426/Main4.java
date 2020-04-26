package TenCent0426;

import java.util.Scanner;
import java.util.Stack;
/*两个栈实现一个队列，通过率75%*/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        int size=0;
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s=sc.next();
            if(s.contains("add")){
                int x=sc.nextInt();
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                stack1.push(x);
                while(!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
                size++;
            }
            if(s.contains("poll")){
                if(size==0){
                    continue;
                }
                size--;
                stack1.pop();
            }
            if(s.contains("peek")){
                if(stack1.isEmpty()){
                    continue;
                }
                System.out.println(stack1.peek());
            }
        }

    }
}
