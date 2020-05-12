package Offer.m41;

import java.util.PriorityQueue;
import java.util.Queue;

/*如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例 1：

输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]
示例 2：

输入：
["MedianFinder","addNum","findMedian","addNum","findMedian"]
[[],[2],[],[3],[]]
输出：[null,null,2.00000,null,2.50000]
*/
public class MedianFinder {
    private Queue<Integer> small = new PriorityQueue<>((v1, v2) -> v2 - v1);//存放小的数，大根堆
    private Queue<Integer> big = new PriorityQueue<>();//存放大的数，小根堆
    private int len = 0;
    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (len%2==0){
//            插入次数为偶数
            big.offer(num);
            small.offer(big.poll());
        }else {
//            插入次数为奇数
            small.offer(num);
            big.offer(small.poll());
        }
        len++;
    }

    public double findMedian() {
        if(len%2==0){
            return (double)(small.peek()+big.peek())/2;
        }else{
            if(small.size()>big.size()){
                return small.peek();
            }
            else {
                return big.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
