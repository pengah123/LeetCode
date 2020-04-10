package LeetCode.Untitle;
/*�� 1+2+...+n ��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
* */
public class Solutionm64 {
    public static void main(String[] args) {
        Solutionm64 solut = new Solutionm64();
        System.out.println(solut.sumNums(3));
    }
    public int sumNums(int n) {
        int sum=n;
        boolean b=n>0&&(sum+=sumNums(n-1))>0;
        return sum;

    }
}
