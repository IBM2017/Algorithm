package 合并两个有序数组;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;n--;
        int j=m+n+1;
        while (m>=0&&n>=0){
            if (nums1[m]>nums2[n]){
                nums1[j--]=nums1[m--];
            }else nums1[j--]=nums2[n--];
        }
        if (m<0){
            while (n>=0){
                nums1[j--]=nums2[n--];
            }
        }
    }
}
