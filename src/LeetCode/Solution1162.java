package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//用indexOf将两个坐标转换为一个数字存储的方式十分巧妙
//队列还没有学到，用起来很方便

public class Solution1162 {
    public static void main(String[] args) {
        // int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Solution1162 solution=new Solution1162();
        int ans=solution.maxDistance(grid);
        System.out.println(ans);
    }

    public int maxDistance(int[][] grid) {
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int N = grid.length;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    que.add(index(i, j, N));
                }
            }
        }
        if(que.size()==0||que.size()==N*N)
            return -1;

        int step=0;
        while(!que.isEmpty()) {
            int cur=que.size();
            for (int i = 0; i < cur; i++) {
                int integer = que.poll();
                int curx = integer / N;
                int cury = integer % N;

                for (int[] ints : direction) {
                    int newx = curx + ints[0];
                    int newy = cury + ints[1];

                    if (inArea(newx, newy, N) && grid[newx][newy] == 0) {
                        grid[newx][newy]=1;
                        que.add(index(newx, newy, N));
                    }
                }
            }
            step++;
        }
        return step-1;
    }

    public int index(int x, int y, int N) {
        return x * N + y;
    }

    public boolean inArea(int x, int y, int N) {
        if (0<=x && x < N && 0<=y && y < N)
            return true;
        else return false;
    }
}
