package com.leetcode.link;

public class Unique_Binary_Search_Trees_96 {

	public static void main(String[] args) {
		System.out.println(new Solution_Unique_Binary_Search_Trees_96().numTrees(3));
	}

}

class Solution_Unique_Binary_Search_Trees_96 {
	// 本题使用一维线性规划解决。
	// 如果n等于0时，结果为0；
	// 如果n等于1时，只有一个节点，结果为1；
	// 如果n等于2时，根节点有两种选择，结果为2；
	// 如果n大于3时，根节点有n种选择，确定根节点后分别计算左右子树的可能情况，然后相乘就是当前根节点下所有的变形种类，之后在求和即可。
	public int numTrees(int n) {
		int[] c = new int[n + 1];
		c[0] = 1;
		c[1] = 1;

		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= i; j++) {
				sum += c[j - 1] * c[i - j];
			}
			c[i] = sum;
		}

		return c[n];
	}
}