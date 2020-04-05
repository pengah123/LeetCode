package PengH.leetcode;

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
public class Solution200 {
    private boolean[][] marked;
    private int rows;
    private int cols;
    char[][] grid;
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Solution200 solution = new Solution200();
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
        rows = grid.length;
        cols = grid[0].length;
        marked = new boolean[rows][cols];
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j) {
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newi = i + direction[k][0];
            int newj = j + direction[k][1];
            if (inArea(newi, newj)&&grid[newi][newj] == '1' && !marked[newi][newj])
                dfs(newi,newj);
        }
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
