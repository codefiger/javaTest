package com.figer.arithmetic;

import java.util.Arrays;
import java.util.HashSet;

public class SortTest {
	
	public static void main(String[] args) {
		int[] arr = {101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25};
		int[] arr1 = {101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,101,5,1,2,8,100,4,9,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25};
		selectionSort(arr);
		arr = arr1;
		bubbleSort(arr);
		arr = arr1;
		insertSort(arr);
		
		arr = arr1;
		long startTime = System.currentTimeMillis();
		quickSort(arr, 0, arr.length - 1);
		System.out.println("quickSort use time:" + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println(Arrays.toString(arr));

    HashSet set = new HashSet();
    set.add("");
	}
	
	
	/**
	 * 遍历未排序的数组，每次找出最大的排到前面
	 * @param orgArr
	 */
	public static void bubbleSort(int[] orgArr){
		long startTime = System.currentTimeMillis();
		int tmp;
		for(int i = 0;i < orgArr.length - 1;i++){
			for (int j = 0; j < orgArr.length - i - 1; j++) {
				if(orgArr[j + 1] < orgArr[j]){
					tmp = orgArr[j];
					orgArr[j] = orgArr[j + 1];
					orgArr[j + 1] = tmp;
				}
				
			}
		}
		System.out.println("bubbleSort use time:" + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println(Arrays.toString(orgArr));
		
	}
	
	public static void selectionSort(int[] orgArr){
		long startTime = System.currentTimeMillis();
		int tmp,j;
		for(int i = 0;i < orgArr.length - 1;i++){
			for (j = i + 1; j < orgArr.length; j++) {
				tmp = orgArr[i];
				if(orgArr[i] > orgArr[j]){
					orgArr[i] = orgArr[j];
					orgArr[j] = tmp;
				}
				
			}
		}
		System.out.println("selectionSort use time:" + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println(Arrays.toString(orgArr));
		
	}
	
	/**
	 * 将未排序的数插入到已排序的数组中
	 * @param orgArr
	 */
	public static void insertSort(int[] orgArr){
		long startTime = System.currentTimeMillis();
		int tmp,j;
		for(int i = 1;i < orgArr.length;i++){
			tmp = orgArr[i];
			for (j = i - 1; j >= 0 && tmp < orgArr[j]; j--) {
				orgArr[j + 1] = orgArr[j]; 
			}
			orgArr[j + 1] = tmp;
		}
		System.out.println("insertSort use time:" + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println(Arrays.toString(orgArr));
		
	}
	
	/**
	 * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
	 * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
	 * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分
	 * @param orgArr
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] orgArr, int low, int high){
		int middle ;
		if (low < high) {
			middle = getMiddle(orgArr, low, high);
			quickSort(orgArr, low, middle - 1);
			quickSort(orgArr, middle + 1, high);
		}
	}
	
	private static int getMiddle(int[] arr, int low, int high){
		int tmp = arr[low];
		while(low < high){
			while(low < high && arr[high] >= tmp){
				high --;
			}
			arr[low] = arr[high];
			
			while(low < high && arr[low] <= tmp){
				low ++;
			}
			arr[high] = arr[low];
		}
		arr[low] = tmp;
		return low;
	}
}
