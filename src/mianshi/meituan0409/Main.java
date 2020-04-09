package LeetCode.s111;

import java.util.Arrays;
import java.util.Scanner;
/*间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
有一个很经典的问题是，当前时间是aa:bb,请问若干分钟后是什么时间？我们今天的问题是一个相反的问题。

已知现在的时刻是星期x的yy:zz时刻，请问n分钟前是周几，时间是多少。

例如现在是周三，02:10,则200分钟之前，应该是周二，22:50。

输入
输入包含三行

第一行一个正整数x，表示今天是周x。(1<=x<=7)

第二行是一个24小时制的时间表示，时和分均含前导0，例如，1时1分表示为01:01。保证时间格式是合法的。

第三行是一个正整数n，表示要求的是n分钟之前的时间。(1<=n<=10^9)

输出
输出同样包含两行，第一行仅包含一个正整数，表示n分钟之前是周几。

一个24小时制的时间表示，时和分均含前导0，例如，1时1分表示为01:01。表示n分钟之前的时刻。*/

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
