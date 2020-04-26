package LeetCode.s466;

import java.util.HashMap;
import java.util.Map;

/*由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。

如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。

现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。

请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
*/
/*couts2 += circle2*((n1-couts1)/circle1);
couts1 = couts1+((n1-couts1)/circle1)*circle1;//更新新他们
解释一下这两行代码什么意思：
我们进入这个代码快的前提是出现循环，
也就是说这一次扫描s1结束的时候，p的位置，也就是S2的位置和之前一次相同，现在我们算差值：
int circle1= couts1-last[0];表示两次位置经历的多少s1
int circle2= couts2-last[1];表示两次位置经历的多少s2
假如经历过三个s1和两个s2，那么可以表示：
三个s1可以换两个s2，这就是一个循环
也就是：
circle1=3
circle2=2
所以(n1-couts1)/circle1表示剩下的还有几个循环
((n1-couts1)/circle1)circle1表示 循环的个数每个循环有多少s2
couts1 = couts1+((n1-couts1)/circle1)circle1;表示很显然，加起来之前走过的s2
couts2 += circle2((n1-couts1)/circle1);表示加所有循环经历的s1
*/
/*输入：
        s1 ="acb",n1 = 4
        s2 ="ab",n2 = 2

        返回：
        2*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solu1 = new Solution1();
        System.out.println(solu1.getMaxRepetitions("acb",4,"ab",2));
    }
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int count1 = 0;
        int count2 = 0;
        int p = 0;
        Map<Integer, int[]> map = new HashMap<>();

        while (n1 > count1) {
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] == chars2[p]) {
                    p++;
                    if (p == chars2.length) {
                        p = 0;
                        count2++;
                    }
                }

            }
            count1++;
            if (!map.containsKey(p)) {
                map.put(p, new int[]{count1, count2});
            } else {
                int[] last = map.get(p);
                int circle1 = count1 - last[0];
                int circle2 = count2 - last[1];
                count2 = count2 + circle2 * (n1 - count1) / circle1;
                count1 = count1 + ((n1 - count1) / circle1) * circle1;
            }

        }
        return count2 / n2;
    }
}
