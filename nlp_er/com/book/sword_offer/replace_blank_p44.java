package com.book.sword_offer;

public class replace_blank_p44 {

	public static void main(String[] args) {
		System.out.println(replace("xhj xhj xhj xhj   xhj"));
	}
	
	static String replace(String str){
		String new_str = "";
		for(int i=0;i<str.length();i++){
			if(!(str.charAt(i)==' ')){
				new_str+=str.charAt(i);
			}else{
				new_str+="%20";
			}
		}
		return new_str;
	}
}
