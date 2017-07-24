package com.figer.algorithm.leetcode;

/**
 * Created by figer on 23/07/2017.
 */
public class MedianOfTowSortedArrays {
  public static void main(String[] args) {
    int[] nums1 = {3,4}, nums2 = {1,2};
    double result = new MedianOfTowSortedArrays().findMedianSortedArrays(nums1, nums2);
    System.out.println(result);
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int total = m + n;
    int i = 0;
    int j = 0;
    int[] mergeNums = new int[total];
    for (int l = 0; l < total; l++) {
      if(i == m){
        mergeNums[l] = nums2[j++];
      }else if(j == n){
        mergeNums[l] = nums1[i++];
      }else if(nums1[i] < nums2[j]){
        mergeNums[l] = nums1[i++];
      }else{
        mergeNums[l] = nums2[j++];
      }
    }

    if(total % 2 == 0){
      return (mergeNums[total/2] + mergeNums[total/2-1])/2.0;
    }else{
      return mergeNums[mergeNums.length/2];
    }
  }
}
