package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Sum_4_18 {

	public static void main(String[] args) {
		int[] nums = {0,4,-5,2,-2,4,2,-1,4};
		int ter =  12;
		
		List<List<Integer>> re = new Solution_Sum_4_18().fourSum(nums, ter);
		
		for(int i=0;i<re.size();i++){
			System.out.println(Arrays.toString(re.get(i).toArray()));
		}
	}

}



class Solution_Sum_4_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> re = new ArrayList<List<Integer>>();
    	if(nums.length < 4)
    		return re;
    	
    	Arrays.sort(nums);
//    	System.out.println(Arrays.toString(nums));

    	int index =0;
    	while(index < nums.length-3){
    		if (index > 0 && nums[index] == nums[index - 1]) {
				index++;
				continue;
			}
    		int index_1 = index+1;
    		while(index_1 < nums.length-2 ){
    			int front = index_1 + 1;
    			int tail = nums.length - 1;
    			while (front < tail) {
//    				System.out.println(nums[index]+"  "+nums[index_1]+"  "+nums[front]+"  "+nums[tail]);
    				if (nums[front] + nums[tail] == (nums[index]+nums[index_1] )* (-1)+target) {
    					List<Integer> item = new ArrayList<Integer>();
						item.add(nums[index]);
						item.add(nums[index_1]);
						item.add(nums[front]);
						item.add(nums[tail]);
						
    					if (! re.contains(item)){
    						re.add(item);
    					}
    					front++;
    					tail--;
    				} else if (nums[front] + nums[tail] < (nums[index]+nums[index_1] )* (-1)+target) {
    					front++;
    				} else {
    					tail--;
    				}
    			}
    			index_1++;

    		}
    		index++;
    	}
    	
    	
    	return re;
    }
}