package Offer.m41;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test(){
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        mf.addNum(4);
        double median = mf.findMedian();
        System.out.println(median);
    }
}
