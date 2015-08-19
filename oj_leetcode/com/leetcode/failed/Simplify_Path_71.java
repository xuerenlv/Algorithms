package com.leetcode.failed;

import java.util.Arrays;
import java.util.Stack;

public class Simplify_Path_71 {

	public static void main(String[] args) {
		System.out.println(new Solution_Simplify_Path_71().simplifyPath("/../vLHjV/..///kJIUFFGIKiRx/./RQcjWKMeRTqAiXIxXCoB/.///..///..///.///qNiqHnXgtuOnV///..///zCuLznDGGVKoAHf/./../WsqYCENSj/./../../XeMlhPSwsNSdHAoi/.///J/./bdBdFNDaDf/rEGottNudXxldW/UHhQvv/..///brRIjSXsmvoKTiRVLe/nUa/LyGkYwJogagzxK/EtOSD/iSeCvWa///xsYeyInWUHCmPxYMdzO/../../TaYzVAUtdROxhZTyoBf/ssbyb/tXqmHsoPcBfNTseCCp/dEuFgdxGseYXeN///././//../DdNJ/pmbCjUQAc/Ge/RxqOBnntLS/..///../../vQcCwibUoqojHNpGf/../pijieuc/hE///DbJSQjdNNtHoOdfL///./.././HIuy/KiBLUj/CWAG/mwXPGfpAuyYWJATPL/xb/..///xrM///azpgxlfpOBEkwgEFbRBF/cLxVbwOzmpZmz/sI/gmSaqSXyit/BhPqYfM/gLZDXrtVMz/../COTozRwdivH///DAKgkm/KudvcwrJmkRcMl///WDVVsbY/bkyLXJNraxFBUTNU///MiJSxkDQKKW/BJocXq/oTXWUpFHbfVwtuQ/ESwIqKltMoibnycx/aFjoRWJZRsdyODHrL/./zJgBBZhndtnvjxmoXxJe///DAt/RpNWmaHvANFm/////sNTTPyfUGMRB/Kj/TmqywKmvXcP/midTUVh/oOAznoA///./TbqOnFpZGIPGuTLc/zwrtDqU/./CgbGSpQF///./////TqDGrzkQmwHtNjv/hbuzndcNvbYXcAYVfO/../B/qauBVbisxDEUvHO///./N/./IAB/xRQwqBvyHa/LJuvnfFZNQgY/jbJuS/jDidnyfyGibNNvgAO///./////VwXEWsEN/./hnHiZUUYDfTevV/cvFHcMJblQqmzwd///../ErPJmsxjV/../.././//RWKfqnjK/./ULNpthBQIjVgYCyxr///////RhtyjrvEkFEU/././UZGI///vdEnJmZg/./zaJfYjVLmWSvC/Iql/P/pdAwVwyAIbcmfX///rsRLlhDVtvinVcI/../JNN/GjtSgRDfCBxHo/FxJVzLidpMAwSqjLb/../fqMa///ZTNsULKAtGxGZNabDsAu/////HqwDCBISxIhu/ZFyIvFbawNemimFCuw/dBJBLoNBZSaCTdUjRab/../J/B/./OtrrVeYnxCYiVZuhcI///rWQWcgtXlOByJNOlI/./.././//./vagPbbLhABYCppbqMhjM//"));
//		System.out.println(new Solution_Simplify_Path_71().simplifyPath("/a/./b/../../c/"));
		System.out.println(Arrays.toString("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///".split("/")));
	}

}

class Solution_Simplify_Path_71 {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] paths = path.split("/");
		for (int i = 0; i < paths.length; i++) {
			//System.out.println(stack.toString());
			String temp = paths[i];
			if (temp.equals("..")) {
				if(stack.isEmpty()){
					if(i==paths.length-1){
						return "/";
					}else{
						continue;
					}
				}
				stack.pop();
				continue;
			}
			if (temp.equals(".")) {
				continue;
			}
			if (temp.length() != 0) {
				stack.add(temp);
			}
		}

		if(stack.isEmpty())
			return "/";
		String re = "";
		while (stack.size() != 0) {
			re = "/"+stack.pop() + re;
		}
		return re;
	}
}