package LeetCode;

import java.util.ArrayList;

/*
*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
* */
//还有一种判断翻转后的对应字符串是否就是回文字符串的方法没有看
public class Solution5 {
    public static void main(String[] args) {
        String s="aacdefcaa";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        int maxlen=0;
        int maxend=0;
        int len=s.length();
        String reverse=new StringBuilder(s).reverse().toString();
        int[][] a=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(s.charAt(i)==reverse.charAt(j)){
                    if(i==0||j==0)
                        a[i][j]=1;
                    else a[i][j]=a[i-1][j-1]+1;
                }
                if(a[i][j]>maxlen){
                    maxlen=a[i][j];
                    maxend=i;
                }
            }
        }
        return s.substring(maxend-maxlen+1,maxend+1);
    }
}
