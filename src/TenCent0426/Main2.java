package TenCent0426;

import java.util.Scanner;
/*计算最短距离，未通过*/
public class Main2 {
        static class Point{
            int x;
            int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int m=sc.nextInt();

            int n=sc.nextInt();
            Point[] A=new Point[n*2];
            for (int j = 0; j < n*2; j++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                A[j]=new Point(x,y);
            }

            n=sc.nextInt();
            Point[] B=new Point[n*2];
            for (int j = 0; j < n*2; j++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                B[j]=new Point(x,y);
            }

            double min=Double.MAX_VALUE;
            double max=0;
            for (int i = 0; i < A.length; i++) {
                System.out.println(A[i].x);
                System.out.println(A[i].y);
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    double curr=juli(A[i],B[j]);
                    min=Math.min(min,curr);
                    max=Math.max(max,curr);
                }
            }
            min=(double)Math.round(min*1000)/1000;
            max=(double)Math.round(max*1000)/1000;
            System.out.println(max);
            System.out.println(min);
        }
        public static double juli(Point A,Point B){
            return Math.sqrt((A.x-B.x)*(A.x-B.x)+(A.y-B.y)*(A.y-B.y));
        }

}
