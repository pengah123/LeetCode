package LeetCode.s3;

import java.util.LinkedList;
import java.util.Queue;

/*3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
public class solution1 {
    public static void main(String[] args) {
        String s="ababc";
        solution1 solution1 = new solution1();
        System.out.println(solution1.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        Queue<Character>  que=new LinkedList<>();
        char[] chars = s.toCharArray();
        int maxlen=0;
        int len=0;
        for (int i = 0; i < chars.length; i++) {
            if(!que.contains(chars[i])){
                que.offer(chars[i]);
                len++;
            }else {
                maxlen=Math.max(maxlen,len);
                while (true){
                    Character curr = que.poll();
                    len--;
                    if(curr==chars[i]){
                        break;
                    }
                }
                que.offer(chars[i]);
                len++;
            }
        }
        maxlen=Math.max(maxlen,len);
        return maxlen;
    }
}
