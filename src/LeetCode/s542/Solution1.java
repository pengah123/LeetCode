package LeetCode.s542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*[[0,1,0,1,1],[1,1,0,0,1],[0,0,0,1,0],[1,0,1,1,1],[1,0,0,0,1]]*/
public class Solution1 {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1,0,1,1}, {1,1,0,0,1}, {0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        Solution1 solu = new Solution1();
        int[][] ans = solu.updateMatrix(matrix);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Queue<int[]> que=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    que.offer(new int[]{i,j});
                }else matrix[i][j]=-1;
            }
        }
        int[][] move={{-1,0},{0,-1},{1,0},{0,1}};
        while (!que.isEmpty()){
            int[] cur=que.poll();
            for (int i = 0; i < move.length; i++) {
                int newi=cur[0]+move[i][0];
                int newj=cur[1]+move[i][1];
                if(inArea(m,n,newi,newj)&&matrix[newi][newj]==-1){
                    matrix[newi][newj]=matrix[cur[0]][cur[1]]+1;
                    que.offer(new int[]{newi,newj});
                }
            }
        }
        return matrix;
    }

    public boolean inArea(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
