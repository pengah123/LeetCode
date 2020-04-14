package Offer.m11;

import java.util.Arrays;
import java.util.Random;

public class kuaipai {
    public static void main(String[] args) {
        int[] arr={23,45,17,11,13,89,72,26,3,17,11,13};
        sortOver(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortOver(int[] arr,int start, int end){
        if(start==end){
            return;
        }
        int index=sort(arr,start,end);
        if(index>start){
            sortOver(arr,start,index-1);
        }
        if(index<end){
            sortOver(arr,index+1,end);
        }
    }
    public static int sort(int[] arr ,int start,int end){

        Random random = new Random();
        int index= random.nextInt(end-start)+start;
        swap(arr,index,end);
        int small=start;
        for (int i = start; i < end; i++) {
            if(arr[i]<arr[end]){
                    swap(arr,i,small);
                    small++;
            }
        }

        swap(arr,small,end);
        return small;
    }
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
