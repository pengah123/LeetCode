package Offer.m20;

/*请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是
*/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isNumber(".+e"));
    }

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        int i=0;
        int pointnum=0;
        int digitnum=0;
        if(s.charAt(i)=='+'||s.charAt(i)=='-'){
            i++;
        }
        while(i<s.length()&&(s.charAt(i)>='0'&&s.charAt(i)<='9'||s.charAt(i)=='.')){
            if(s.charAt(i)=='.'){
                pointnum++;
            }else{
                digitnum++;
            }
            i++;
        }
        if(pointnum>1||digitnum<1){
            return false;
        }
        if(i==s.length()){
            return true;
        }
        if(s.charAt(i)=='e'||s.charAt(i)=='E'){
            i++;
            if(i==s.length()){
                return false;
            }
            if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                i++;
                if(i==s.length()){
                    return false;
                }
            }
            while (i<s.length()&&(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                i++;
            }
            if(i==s.length()){
                return true;
            }
        }
        return false;
    }
}
