package com.nagaraj.leetcode;

/**
 * Problem 5 - Find a longest palindrome substring in a given string
 * 
 * We could solve it in O(n^2)O(n2) time using only constant space.
 * 
 * We observe that a palindrome mirrors around its center. Therefore, a
 * palindrome can be expanded from its center, and there are only 2n - 12n−1
 * such centers.
 * 
 * You might be asking why there are 2n - 12n−1 but not nn centers? The reason
 * is the center of a palindrome can be in between two letters. Such palindromes
 * have even number of letters (such as "abba") and its center are between the
 * two 'b's.
 * 
 * 
 */

public class LongestPalindromeSubstring {

	public static void main(String[] args) {

		System.out.println(longestPalindrome("abcdeffed"));
		System.out.println(longestPalindrome("abcdefgh"));

	}

	public static String longestPalindrome(String s) {

		if (s == null || s.length() < 1)
			return "";

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {

			int l1 = expandAroundCenter(s, i, i);
			int l2 = expandAroundCenter(s, i, i + 1);

			int length = Math.max(l1, l2);

			if (length > (end - start)) {
				start = i - (length - 1) / 2;
				end = i + length / 2;
			}
		}

		return s.substring(start, end + 1); // end+1 since substring will not inlcude the end index value

	}

	private static int expandAroundCenter(String s, int left, int right) {

		int L = left;
		int R = right;

		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}

		return R - L - 1;

	}

}
