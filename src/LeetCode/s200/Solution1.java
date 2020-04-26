package LeetCode.s200;

import java.util.LinkedList;
import java.util.Queue;

/*
* 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution.numIslands(grid2);
        System.out.println(numIslands2);
    }

    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isvisited = new boolean[m][n];
        Queue<int[]> que=new LinkedList<>();
        int[][] direction={{0,1},{1,0},{-1,0},{0,-1}};
        int num=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' &&!isvisited[i][j]){
                    que.offer(new int[]{i,j});
                    isvisited[i][j]=true;
                    while(!que.isEmpty()){
                        int[] poll = que.poll();
                        for (int[] ints : direction) {
                            int newi=poll[0]+ints[0];
                            int newj=poll[1]+ints[1];
                            if(inArea(m,n,newi,newj)&&!isvisited[newi][newj]&&grid[newi][newj]=='1'){
                                que.offer(new int[]{newi,newj});
                                isvisited[newi][newj]=true;
                            }
                        }
                    }
                   num++;
                }
            }
        }
        return num;
    }
    Boolean inArea(int m,int n, int i, int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }
}
