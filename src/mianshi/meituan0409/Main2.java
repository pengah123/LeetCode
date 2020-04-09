package mianshi.meituan0409;

import java.util.Scanner;
/*时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
“我将带头冲锋。”每一个军人如是说。

某部队举办了一届军事运动会，其中有一个团体马拉松项目，有n名选手按顺序从起跑线出发，并且记录下他们到达终点的顺序。在跑步过程中超越了其他人的选手要给予表彰。

受表彰的选手需要满足的条件是，如果存在一名出发顺序排在选手X之后的选手Y先于X到达终点，则认为Y超越了X。

对于每一个选手，只要他超越了任意一个人，就有资格受到表彰。请你计算出有多少人可以得到表彰。

输入
输入第一行仅包含一个正整数n，表示选手数量。(1<=n<=10^5)

输入第二行包含n个正整数，是一个1-n的排列A，表示出发顺序，A[i]表示第i个出发的选手的编号。

输入第三行同样包含一个1-n的排列B，表示到达顺序，B[i]表示第i个到达的选手的编号。

输出
输出仅包含一个整数，表示得到表彰的人数。
5
5 3 1 4 2
2 4 5 1 3
样例输出
3
*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start=new int[n];
        int[] end=new int[n];
        for (int i = 0; i < n; i++) {
            start[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            end[i]=sc.nextInt();
        }
        System.out.println(biaoz(n,start,end));

    }
    public static int biaoz(int n,int[] start,int[] end){
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(start[i]>start[j]&&end[i]<end[j]){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
