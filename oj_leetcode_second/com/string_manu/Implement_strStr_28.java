package com.string_manu;

public class Implement_strStr_28 {

	public static void main(String[] args) {
		System.out.println(new Solution_Implement_strStr_28().strStr("b", "b"));
	}

}

class Solution_Implement_strStr_28 {
	public int strStr(String haystack, String needle) {
		if(haystack.length()==0 && needle.length()==0)
            return 0;
        if(haystack.length()==0 && needle.length()!=0)
            return -1;
        if(haystack.length()!=0 && needle.length()==0)
            return 0;
		int[] next=genNext(needle);
		return findString(haystack, needle, next);
	}
	//kmp主方法
	public int findString(String ma,String find,int next[]){
		char[] ma_c = ma.toCharArray();
		char[] f_c = find.toCharArray();
		int m_len = ma.length();
		int f_len = find.length();
		int i=0,j=0;
		while (i<m_len && j <f_len) {
			if(j==-1 || ma_c[i] == f_c[j]){				//j=-1 意味着开始匹配
				i++;
				j++;
			}else{
//				i=i-j+1;								//i-j 为回到原来的位置，加 1 位向下进一位
//				j=0;
				j = next[j];
			}
		}
		
		return (j==f_len) ? (i-j) : -1;
	}
	
	//获得模式串的next数组
	public int[] genNext(String find){
		char[] f_str = find.toCharArray();
		int len = find.length();
		int next[] = new int[len];
		
		next[0] = -1;
		int k=-1;
		int j=0;
		while (j<len-1) {
			
			//f_str[k]  f_str[j]  分别表示前缀与后缀
			if(k==-1 || f_str[j] == f_str[k]){
				k++;
				j++;
				next[j] = k;
			}else{
				k=next[k];
			}
		}
		return next;
	}

	// 穷举
	public int strStr_overtime(String haystack, String needle) {
		char[] ma_c = haystack.toCharArray();
		char[] f_c = needle.toCharArray();
		int m_len = haystack.length();
		int f_len = needle.length();
		int i = 0, j = 0;
		while (i < m_len && j < f_len) {
			if (ma_c[i] == f_c[j]) {
				i++;
				j++;
//				System.out.println(i + " " + j);
			} else {
				i = i - j + 1; // i-j 为回到原来的位置，加 1 位向下进一位
				j = 0;
			}
		}

		return (j == f_len) ? (i - j) : -1;
	}
}