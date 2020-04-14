package Offer.m13;
/*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？
*/
import java.util.LinkedList;
import java.util.Queue;
/*广度优先遍历*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.movingCount(1,2,1));
    }
    class Point{
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int movingCount(int m, int n, int k){
        if(k<0||m==0||n==0){
            return 0;
        }
        int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Point> que=new LinkedList<>();
        que.offer(new Point(0,0));
        boolean[][] visited=new boolean[m][n];
        int ans=1;
        while(!que.isEmpty()){
            Point curr = que.poll();
            visited[curr.i][curr.j]=true;
            for(int i = 0; i < direction.length; i++) {
                int newi=curr.i+direction[i][0];
                int newj=curr.j+direction[i][1];
                if(inArea(m,n,newi,newj)&&issamller(newi,newj,k)&!visited[newi][newj]){
                    que.offer(new Point(newi,newj));
                    ans++;
                }
            }

        }
        return ans;
    }
    boolean inArea(int m,int n,int i,int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }
    boolean issamller(int i,int j, int k){
        int sum=0;
        while (i>0||j>0){
            sum+=i%10;
            sum+=j%10;
            i/=10;
            j/=10;
        }
        return sum<=k;
    }
}
