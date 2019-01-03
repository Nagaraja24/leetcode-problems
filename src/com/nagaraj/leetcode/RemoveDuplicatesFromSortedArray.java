package com.nagaraj.leetcode;

/**
 * 
 * 
 * 
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * 
 * 
 * @author Nagaraj
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 2, 3, 4, 5, 6, 6, 8, 9, 9, 9, 9 };
		System.out.println("Array wihout duplicates = " + removeDuplicates(nums));

	}

	/**
	 * 
	 * Since the array is already sorted, we can keep two pointers i and j, where ii
	 * is the slow-runner while j is the fast-runner. As long as nums[i] =nums[j],
	 * we increment j to skip the duplicate.
	 * 
	 * When we encounter nums[j] != nums[i], the duplicate run has ended so we must
	 * copy its value to nums[i + 1]. i is then incremented and we repeat the same
	 * process again until j reaches the end of array.
	 * 
	 * 
	 * Time complextiy : O(n)O(n). Assume that nn is the length of array. Each of i
	 * and j traverses at most n steps.
	 * 
	 * Space complexity : O(1)O(1).
	 * 
	 * 
	 * @param nums
	 * @return array length
	 */
	public static int removeDuplicates(int[] nums) {

		if (nums.length == 0)
			return 0;

		int i = 0;

		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}

		}

		return i + 1;

	}

}
