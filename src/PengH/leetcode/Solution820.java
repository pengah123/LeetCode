package PengH.leetcode;

import java.util.*;

/*输入: words = ["time", "me", "bell"]
输出: 10
说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
*/
//解题思路：删除是别的字符串后缀的字符串
class Solution820 {
    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"me", "time", "bell"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        Set<String> result=new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for(int i=1;i<word.length();i++)
                result.remove(word.substring(i));
        }
        int ans=0;
        for (String s : result) {
           ans+=s.length()+1;
        }
        return ans;
    }
}
