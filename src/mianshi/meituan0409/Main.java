package LeetCode.s111;

import java.util.Arrays;
import java.util.Scanner;
/*�����ƣ�C/C++���� 1000MS���������� 3000MS
�ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
��Ŀ������
��һ���ܾ���������ǣ���ǰʱ����aa:bb,�������ɷ��Ӻ���ʲôʱ�䣿���ǽ����������һ���෴�����⡣

��֪���ڵ�ʱ��������x��yy:zzʱ�̣�����n����ǰ���ܼ���ʱ���Ƕ��١�

����������������02:10,��200����֮ǰ��Ӧ�����ܶ���22:50��

����
�����������

��һ��һ��������x����ʾ��������x��(1<=x<=7)

�ڶ�����һ��24Сʱ�Ƶ�ʱ���ʾ��ʱ�ͷ־���ǰ��0�����磬1ʱ1�ֱ�ʾΪ01:01����֤ʱ���ʽ�ǺϷ��ġ�

��������һ��������n����ʾҪ�����n����֮ǰ��ʱ�䡣(1<=n<=10^9)

���
���ͬ���������У���һ�н�����һ������������ʾn����֮ǰ���ܼ���

һ��24Сʱ�Ƶ�ʱ���ʾ��ʱ�ͷ־���ǰ��0�����磬1ʱ1�ֱ�ʾΪ01:01����ʾn����֮ǰ��ʱ�̡�*/

public class Main {
    public static void main(String[] args) {
        scan();
    }

    public static void scan() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i > 7 || i < 1)
            return;
        String time = sc.nextLine();
//        if (!isvalid(time)) {
//            return;
//        }

        int n = sc.nextInt();

        int timeminutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        int x = timeminutes - n;
        while (x < 0) {
            x = 24 * 60 - Math.abs(x);
            i--;
            if (i == 0) {
                i += 7;
            }
        }
        int str1 = x / 60;
        int str2 = x % 60;
        StringBuilder sb = new StringBuilder();
        if (str1 < 10) {
            sb.append('0').append(str1);
        } else {
            sb.append(str1);
        }
        sb.append(':');
        if (str2 < 10) {
            sb.append('0').append(str2);
        } else {
            sb.append(str2);
        }
        System.out.println(i);
        System.out.println(sb.toString());
    }

    public static boolean isvalid(String time) {
//        if (time.length() != 5)
//            return false;
//        if (time.indexOf(2) != ':')
//            return false;
//        String str1 = time.substring(0, 2);
//        String str2 = time.substring(3, 5);
        return true;
    }
}
