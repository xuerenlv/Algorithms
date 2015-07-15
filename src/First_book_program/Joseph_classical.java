package First_book_program;

import java.util.Arrays;

public class Joseph_classical {

	public static void main(String[] args) {
		joseph_classical(6, 5);
	}
	
	//经典的Joseph问题
	//输入n,m;编号为1到n，从1号报数，报到m出局
	static void joseph_classical(int n,int m){
		int[] nums=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=i+1;
		}
		
		int t=0;
		int temp;
		while(n>0){		//执行n次
			t=(t+m-1)%n;
			
			//nums[n] <----> nums[t];
			temp=nums[n-1];
			nums[n-1]=nums[t];
			nums[t]=temp;
			
			n--;
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
