package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？

示例 1：
输入：m = 2, n = 3, k = 1
输出：3
示例 1：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
*/
public class Solutionm13 {
    /*广度优先遍历+队列*/
    public static void main(String[] args) {
        Solutionm13 solu = new Solutionm13();
        System.out.println(solu.moveCount2(3, 2, 17));
    }

    public int movingCount(int m, int n, int k) {
        int res = 1;
        //方向
        int[][] move = new int[][]{{1, 0}, {0, 1}};
        //是否访问过
        boolean[][] visited = new boolean[m][n];
        //队列
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i < move.length; i++) {
                int newx = currentPoint.x + move[i][0];
                int newy = currentPoint.y + move[i][1];
                if (check(newx, newy, m, n, k, visited)) {
                    queue.offer(new Point(newx, newy));
                    visited[newx][newy] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public boolean check(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && (getNumerical(x) + getNumerical(y)) <= k)
            return true;
        else return false;
    }

    public int getNumerical(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }
        return res;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

//深度优先遍历
    public int moveCount2(int m, int n, int k){

        boolean[][] visited=new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }
    public int dfs(int x, int y, int m, int n, int k, boolean[][] visited){
        if(x==m||y==n||getNumerical(x)+getNumerical(y)>k||visited[x][y])
            return 0;
        visited[x][y]=true;
        return 1+dfs(x+1,y,m,n,k,visited)+dfs(x,y+1,m,n,k,visited);
    }

}

