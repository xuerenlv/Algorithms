package com.leetcode;

public class Wildcard_Matching_44 {

	public static void main(String[] args) {
		// System.out.println(new
		// Solution_Wildcard_Matching_44().isMatch("abefcdgiescdfimde",
		// "ab*cd?i*de"));

	}

}

class Solution_Wildcard_Matching_44 {
	// public boolean isMatch(String s, String p) {
	// String star = null;
	// String rs = null;
	//
	// int index_s = 0;
	// int index_p = 0;
	// while(index_s<s.length()){
	// if(s.charAt(index_s)==p.charAt(index_p) || p.charAt(index_p)=='?'){
	// index_s++;index_p++;
	// continue;
	// }
	// if(p.charAt(index_p) == '*') {
	// star = p.substring(index_p+1);
	// rs = s.substring(index_s);
	// continue;
	// }
	// if(star != null) {
	// p = star;
	// s = s.substring(index_s);
	// index_s ++;
	// continue;
	// }
	// return false;
	//
	// }
	// while(p.charAt(index_p) == '*') index_p++;
	// return index_p == '\0';
	//
	// }

	// Time Limit Exceeded
	// 递归的版本，耗时太大
	public boolean isMatch(String s, String p) {
		int len = s.length();
		if (len == 0) {
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*')
					return false;
			}
			return true;
		}
		if (p.length() == 0)
			return s.length() == 0;
		if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
			return isMatch(s.substring(1, len), p.substring(1, p.length()));
		} else if (p.charAt(0) == '*') {
			p = p.substring(1, p.length());
			while (s.length() != 0) {
				if (isMatch(s, p))
					return true;
				s = s.substring(1, s.length());
			}
			return isMatch(s, p);

		} else {
			return false;
		}
	}

	// 正确的做法是贪心.
	//
	// 大概是这样的
	//
	// 我们来匹配s和p
	//
	// 如果匹配就s++ , p++
	//
	// 如果不匹配的话就看p之前知否有*
	//
	// 当然是否有*我们需要记录的,遇到*就记录当前*的位置和匹配到的s的位置
	//
	// 然后从*的下一位置匹配,开始匹配0个字符
	//
	// 如果ok往后走,往后不ok,那么匹配1个字符...同理2,3,4个字符(有点回溯的感觉吧
	//
	// 所以实践复杂度是O(len(s) * len(p))
	/*
	 * bool isMatch(const char *s, const char *p) { //? match one //* match
	 * 0,1,2,3.. // aaaabc *c true const char* star = nullptr; const char* rs =
	 * nullptr;
	 * 
	 * while(*s) { if(*s == *p || *p == '?') { //match s++; p++; continue; }
	 * if(*p == '*') { star = p; // record star p++; //match from next p rs = s;
	 * // record the position of s , star match 0 continue; } if(star !=
	 * nullptr) { //if have star in front then backtrace p = star + 1; //reset
	 * the position of p s = rs + 1; rs ++; //star match 1,2,3,4,5.... continue;
	 * } return false; //if not match return false } while(*p == '*') p++;
	 * //skip continue star return *p == '\0'; // successful match }
	 */

	// C语言代码，还没看懂
	// class Solution {
	// public:
	// bool isMatch(const char *s, const char *p) {
	// //greedy
	// bool pre,next;
	// const char *start,*end,*mid;
	// const char *ss,*se,*sm;
	// start = p;
	// end = p;
	// ss = s;
	// while(true){
	// if(*start == '*')pre = true;//查看前面有没有*
	// else pre = false;
	// //查看新的没有*的word
	// while(*start != '\0' && *start == '*')start++;
	// end = start;
	//
	// while(*end != '\0' && *end != '*')end++;
	// if(*end == '*')next = true;
	// else next = false;
	// end--;
	//
	// if(*ss == '\0' && pre && *start == '\0')return true;//p和s均完全匹配
	// if(*ss != '\0' && pre && *start == '\0')return true;
	// if(*ss != '\0' && (*start == '\0' && !pre))return false;//s没能完全匹配
	// if(*ss == '\0' && *start != '\0')return false;//p的字母没能匹配完全
	//
	// //处理greedy匹配问题
	// if(next == true){//后面有*可供匹配
	// if(pre == true){//前面有供做匹配的
	// sm = ss,mid = start;//判断s中剩余的还够匹配不够
	// while(mid != end && *sm != '\0'){
	// mid++,sm++;
	// }
	// if(*sm == '\0')return false;
	//
	// mid = start;
	// while(*mid != '*' && *ss != '\0'){
	// for(sm = ss,mid = start;*sm != '\0' && *mid != '*';sm++,mid++){
	// if(*mid == '?')continue;
	// if(*mid != *sm)break;
	// }
	// if(*mid == '*')ss = sm;
	// else ss++;
	// }//while
	// if(*mid != '*')return false;
	// ss = sm;
	// start = mid;
	// }
	// else{//前面没有供匹配的
	// for(sm = ss,mid = start;*sm != '\0' && mid != end+1;sm++,mid++){
	// if(*mid == '?')continue;
	// if(*mid != *sm)return false;
	// }
	// if(mid != end+1)return false;
	// ss = sm;//匹配成功
	// start = end+1;
	// }
	// }
	// else{//最后必须匹配的一串，因为后面没有*可供匹配最后的字母
	// if(pre){
	// se = ss;
	// while(*se != '\0')
	// se++;
	// se--;
	// for(sm = se,mid = end;mid != start && sm != ss;mid--,sm--){
	// if(*mid == '?')continue;
	// if(*mid != *sm)return false;
	// }
	// if((sm == ss && mid != start) || (*mid != *sm && *mid != '?'))return
	// false;//如果s不够匹配或者p开头不能匹配
	// return true;
	// }
	// else{
	// for(sm = ss,mid = start;*sm != '\0' && *mid !='\0';sm++,mid++){
	// if(*mid == '?')continue;
	// if(*mid != *sm)return false;
	// }
	// if(*sm != '\0' || *mid != '\0')return false;
	// return true;
	// }
	//
	// }
	// }
	// }
	// };
}