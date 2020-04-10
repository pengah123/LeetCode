package LeetCode.s151;

/*            151. 翻转字符串里的单词
            给定一个字符串，逐个翻转字符串中的每个单词。



            示例 1：

            输入: "the sky is blue"
            输出: "blue is sky the"*/
public class Solution2 {
    public static void main(String[] args) {
        String s = "the  sky is blue";
        Solution2 solu = new Solution2();
        s = solu.reverseWords(s);
        System.out.println(s);
    }

    public String reverseWords(String s) {
        /*递归算法
         *用空格将字符串分割成字符串数组
         * 反向输出数组
         * */
        String[] str = s.split(" ");
        StringBuilder result=new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if(!str[i].equals(""))
            {
                result.append(str[i]);
                result.append(' ');
            }

        }
        return result.toString().trim();
    }
}
