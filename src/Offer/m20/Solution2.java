package Offer.m20;

/*请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是
*/
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.isNumber(".+e"));
    }

    public static boolean isNumber(String s) {
        // 数据初始化去除首位空字符
        s = s.trim();
        if(s.length() == 0) {
            return false;
        }
        int i = 0;
        // 符号部分处理
        if(s.charAt(i) == '-' || s.charAt(i) == '+') {
            i++;
        }
        int pointNum = 0;
        int digitalNum = 0;
        // 小数部分处理（包含小数点与正整数）
        while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '.')) {
            if(s.charAt(i) == '.') {
                pointNum++;
            }else {
                digitalNum++;
            }
            i++;
        }
        if(pointNum > 1 || digitalNum < 1) {
            return false;
        }
        // 如果没有指数e部分就返回true
        if(i == s.length()) {
            return true;
        }
        // 如果字符串还没到尾，说明可能存在指数部分 e
        if(s.charAt(i) == 'e') {
            i++;
            // 如果指数字母e后面啥都没有了，则false
            if(i == s.length()) {
                return false;
            }
            // e的幂可能会有符号
            if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                i++;
                // 如果符号后面啥都没有到尾了，false，因为必须跟数字的
                if(i == s.length()) {
                    return false;
                }
            }
            // 处理幂的数字部分
            while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                i++;
            }
            // 如果数字部分结束就到尾了，返回true
            if(i == s.length()) {
                return true;
            }
        }
        // 其他杂七杂八的情况都false，如有其他特殊字符abcd之类的
        return false;
    }
}
