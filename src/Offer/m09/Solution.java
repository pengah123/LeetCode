package Offer.m09;

public class Solution {
    public static void main(String[] args) {
        CStack cQueue = new CStack();
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        cQueue.appendTail(5);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(6);
        System.out.println(cQueue.deleteHead());
    }
}
