package Offer.m29;

import java.util.Arrays;

/*面试题29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]*/
public class Solution1 {
    public static void main(String[] args) {
        int[][] matrix= {};
        Solution1 solution1 = new Solution1();
        int[] ans=solution1.spiralOrder(matrix);
        System.out.println(Arrays.toString(ans));
    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[0];
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int[] ans=new int[m*n];
        int index=0;
        int x=0;
        int y=0;
        boolean[][] isvisited=new boolean[m][n];
        ans[index]=matrix[x][y];
        isvisited[x][y]=true;
        index++;
        int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
        while(true){
            for (int i = 0; i < direction.length; i++) {
               while(true){
                   int newx=x+direction[i][0];
                   int newy=y+direction[i][1];
                   if(inArea(newx,newy,m,n)&&!isvisited[newx][newy]){
                       ans[index]=matrix[newx][newy];
                       index++;
                       x=newx;
                       y=newy;
                       isvisited[x][y]=true;
                   }else break;
                   if(index==m*n) break;
               }
                if(index==m*n) break;
            }
            if(index==m*n) break;
        }
        return ans;
    }
    public boolean inArea(int x,int y,int m,int n){
        return x>=0&&x<m&&y>=0&&y<n;
    }
}
