package LeetCode.m07;

/*给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？*/
public class Solution {
    /*分析：
     * 分为顺时针换和逆时针换两种情况
     * 顺时针就是：(x,y)-(y,len-1-x),逆时针换一次就将值+16
     * 逆时针就是：(x,y)-(len-1-y,x)，顺时针换一次将值-16
     * 判断：
     *   值/16==1，位置合适
     *   值/16>1,逆时针转动，每转动一次，值-16，直到值/16==1，换位置
     *   值/16<1,顺时针转动，没转动一次，值+16，直到值/16==1,换位置*/
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int newi = i;
                int newj = j;
                int direction = 0;//记录转动的方向，顺时针为-1，逆时针为1
                int num = 0;//记录转动的次数
                while (matrix[i][j] / 16 != 1) {
                    if (matrix[i][j] / 16 > 1) {
                        direction = 1;
                        newi = len - 1 - j;
                        newj = i;
                        matrix[i][j] -= 16;
                        num++;
                    } else {
                        direction = -1;
                        newi = j;
                        newj = len - 1 - i;
                        matrix[i][j] += 16;
                        num++;
                    }
                }
//                如果发生了转动，则交换
                if (num != 0 && matrix[newi][newj] != matrix[i][j]) {
                    matrix[newi][newj] = matrix[newi][newj] + direction * num * 16;
                    int temp = matrix[newi][newj];
                    matrix[newi][newj] = matrix[i][j];
                    matrix[i][j] = temp;
                }

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                    while(matrix[i][j]<0){
                        matrix[i][j] += 16;
                    }
                    while (matrix[i][j]>16){
                        matrix[i][j] -= 16;
                    }
            }
        }
    }
}
