package TenCent0426;

import java.util.Scanner;
/*计算树的第i层深度的父节点的编号，通过率50%*/
public class Main5 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m=sc.nextInt();
            int x=sc.nextInt();
            if(m<=0||x<=0){
                System.out.println(-1);
                continue;
            }
            int height=1;
            int index=m;
            while(index>1){
                index/=2;
                height++;
            }
            if(x>=height){
                System.out.println(-1);
                continue;
            }
            index=m;
            while (x!=height){
                index/=2;
                height--;
            }
            System.out.println(index);
        }
    }
}
