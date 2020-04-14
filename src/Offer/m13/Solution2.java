package Offer.m13;
/*
深度优先遍历
*/
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.movingCount(1,2,1));
    }
    public int movingCount(int m, int n, int k){
        boolean[][] visted=new boolean[m][n];
        return dfs(m,n,k,0,0,visted);
    }
    public int dfs(int m,int n, int k, int x, int y, boolean[][] visited){
        int sum=0;
        if(inArea(m,n,x,y)&&issamller(x,y,k)&&!visited[x][y]){
            visited[x][y]=true;
            sum=1+dfs(m,n,k,x+1,y,visited)+dfs(m,n,k,x,y+1,visited);
        }
        return sum;
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
