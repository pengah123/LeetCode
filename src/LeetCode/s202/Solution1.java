package LeetCode.s202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

如果 n 是快乐数就返回 True ；不是，则返回 False 。

 

示例：

输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
public class Solution1 {
    public static void main(String[] args) {
        int n=19;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isHappy(7));
    }
    public boolean isHappy(int n) {

        while(true){
            int[] num=fenjie(n);
            int sum=0;
            for (int i = 0; i < num.length; i++) {
                sum+=num[i]*num[i];
            }
            if(sum<10){
                if(sum==1||sum==7){
                    return true;
                } else return false;
            }
            else n=sum;
        }
    }
    public int[] fenjie(int n){
        if(n==0){
            return new int[]{0};
        }
        List<Integer> list=new ArrayList<>();
        while (n>0){
            list.add(n%10);
            n/=10;
        }
        int[] ans=new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
}
