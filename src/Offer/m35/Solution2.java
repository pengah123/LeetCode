package Offer.m35;
//快速排序
public class Solution2 {
    public static void main(String[] args) {
        int[] nums={1,2,3,2,2,2,5,4,2};
        System.out.println(new Solution2().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int index=quickSort(nums,0,nums.length-1);
        int mid=nums.length/2;
        int left=0;
        int right=nums.length-1;
        while (index!=mid){
            if(index<mid){
                left=index+1;
            }
            if(index>mid){
                right=index-1;
            }
            index=quickSort(nums,left,right);
        }
        int ans=nums[index];
        int sum=0;
        for (int num : nums) {
            if(num==ans){
                sum++;
            }
        }
        if(sum<=nums.length/2){
            return -1;
        }
        else return ans;
    }
    public int quickSort(int[] nums,int left, int right){
        int index=right;
        int p=left-1;
        for (int i = left; i < index; i++) {
            if(nums[i]<=nums[index]){
                p++;
                if(p!=i){
                    swap(nums,p,i);
                }
            }

        }
        p++;
        swap(nums,p,index);
        return p;
    }
    public void swap(int[] nums, int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
