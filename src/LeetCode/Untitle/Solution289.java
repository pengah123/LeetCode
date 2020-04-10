package LeetCode.Untitle;

import java.util.Arrays;

/*����?�ٶȰٿ�?��������Ϸ�����Ϊ��������Ӣ����ѧ��Լ�����ζ١������� 1970 �귢����ϸ���Զ�����

����һ������ m �� n �����ӵ���壬ÿһ�����Ӷ����Կ�����һ��ϸ����ÿ��ϸ��������һ����ʼ״̬��1 ��Ϊ��ϸ����live������ 0 ��Ϊ��ϸ����dead����ÿ��ϸ������˸�����λ�ã�ˮƽ����ֱ���Խ��ߣ���ϸ������ѭ�����������涨�ɣ�

�����ϸ����Χ�˸�λ�õĻ�ϸ�����������������λ�û�ϸ��������
�����ϸ����Χ�˸�λ����������������ϸ�������λ�û�ϸ����Ȼ��
�����ϸ����Χ�˸�λ���г���������ϸ�������λ�û�ϸ��������
�����ϸ����Χ������������ϸ�������λ����ϸ�����
���ݵ�ǰ״̬��дһ���������������������ϸ������һ����һ�θ��º�ģ�״̬����һ��״̬��ͨ������������ͬʱӦ���ڵ�ǰ״̬�µ�ÿ��ϸ�����γɵģ�����ϸ���ĳ�����������ͬʱ�����ġ�*/
public class Solution289 {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Solution289 solu = new Solution289();
        solu.gameOfLife2(board);
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public void gameOfLife(int[][] board) {

        int[][] copy = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = change(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = copy[i][j];
            }
        }

    }

    public int change(int[][] board, int i, int j) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
        int count = 0;
        for (int x = 0; x < direction.length; x++) {
            int newi = i + direction[x][0];
            int newj = j + direction[x][1];
            if (inArea(board, newi, newj) && board[newi][newj] == 1) {
                count++;
            }

        }
        if (count == 3)
            return 1;
        if (count == 2)
            return board[i][j] == 1 ? 1 : 0;
        else return 0;
    }

    public boolean inArea(int[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
/*�ڶ��ַ�������������״̬*/
    public void gameOfLife2(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]=change2(board,i,j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==2)
                board[i][j]=1;
                else if(board[i][j]==-1)
                    board[i][j]=0;
            }
        }

    }
    public int change2(int[][] board, int i, int j) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
        int count = 0;
        for (int x = 0; x < direction.length; x++) {
            int newi = i + direction[x][0];
            int newj = j + direction[x][1];
            if (inArea(board, newi, newj) && (board[newi][newj] == 1||board[newi][newj] == -1)) {
                count++;
            }

        }
        if (board[i][j]==1&&(count>3||count<2))
            return -1;
        if(board[i][j]==0&&count==3)
            return 2;
        else return board[i][j];
    }
}
