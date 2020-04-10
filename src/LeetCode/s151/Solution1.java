package LeetCode.s151;

/*            151. 翻转字符串里的单词
            给定一个字符串，逐个翻转字符串中的每个单词。



            示例 1：

            输入: "the sky is blue"
            输出: "blue is sky the"*/
public class Solution1 {
    public static void main(String[] args) {
        String s="the sky is blue";
        Solution1 solu = new Solution1();
        s=solu.reverseWords(s);
        System.out.println(s);
    }

    public String reverseWords(String s) {
        /*递归算法
         * 遇到第一个空格，将字符串分为两部分，去除两边空格
         * 先反转后面的，再把前面的加到后面
         * */
        s=s.trim();
        int i = s.indexOf(' ');
        if (i == -1) {
            return s;
        }
        String str1=s.substring(0,i);
        String str2=s.substring(i+1);
        StringBuilder str3=new StringBuilder();
        str3.append(reverseWords(str2)).append(' ').append(str1);
        return str3.toString();
    }
}
