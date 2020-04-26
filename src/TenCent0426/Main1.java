package TenCent0426;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*实现一个队列的操作，未通过*/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();//表示有几组数据
        int x;
        for (int i = 0; i < n; i++) {
            int m=sc.nextInt();//表示这组数据有几次操作
            Queue<Integer> que=new LinkedList<>();
            for (int j = 0; j < m+1; j++) {
                String s=sc.next();
                s=s.toUpperCase();
                if(s.contains("PUSH")){
                    x=sc.nextInt();
                    que.offer(x);
                    continue;
                }
                if(s.contains("TOP")){
                    if(!que.isEmpty()){
                        System.out.println(que.peek());
                    }
                    else{
                        System.out.println(-1);
                    }
                    continue;
                }
                if(s.contains("POP")){
                    if(!que.isEmpty()){
                        que.poll();
                    }
                    else{
                        System.out.println(-1);
                    }
                    continue;
                }
                if(s.contains("SIZE")){
                    System.out.println(que.size());
                    continue;
                }
                if(s.contains("CLEAR")){
                    que.clear();
                    continue;
                }
            }
        }
    }
}
