package Offer.m38;

import java.util.*;

/*
* 输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
*/
public class Solution1 {
    public static void main(String[] args) {
        String s="aab";
        Solution1 solution1 = new Solution1();
        String[] permutation = solution1.permutation(s);
        for (String s1 : permutation) {
            System.out.println(s1);
        }
    }
    public String[] permutation(String s) {
        if(s==null||s.length()==0){
            return new String[]{};
        }
        if(s.length()==1){
            return new String[]{s};
        }
        Set<String> list=new HashSet<>();
        for(int i=0;i<s.length();i++){
            StringBuilder dfs=new StringBuilder(s.substring(0,i));
            dfs.append(s.substring(i+1,s.length()));
            String[] strings = permutation(dfs.toString());
            for (String string : strings) {
                StringBuilder sb=new StringBuilder(s.substring(i,i+1));
                sb.append(string);
                if(!list.contains(sb.toString())){
                    list.add(sb.toString());

                }
            }
        }
        String[] result=new String[list.size()];
        int i=0;
        for (String s1 : list) {
            result[i++]=s1;
        }
        return result;
    }
}
