package com.binary_tree;

public class Unique_Binary_Search_Trees_96 {

	public static void main(String[] args) {
		System.out.println(new Solution_Unique_Binary_Search_Trees_96().numTrees(3));
	}

}

class Solution_Unique_Binary_Search_Trees_96 {
	/**
	 * Taking 1~n as root respectively:
	 *      1 as root: # of trees = F(0) * F(n-1)  // F(0) == 1
	 *      2 as root: # of trees = F(1) * F(n-2) 
	 *      3 as root: # of trees = F(2) * F(n-3)
	 *      ...
	 *      n-1 as root: # of trees = F(n-2) * F(1)
	 *      n as root:   # of trees = F(n-1) * F(0)
	 *
	 * So, the formulation is:
	 *      F(n) = F(0) * F(n-1) + F(1) * F(n-2) + F(2) * F(n-3) + ... + F(n-2) * F(1) + F(n-1) * F(0)
	 */

//	int numTrees(int n) {
//	    int dp[n+1];
//	    dp[0] = dp[1] = 1;
//	    for (int i=2; i<=n; i++) {
//	        dp[i] = 0;
//	        for (int j=1; j<=i; j++) {
//	            dp[i] += dp[j-1] * dp[i-j];
//	        }
//	    }
//	    return dp[n];
//	}

	// 更优化的写法，动态规划，经典
	public int numTrees_2(int n) {
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
			}
		}

		return G[n];
	}

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
			for (int j = 1; j <= i; j++) {// 确定根节点后分别计算左右子树的可能情况，然后相乘就是当前根节点下所有的变形种类
				sum += c[j - 1] * c[i - j];
			}
			c[i] = sum;
		}

		return c[n];
	}
}