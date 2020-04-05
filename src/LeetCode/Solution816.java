package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
* 示例 1:
输入: "(123)"
输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
示例 2:
输入: "(00011)"
输出:  ["(0.001, 1)", "(0, 0.011)"]
解释:
0.0, 00, 0001 或 00.01 是不被允许的。
示例 3:
输入: "(0123)"
输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
示例 4:
输入: "(100)"
输出: [(10, 0)]
解释:
1.0 是不被允许的。
*/
public class Solution816 {
    public static void main(String[] args) {
        System.out.println(ambiguousCoordinates("(0123)"));
    }
        public static List<String> ambiguousCoordinates(String S) {
            List<String> result = new ArrayList<>();
            for (int i = 2; i < S.length()-1; i++) {
                List<String> right = make(S.substring(1, i));
                List<String> left = make(S.substring(i,S.length()-1));
                for (String r : right) {
                    for (String l : left) {
                        result.add("("+r + ", " + l+")");
                    }
                }
            }
            return result;
        }

        public static List<String> make(String s) {
            List<String> result = new ArrayList<>();
            for (int i = 1; i < s.length(); i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
                    result.add(left + "." + right);
                }
            }
            if(!s.startsWith("0")||s.equals("0"))
                result.add(s);
            return result;
        }
    }
