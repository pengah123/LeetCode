package Offer.m17;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.printNumbers(2);
    }

//    输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//    考虑大数溢出，用字符串,递归法填充字符串
    public void printNumbers(int n) {
        if(n<=0){
            return;
        }
        char[] number =new char[n];
        for(int i=0;i<10;i++){
            number[0]=(char)('0'+i);
            add(number,0);
        }
    }

    public void add(char[] number,int index){
       if(index==number.length-1){
           print(number);
           return;
       }
       for(int i=0;i<10;i++){
           number[index+1]=(char)('0'+i);
           add(number,index+1);
       }
    }
    public void print(char[] number){
        int i=0;
        while(number[i]=='0'&&i<number.length-1){
            i++;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(number,i,number.length)));
    }
}
