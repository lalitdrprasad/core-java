package com.study.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MedianOf2Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] mergedArray = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
		Arrays.sort(mergedArray);
		int size = nums1.length + nums2.length;
		if (size % 2 == 0)
			return (mergedArray[size / 2 - 1] + mergedArray[size / 2]) / 2d;
		return mergedArray[size / 2];
	}
	
	public static void main(String[] args) {
		MedianOf2Arrays obj = new MedianOf2Arrays();
		System.out.println(obj.findMedianSortedArrays(new int[] { 1, 9, 2, 6, 8 }, new int[] { 3, 4, 5, 7 }));
	}
}