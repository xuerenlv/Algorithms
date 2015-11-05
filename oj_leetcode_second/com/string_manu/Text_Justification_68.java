package com.string_manu;

import java.util.ArrayList;
import java.util.List;

public class Text_Justification_68 {

	public static void main(String[] args) {

	}

}

class Solution_Text_Justification_68 {
//	public List<String> fullJustify(String[] words, int maxWidth) {
//		int start = 0;
//        int size = words.length;
//        int len = words[0].length();
//        List<String> ans = new ArrayList<>();
//        for(int i = 1 ; i < size ; ++i) {
//            if(len + words[i].length() + 1 > maxWidth) {
//                String result = addSpace(words, start , i , len , maxWidth);
//                ans.add(result);
//                start = i;
//                len = words[i].length();
//            } else {
//                len += words[i].length() + 1;
//            }
//        }
//        //procee last
//        String result = addLast(words, start , size , maxWidth);
//        ans.add(result);
//        return ans;
//
//	}
//	
//	String addSpace(String[] words , int start , int end ,  int len , int L) {
//        int exspace = L - len;
//        int cnt = end - start;
//        String tmp = "";
//        if(cnt == 1) {
//            tmp = words[start];
//            tmp.append(exspace , ' ');
//        } else {
//            int avespace = exspace / (cnt - 1);
//            int reminder = exspace % (cnt - 1);
//            for(int i = start ; i < end - 1 ; ++i) {
//                tmp += words[i];
//                tmp.append(avespace + 1 , ' ');
//                if(reminder) {
//                    tmp.append(1 , ' ');
//                    reminder --;
//                }
//            }
//            tmp += words[end-1];
//        }
//        return tmp;
//    }
//    string addLast(vector<string>& words , int start , int end , int L) {
//        string tmp = words[start];
//        for(int i = start + 1 ; i < end ; ++i) {
//            tmp += " " + words[i];
//        }
//        if(tmp.size() < L) tmp.append(L - tmp.size() , ' ');
//        return tmp;
//    }

	
	private List<String> result;
	public List<String> fullJustify(String[] words, int maxWidth) {
	    result = new ArrayList<String>();
	    if (words == null || words.length == 0 || maxWidth < 0) return result;
	    if (maxWidth == 0) {
	        result.add("");
	        return result;
	    }
	    helper(words, 0, maxWidth);
	    return result;
	}

	public void helper(String[] words, int start, int L) {
	    if (start >= words.length) return;

	    int i = start, len = 0, total = 0, next = -1;
	    while (total < L && i < words.length) {
	        total += words[i].length();
	        if (total > L) { // only in this case we need skip i++
	            next = i;
	            break;
	        }
	        len += words[i].length();
	        total++; // count space
	        i++;
	    }

	    if (next == -1) next = i;
	    addList(words, start, next, len, L);

	    helper(words, next, L);
	}

	public void addList(String[] words, int i, int j, int len, int L) {
	    StringBuilder sb = new StringBuilder("");
	    int count = j-i-1, space = 0, more = 0, s = 0;
	    if (count == 0 || j == words.length) { // the last line
	        for (int k = i; k < j; k++) {
	            sb.append(words[k]);
	            if (k == j-1) break;
	            sb.append(" ");
	        }
	        space = L - sb.length();
	        s = 0;
	        while (s++ < space) sb.append(" ");
	    } else {
	        space = (L - len) / count; more = (L - len) % count;
	        for (int k = i; k < j; k++) {
	            sb.append(words[k]);
	            s = 0;
	            if (k == j-1) break;
	            while (s++ < space) sb.append(" ");
	            if (more-- > 0) sb.append(" ");
	        }
	    }

	    result.add(sb.toString());
	}
}