package LeetCode.s1095;
/*（这是一个 交互式问题 ）

给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。

如果不存在这样的下标 index，就请返回 -1。

 

何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：

首先，A.length >= 3

其次，在 0 < i < A.length - 1 条件下，存在 i 使得：

A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
 

你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：

MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
MountainArray.length() - 会返回该数组的长度*/
/*
*  * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}}*/
public class Solution1 {
    public class MountainArray{
        public int get(int index) {
            return 0;
        }
        public int length() {
            return 0;
        }
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len=mountainArr.length();
        /*1.找到中间索引*/
        int i=findMid(mountainArr,len);
        if(i==-1){
            return -1;
        }
        int left=0;
        int right=i;
        int mid;
        while (left<=right){
            mid=(left+right)/2;
            if(target==mountainArr.get(mid)){
                return mid;
            }
            if(target<mountainArr.get(mid)){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        left=i;
        right=len-1;
        while (left<=right){
            mid=(left+right)/2;
            if(target==mountainArr.get(mid)){
                return mid;
            }
            if(target>mountainArr.get(mid)){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
    public int findMid( MountainArray mountainArr,int len){
        int left=0;
        int right=len-1;
        int mid;
        while (left<=right){
            mid=(left+right)/2;
            if(mid==0){
                return mid;
            }
            if(mid==len-1){
                return mid;
            }
            int m=mountainArr.get(mid);
            int mleft=mountainArr.get(mid-1);
            int mright=mountainArr.get(mid+1);
            if(mleft<m&&mright<m){
                return mid;
            }
            if(mleft<m&&m<mright){
                left=mid;
                continue;
            }
            if(mleft>m&&m>mright){
                right=mid;
            }
        }
        return -1;
    }
}
