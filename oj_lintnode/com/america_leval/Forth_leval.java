package com.america_leval;

public class Forth_leval {

	public static void main(String[] args) {
		System.out.println(-512>>100);
	}

}

class Solution_10 {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
          double decPart = Double.parseDouble(n.substring(n.indexOf('.')));
          String intstr = "";
         String decstr = "";
         
         if (intPart == 0) intstr += '0';
         while (intPart > 0) {
             int c = intPart % 2;
             intstr = c + intstr;
             intPart = intPart / 2;
         }
        
         while (decPart > 0.0) {
             if (decstr.length() > 32) return "ERROR";
             double r = decPart * 2;
             if (r >= 1.0) {
                 decstr += '1';
                 decPart = r - 1.0;
             }
             else {
                 decstr += '0';
                 decPart = r;
             }
            }
         return decstr.length() > 0? intstr + "." + decstr : intstr;
    }
}



//不同的二叉查找树 - C++ 
//class Solution {
//public:
//    /**
//     * @paramn n: An integer
//     * @return: An integer
//     */
//    int numTrees(int n) {
//        int* dp = new int[n+1];
//        fill(dp, dp+n+1, 0);
//        dp[0]=dp[1]=1;
//        for(int i=2;i<n+1;i++){
//            for(int j=1;j<=i;j++){
//                dp[i] += dp[j-1]*dp[i-j];
//            }
//        }
//        int re = dp[n];
//        delete dp;
//        return re;
//    }
//};

//中等 快速幂 - C++ 
//class Solution {
//public:
//    /*
//     * @param a, b, n: 32bit integers
//     * @return: An integer
//     */
//    int fastPower(int a, int b, int n) {
//        if(n==0)
//            return 1%b;
//        if(n==1)
//            return a%b;
//        long long temp = fastPower(a,b,n/2);
//        if(n&1)
//            return ((temp*temp)%b)*a%b;
//        else
//            return temp*temp%b;
//    }
//};

// 更新二进制位
class Solution_Forth_leval_5 {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
	public int updateBits(int n, int m, int i, int j) {
		int flag = 1;
        String str_m = "";
        String str_n = "";

        while(flag>0){
            if( (m & flag) == 0)
                str_m+='0';
            else{
                str_m+='1';
            }
            flag = flag*2;
        }

        flag = 1;
        while(flag>0){
            if( (n & flag) == 0)
                str_n+='0';
            else{
                str_n+='1';
            }
            flag = flag*2;
        }
        
        char[] n_char = new char[32];
        char[] n_char_temp = str_n.toCharArray();
        for(int t=0;t<n_char_temp.length;t++)
        		n_char[t] = n_char_temp[t];
        char[] m_char = new char[32]; 
        		str_m.toCharArray();
        for(int k = i; k <= j; k++){
            n_char[k] = m_char[k-i];

        }

        int result = 0;
        int count = 1;
        for(int p = 0; p < str_n.length(); p++){
            if(n_char[p] == '1')
                result += count;
            count*=2;
        }

        return result;
	}
	
	// 负数的时候，出错
    public int updateBits__wrong(int n, int m, int i, int j) {
    	int a = (n<<(32-i-1))>>>(32-i-1);
    	int b = m<<i;
    	int c = a|b;
    	int d = (n>>>(j+1))<<(j+1);
    	return d|c;
    }
}

// 尾部的零
class Solution_Forth_leval_4 {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
    	long ret = 0;
        while(n!=0){
            ret += n/5;
            n /= 5;
        }
        return ret;
    	
    }
};

// 不同的路径
class Solution_Forth_leval_3 {
	/**
	 * @param n,
	 *            m: positive integer (1 <= n ,m <= 100)
	 * @return an integer
	 */
	public int uniquePaths(int m, int n) {
		int[][] count = new int[m + 1][n + 1];
		count[0][0] = 0;
		count[1][1] = 1;
		for (int i = 1; i <= m; i++)
			count[i][1] = 1;
		for (int i = 1; i <= n; i++)
			count[1][i] = 1;
		for(int i=2;i<=m;i++){
			for(int j=2;j<=n;j++){
				count[i][j] = count[i-1][j]+count[i][j-1];
			}
		}

		return count[m][n];
	}
}

// O(1)检测2的幂次
class Solution_Forth_leval_2 {
	/*
	 * @param n: An integer
	 * 
	 * @return: True or false
	 */
	public boolean checkPowerOf2(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}
};

// 将整数A转换为B
class Solution_Forth_leval_1 {
	/**
	 * @param a,
	 *            b: Two integer return: An integer
	 */
	public static int bitSwapRequired(int a, int b) {
		int s = a ^ b;
		int count = 0;
		while (s != 0) {
			if ((s & 1) == 1)
				count++;
			// 无符号右移
			s = s >>> 1;
		}
		return count;
	}
};
