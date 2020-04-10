package Offer.m04;

/*在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。
*/
public class m04 {
    public static void main(String[] args) {
        m04 m = new m04();
        int[][] maxtrix = {{},{}};
        boolean b = m.findNumberIn2DArray(maxtrix, 3);
        System.out.println(b);
    }

    /*分析，从右上角开始，
     * 1。等于则输出
     * 2.小于target去除行
     * 3.大于target去除列*/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null||matrix.length==0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col])
                return true;
            if (target > matrix[row][col])
                row++;
            else col--;
        }
        return false;
    }
}
