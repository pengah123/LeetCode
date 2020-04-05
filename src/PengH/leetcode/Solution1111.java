package PengH.leetcode;

public class Solution1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result =new int[seq.length()];
        int index=0;
        for (char c : seq.toCharArray()) {
            result[index++]=c=='('? index&1:(index+1)&1;
        }
        return result;
    }
}
