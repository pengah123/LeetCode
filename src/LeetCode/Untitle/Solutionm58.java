package LeetCode.Untitle;

/*�ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
*/
public class Solutionm58 {
    public static void main(String[] args) {
        String s="abcdefg";
        Solutionm58 solu = new Solutionm58();
        System.out.println(solu.reverseLeftWords(s,2));
    }
    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()).concat(s.substring(0,n));

    }
}
