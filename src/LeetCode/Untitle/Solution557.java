package LeetCode.Untitle;
/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

        示例 1:

        输入: "Let's take LeetCode contest"
        输出: "s'teL ekat edoCteeL tsetnoc" 
        注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
*/

import java.util.Arrays;

public class Solution557 {
    public static void main(String[] args) {
        String str="how do you do";
        System.out.println(reverseWords(str));
    }
    public static String reverseWords(String s) {
       if(s==null){
        return s;
    }
        else {
        String[] str = s.split(" ");
        String result = "";
        for (int i = 0; i < str.length - 1; i++) {
            result+=reverse(str[i]) + " ";
        }
        result+=reverse(str[str.length - 1]);
        return result;
    }
}
    public static String reverse(String str){
        char[] chars=str.toCharArray();
        int left=0;
        int right=chars.length-1;
        char temp;
        while(right>left){
            temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        String str2=String.copyValueOf(chars);
        return str2;
    }
    //别的解法

        public String reverseWords2(String s) {
            String words[] = s.split(" ");
            StringBuilder res = new StringBuilder();
            for (String word : words)
                res.append(new StringBuffer(word).reverse().toString() + " ");
            return res.toString().trim();
        }
}
