package com.string_manu;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class Simplify_Path_71 {

	public static void main(String[] args) {
		System.out.println(new Solution_Simplify_Path_71().simplifyPath(
				"/../vLHjV/..///kJIUFFGIKiRx/./RQcjWKMeRTqAiXIxXCoB/.///..///..///.///qNiqHnXgtuOnV///..///zCuLznDGGVKoAHf/./../WsqYCENSj/./../../XeMlhPSwsNSdHAoi/.///J/./bdBdFNDaDf/rEGottNudXxldW/UHhQvv/..///brRIjSXsmvoKTiRVLe/nUa/LyGkYwJogagzxK/EtOSD/iSeCvWa///xsYeyInWUHCmPxYMdzO/../../TaYzVAUtdROxhZTyoBf/ssbyb/tXqmHsoPcBfNTseCCp/dEuFgdxGseYXeN///././//../DdNJ/pmbCjUQAc/Ge/RxqOBnntLS/..///../../vQcCwibUoqojHNpGf/../pijieuc/hE///DbJSQjdNNtHoOdfL///./.././HIuy/KiBLUj/CWAG/mwXPGfpAuyYWJATPL/xb/..///xrM///azpgxlfpOBEkwgEFbRBF/cLxVbwOzmpZmz/sI/gmSaqSXyit/BhPqYfM/gLZDXrtVMz/../COTozRwdivH///DAKgkm/KudvcwrJmkRcMl///WDVVsbY/bkyLXJNraxFBUTNU///MiJSxkDQKKW/BJocXq/oTXWUpFHbfVwtuQ/ESwIqKltMoibnycx/aFjoRWJZRsdyODHrL/./zJgBBZhndtnvjxmoXxJe///DAt/RpNWmaHvANFm/////sNTTPyfUGMRB/Kj/TmqywKmvXcP/midTUVh/oOAznoA///./TbqOnFpZGIPGuTLc/zwrtDqU/./CgbGSpQF///./////TqDGrzkQmwHtNjv/hbuzndcNvbYXcAYVfO/../B/qauBVbisxDEUvHO///./N/./IAB/xRQwqBvyHa/LJuvnfFZNQgY/jbJuS/jDidnyfyGibNNvgAO///./////VwXEWsEN/./hnHiZUUYDfTevV/cvFHcMJblQqmzwd///../ErPJmsxjV/../.././//RWKfqnjK/./ULNpthBQIjVgYCyxr///////RhtyjrvEkFEU/././UZGI///vdEnJmZg/./zaJfYjVLmWSvC/Iql/P/pdAwVwyAIbcmfX///rsRLlhDVtvinVcI/../JNN/GjtSgRDfCBxHo/FxJVzLidpMAwSqjLb/../fqMa///ZTNsULKAtGxGZNabDsAu/////HqwDCBISxIhu/ZFyIvFbawNemimFCuw/dBJBLoNBZSaCTdUjRab/../J/B/./OtrrVeYnxCYiVZuhcI///rWQWcgtXlOByJNOlI/./.././//./vagPbbLhABYCppbqMhjM//"));
		// System.out.println(new
		// Solution_Simplify_Path_71().simplifyPath("/a/./b/../../c/"));
		System.out.println(
				Arrays.toString("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///".split("/")));
	}

}

class Solution_Simplify_Path_71 {

	public String simplifyPath_2(String path) {
		Deque<String> stack = new LinkedList<>(); // 模拟栈，linkedlist的实现，感觉比栈还要强大一些
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));// 用来相当于一个字典
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (!skip.contains(dir))
				stack.push(dir);
		}
		String res = "";
		for (String dir : stack)
			res = "/" + dir + res;
		return res.isEmpty() ? "/" : res;
	}

	// 使用栈进行简化路径
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] paths = path.split("/");
		for (int i = 0; i < paths.length; i++) {
			// System.out.println(stack.toString());
			String temp = paths[i];
			if (temp.equals("..")) {
				if (stack.isEmpty()) {
					if (i == paths.length - 1) {
						return "/";// 到了最后
					} else {
						continue;// 可以一直是。。，把它当做在根节点，循环
					}
				}
				stack.pop();
				continue;
			}
			if (temp.equals(".")) {// 表示当前文件夹
				continue;
			}
			// 既不是.也不是..并且不为空，然后就添加进栈中
			if (temp.length() != 0) {
				stack.add(temp);
			}
		}

		if (stack.isEmpty())
			return "/";
		String re = "";
		while (stack.size() != 0) {
			re = "/" + stack.pop() + re;
		}
		return re;
	}
}