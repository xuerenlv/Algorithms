package com.algorithms;

import java.util.HashMap;

public class FindTwoNumberSumEqualsK {

	public static void main(String[] args) {
		int value[] = { 1, 2, 3, 57, 75, 22, 44, 33, 21, 11, 34, 545, 66, 43,
				21, 24 };
		int k = 66;
		
		findTwoNumber(value, k);
	}

	// 寻找和为定值得两个数
	/*
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2. Please
	 * note that your returned answers (both index1 and index2) are not
	 * zero-based.
	 * 
	 * You may assume that each input would have exactly one solution.
	 * 
	 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
	 
	 *
	 *
	 *vector<int> result;
        map<int,int> mapping;

        for (int i=0; i<numbers.size(); i++)
        {
            if (mapping[ target - numbers[i]] > 0)
            {
                result.push_back(mapping[ target - numbers[i]]);
                result.push_back(i+1);               
            }
            else{
                mapping[ numbers[i] ] = i+1;
            }
        }

        return result;   
	 *
	 *
	 */
	
	//利用一个map做hash映射
	public static void findTwoNumber(int value[], int k) {
		int index1=-1,index2=-1;
		
		HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>();
		for(int i=0;i<value.length;i++){
			if(mapping.containsKey(k-value[i])){
				index1 = mapping.get(k-value[i]);
				index2 = i+1;
			}else{
				mapping.put(value[i], i+1);
			}
		}
		
		System.out.println(index1 +" **** "+index2);
	}
}
