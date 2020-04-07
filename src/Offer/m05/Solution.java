package Offer.m05;

import java.util.Arrays;

/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."*/
public class Solution {
    /*    分析
    1.遍历一遍字符串，统计空格个数
    2.新建一个长度为原长度+空格数*2 的数组
    3.i指向s=尾部，j指向s2尾部
    4.将i所指向的元素放在s2中
    5.直到i=j=0结束
        */
    public static void main(String[] args) {
        Solution solu = new Solution();
        String s=solu.replaceSpace("    ");
        System.out.println(s);
    }
    public String replaceSpace(String s) {
        if(s==null)
            return null;
        char[] c1 = s.toCharArray();
        int space = 0;
        for (char c : c1) {
            if (c == ' ')
                space++;
        }
        if(space==0){
            return s;
        }
        char[] c2 = new char[c1.length + space * 2];
        for (int i = c1.length - 1,j = c2.length - 1;i >= 0&&j>=0;i--,j--){
            if (c1[i] == ' ') {
                c2[j--] = '0';
                c2[j--] = '2';
                c2[j] = '%';

            } else {
                c2[j] = c1[i];
            }
        }
        return new String(c2);

    }
}
