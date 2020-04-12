package LeetCode.s1476;

import java.util.Arrays;

public class Solution {
    /*三种情况
     * 1.斜率不存在，就是平行于x轴
     * 2.斜率相等
     * 3.普通情况*/
    /*步骤：
     * 1.将点封装为point类
     * 2.将线段封装为Line类
     * 3.计算斜率，特殊情况讨论
     * 4.判断交点是否在坐标范围内*/
    public static void main(String[] args) {
        int[] start1 = new int[]{-1, 1};
        int[] end1 = new int[]{1, 1};

        int[] start2 = new int[]{1, 0};
        int[] end2 = new int[]{-3, 2};

        Solution solution = new Solution();
        double[] res = solution.intersection(start1, end1, start2, end2);
        System.out.println(Arrays.toString(res));
    }
    public class Point {
        private double x;
        private double y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Line {
        private double k;
        private double b;

        public Line(Point start, Point end) {
            Double deltaY = end.y - start.y;
            Double deltaX = end.x - start.x;

            if (deltaX == 0) {
                k = Integer.MAX_VALUE;
                b = end.x;
            } else {
                k = deltaY / deltaX;
                b = end.y - k * end.x;
            }
        }
    }

    public double[] intersection(int[] start1_, int[] end1_, int[] start2_, int[] end2_) {
        Point[] points = checkAndConvertintoPoint(start1_, end1_, start2_, end2_);
        Point start1 = points[0];
        Point end1 = points[1];
        Point start2 = points[2];
        Point end2 = points[3];

        //封装成直线
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        //误差精确度
        double epslion = 1e-6f;

        //交点
        Point intersection;

        //特殊情况，当有一条直线斜率不存在
        if (line1.k == Integer.MAX_VALUE || line2.k == Integer.MAX_VALUE) {
            //如果两条直线斜率都不存在，且截距相同，切包含，则存在交点为第二条直线的起点
            if (line1.k == Integer.MAX_VALUE && line2.k == Integer.MAX_VALUE) {
                if (Math.abs(line1.b - line2.b) <= epslion && isBetween(start1, start2, end1)) {
                    return new double[]{start2.x, start2.y};
                } else  if (Math.abs(line1.b - line2.b) <= epslion && isBetween(start1, end2, end1)){
                    return new double[]{start1.x, start1.y};
                }else{
                    return new double[0];
                }
            }

            if (line1.k == Integer.MAX_VALUE) {
                intersection = new Point(line1.b, line1.b * line2.k + line2.b);
            } else {
                intersection = new Point(line2.b, line2.b * line1.k + line1.b);
            }
        } else if (Math.abs(line1.k - line2.k) <= epslion) {
//如果斜率相同，若截距相同且包含，则交点为start2的起点，否则交点不存在
            if(Math.abs(line1.b-line2.b)<=epslion&&isBetween(start1,start2,end1)){
                return new double[]{start2.x,start2.y};
            }
            return new double[0];
        }else{
//            若斜率不同,直接算交点
            double x=(line2.b-line1.b)/(line1.k-line2.k);
             double y=x*line1.k+line1.b;
             intersection =new Point(x,y);
        }
        //看算出来的交点是否包含
        if(isBetween(start1,intersection,end1)&&isBetween(start2,intersection,end2)){
            return new double[]{intersection.x,intersection.y};
        }
        else return new double[0];
    }

    public Point[] checkAndConvertintoPoint(int[] start1_, int[] end1_, int[] start2_, int[] end2_) {

        Point start1 = new Point(start1_[0], start1_[1]);
        Point end1 = new Point(end1_[0], end1_[1]);
        Point start2 = new Point(start2_[0], start2_[1]);
        Point end2 = new Point(end2_[0], end2_[1]);
        //保证开始坐标的横坐标小于结束坐标的横坐标
        if (start1.x > end1.x) {
            swap(start1, end1);
        }
        if (start2.x > end2.x) {
            swap(start2, end2);
        }
        //保证第一条线段的横坐标小于第二条线段的横坐标
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }
        return new Point[]{start1, end1, start2, end2};
    }

    public void swap(Point point1, Point point2) {
        double tempx = point1.x;
        double tempy = point1.y;

        point1.x = point2.x;
        point1.y = point2.y;

        point2.x = tempx;
        point2.y = tempy;
    }

    public Boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;
        }
    }

    public Boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }
}
