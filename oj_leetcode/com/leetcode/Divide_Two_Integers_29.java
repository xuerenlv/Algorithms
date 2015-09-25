package com.leetcode;

public class Divide_Two_Integers_29 {

	public static void main(String[] args) {

	}

}

class Solution_Divide_Two_Integers_29 {
	//这个用了除法
	public int divide(int dividend, int divisor) {
		if(dividend < 0 && divisor<0){
			if(dividend/divisor < 0){
				return Integer.MAX_VALUE;
			}
		}
		if(dividend > 0 && divisor >0){
			if(dividend/divisor < 0){
				return Integer.MAX_VALUE;
			}
		}
		return dividend/divisor;
	}
	/*
	 * int divide(int dividend, int divisor) {
    if (!divisor || (dividend == INT_MIN && divisor == -1))
        return INT_MAX;
    long long dvd = labs(dividend);
    long long dvs = labs(divisor);
    int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
    int res = 0;
    while (dvd >= dvs) {
        long long tmp = dvs, multiple = 1;
        while (dvd >= (tmp << 1)) {
            tmp <<= 1;
            multiple <<= 1;
        }
        dvd -= tmp;
        res += multiple; 
    }
    return sign * res;
}
	 */
}