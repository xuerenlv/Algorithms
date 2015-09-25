package com.leetcode;

public class ZigZag_Conversion_6 {

	public static void main(String[] args) {
//		System.out.println(new Solution_ZigZag_Conversion_6().convert("PAYPALISHIRING", 3));
		System.out.println(new Solution_ZigZag_Conversion_6().convert("A", 1));
	}

}

class Solution_ZigZag_Conversion_6 {
	public String convert(String s, int numRows) {
		String[] h_strs = new String[numRows];
		for (int i = 0; i < h_strs.length; i++)
			h_strs[i] = "";
		
		if(numRows<3){
			if(numRows==1)
				return s;
			if(numRows==2){
				int j=0;
				for(int i=0;i<s.length();i++){
					j=i%2;
					h_strs[j]+=s.charAt(i);
				}
				String re = "";
				for (int i = 0; i < h_strs.length; i++) {
					re += h_strs[i];
				}
				return re;
			}
		}
		
		int j;
		int i = 0;
		int bian=0;
		while (i < s.length()) {
			bian =i/(2*numRows-2);			//取整，得到是第几遍
			int jishu =i-bian*(2*numRows-2);
			
			
			
			if(jishu > numRows-1){
				j=numRows-1 - (jishu-(numRows-1));
			}else{
				j = jishu % numRows;	
			}
//			System.out.println(jishu+" * "+j);
//			System.out.println(i+"  "+j);
			
			h_strs[j] = h_strs[j] + s.charAt(i);
			i++;
		}

		String re = "";
		for (i = 0; i < h_strs.length; i++) {
			re += h_strs[i];
		}
		return re;
	}
}