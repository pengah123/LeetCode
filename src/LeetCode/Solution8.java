package LeetCode;

/*
������ʵ��һ�� atoi ������ʹ���ܽ��ַ���ת����������

���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ����������ת���������£�

�����һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ�����������ַ�����������γ�һ���з���������
�����һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�һ��������
���ַ�������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����ô��Щ�ַ����Ա����ԣ����ǶԺ�����Ӧ�����Ӱ�졣
ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת�������޷�������Чת����

���κ�����£����������ܽ�����Ч��ת��ʱ���뷵�� 0 ��

��ʾ��

�����еĿհ��ַ�ֻ�����ո��ַ� ' ' ��
�������ǵĻ���ֻ�ܴ洢 32 λ��С���з�����������ô����ֵ��ΧΪ [?231,  231 ? 1]�������ֵ���������Χ���뷵��  INT_MAX (231 ? 1) �� INT_MIN (?231) ��
 */
public class Solution8 {

    public static void main(String[] args) {
    }

    public int myAtoi(String str) {
        int space = 0;
        while (space < str.length() && str.charAt(space) == ' ') {
            space++;
        }
        if (space == str.length()) {
            return 0;
        }
        boolean nega=false;
        if(str.charAt(space) == '-' ){
            nega=true;
            space++;
        }
        else if(str.charAt(space) == '+' ){
            space++;
        }
        int result=0;
        while(space < str.length()&&Character.isDigit(str.charAt(space))){
            char c=str.charAt(space);
            int index=c-'0';
            if(result>(Integer.MAX_VALUE-index)/10)
                return nega? Integer.MIN_VALUE:Integer.MAX_VALUE;
            result=result*10+index;
            space++;
        }
        return nega? -result:result;
    }
}
