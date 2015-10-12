package com.HashTree;

public class HashTree_test {

	public static void main(String[] args) {
		HashTree hashTree = new HashTree(3);
//		hashTree.add(" 1 2 3 4 5");
//		hashTree.add(" 1 2 3 4 6");
//		hashTree.add(" 1 2 3 4 7");
//		hashTree.add(" 1 2 3 4 8");
//		hashTree.add(" 1 2 3 4 9");
//		hashTree.add(" 1 2 3 4 10");
		hashTree.add(" 4 6");
		hashTree.add(" 4 7");
//		hashTree.add(" 4 8");
//		hashTree.add(" 2 6 7 9");
//		hashTree.add(" 2 7 8 9");
//		hashTree.add(" 2 4 8 9");
		hashTree.check_trans(" 2 3 4 5 6 7 8 9 10");
		hashTree.check_trans(" 1 2 3 4 5 6 7 8 9 10");
		hashTree.check_trans("");
		hashTree.check_trans(" 1 2 3 4 5 6 7 8 9 10");
		System.out.println(hashTree.collect_all_leafs(1, -1).toString());
		System.out.println(hashTree.collect_all_leafs(1, -1).size());
	}

}
