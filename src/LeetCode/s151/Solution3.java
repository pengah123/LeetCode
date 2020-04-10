package LeetCode.s151;
/*双指针*/
public class Solution3 {
    public static void main(String[] args) {
        String s = "sky";
        Solution3 solu = new Solution3();
        s = solu.reverseWords(s);
        System.out.println(s);
        System.out.println(s.substring(0,3));
    }
    public String reverseWords(String s) {
        s=s.trim();
        int i=s.length()-1;
        int j=i;
        StringBuilder sub=new StringBuilder();
        while (i>=0){
            while (i>=0&&s.charAt(i)!=' '){
                i--;
            }
            sub.append(s.substring(i+1,j+1));
            sub.append(' ');
            while(i>=0&&s.charAt(i)==' '){
                i--;
            }
            j=i;
        }
        return sub.toString().trim();
    }
}


