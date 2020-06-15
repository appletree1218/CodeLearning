package online.chenke.leetcode;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int[] sum = new int[len];

        System.arraycopy(nums1, 0, sum, 0, nums1.length);
        System.arraycopy(nums2, 0, sum, nums1.length, nums2.length);

        Arrays.sort(sum);
        if(len%2==0){
            return (sum[len>>1]+sum[(len>>1)-1])/2f;
        }

        return sum[len>>1];
    }
}
