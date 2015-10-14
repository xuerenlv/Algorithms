package com.search;

public class First_Bad_Version_278 {

	public static void main(String[] args) {

	}

}

class VersionControl {
	boolean isBadVersion(int version) {
		return false;
	}
}

class Solution extends VersionControl {
	public int firstBadVersion(int n) {
		if (n <= 0)
			return 0;
		int l = 1, r = n;
		while (l < r) {
			// 位操作的优先级比较高
			int mid = l + ((r - l) >> 1);
			if (isBadVersion(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
}