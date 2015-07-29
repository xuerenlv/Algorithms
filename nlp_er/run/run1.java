package run;

public class run1 {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11,13,15};
		
		int len = arr.length;
		for(int i =0;i<len;i++){
			for(int j =0;j<len;j++){
				for(int k=0;k<len;k++){
					if(arr[i]+arr[j]+arr[k] == 30){
						System.out.println("ok");
						System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
					}
				}
			}
		}
		
		System.out.println("no");
	}

}
