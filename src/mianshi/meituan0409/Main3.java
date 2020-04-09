package mianshi.meituan0409;

import java.util.Scanner;
/*
* 时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
作为一个程序员，修bug（补漏洞）是一项基本的工作。当你刚刚完成一个工作的时候，甲方说你的程序里面有n个bug。

但是你已经很累了，你希望第一天修x个bug,第二天修[x/k]个bug，第三天修[x/k2]个bug，以此类推，第n天修⌊x/k^(n-1) ⌋个bug，直到修不了bug为止。

[x]的意思是x向下取整。在k大于1的时候，总有一天会修不了一个bug的。所以，你希望在这一天来临之前，修完所有的bug。你要计算，你第一次至少要修多少个bug，即x的最小值为多少。

输入
输入包含一行两个整数n , k 分别代表漏洞总数和题目中的参数k

输出
输出包含一个数，即x的最小值


样例输入
10 3
样例输出
8*/
/*4
* 时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
想象一个金字塔形的正四面体，其有四个顶点和六条棱（边）。如果我们把它看成一张图，可以像这样描述：

四个顶点分别为S,A,B,C

六条边分别为(S,A)(S,B)(S,C)(A,B)(A,C)(B,C)

简单来说，是一张四个点的完全图。

现在，有一个很简单的问题等你来解答：你从S点开始，沿着边走K次，回到S点的不同走法有多少种？

（默认每步只能走一条边，同一条边可以走无限次）

输入
输入一个数K，代表你走的步数

输出
输出一个数，代表不同的方案数对1000000007(109+7)取模后的结果


样例输入
3
样例输出
6*/
/*
* 态匹配问题
时间限制：C/C++语言 2000MS；其他语言 4000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
字符串匹配是一类经典问题。子串在母串中出现的次数称为匹配次数。例如，子串aa在母串aaaba中出现了两次（子串[1,2][2,3])

现在，有一个字符串多重集合（即集合中可以有相同的元素），以及k个字符串，这k个字符串构成了初始集合。

现在你需要维护这么一个动态匹配问题：

1、集合中删除原本k个字符串中的编号为x的字符串。如果编号为x的字符串不在该集合中，保持原样。

2、集合中加入原本k个字符串中的编号为x的字符串。如果编号为x的字符串在该集合中，保持原样。

3、给出一个母串，询问所有还在集合中的字符串作为子串的匹配次数之和。

输入
输入第一行包括两个整数n,k，描述操作次数和初始字符串的个数。

接下来k行，每行描述一个字符串。

接下来n行，每行一个字符串描述一个操作

如果该字符串第一个字符为'+'，接下来为一个数字x，代表将原本k个字符串中的第x个字符串加入集合

如果该字符串第一个字符为'-'，接下来为一个数字x，代表将原本k个字符串中的第x个字符串删除出集合

如果该字符串第一个字符为'?'，接下来为一个字符串S，代表询问S作为母串，所有现在在集合中的字符串作为子串的匹配次数之和。

注意，字符串从1开始编号。

输出对于每一个'?'操作，输出答案。


样例输入
9 3
a
ba
ab
?ababa
+1
?ababa
-2
?ababa
-3
?ababa
+2
?ababa
*
* 输出：
* 7
7
5
3
5*/
public class Main3 {
    public static void main(String[] args) {


/*
        String mother="ababa";
        String[] childe={"a","ba","ab"};
        int x=motherChild(childe,mother);
        System.out.println(x);


*/


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//操作次数
        int k = sc.nextInt();//字符串数
        StringBuilder sub = new StringBuilder();
        String[] sarr = new String[k + n];//用来比较
        String[] sbrr = new String[k + n];//用来操作
        //输入k个字符串
        for (int i = 0; i < k; i++) {
            String s = sc.nextLine();
            sarr[i] = s;
            sbrr[i] = s;
        }
        //输入n次操作


        for (int i = 0; i < n; i++) {
            String m = sc.nextLine();
            char c = m.charAt(0);
            switch (c) {
                case '+':
                    jia(sarr, sbrr, c - '1');
                    break;
                case '-':
                    jia(sarr, sbrr, c - '1');
                    break;
                case '?':
                    System.out.println(motherChild(sbrr, m.substring(1)));
                    break;
            }
        }
    }

    public static void jia(String[] sarr, String[] sbrr, int i) {
        if (sbrr[i] == null) {
            sbrr[i] = sarr[i];
        }
    }

    public static void jian(String[] sarr, String[] sbrr, int i) {
        if (sbrr[i] != null) {
            sbrr[i] = null;
        }
    }

    public static int motherChild(String[] childs, String mother) {
        int sum = 0;
        for (String child : childs) {
            String m = mother;
            while(m.length()>0) {
                int i=m.indexOf(child);
                if (i== -1)
                    break;
                else {
                    if(i!=m.length()-1){
                        m = m.substring(i+1);

                    }
                    else {
                        m="";
                    }
                    sum++;
                }
            }
        }
        return sum;
    }

}
