
public class Unique_Paths_62 {

	public static void main(String[] args) {

	}

}

class Solution_Unique_Paths_62 {
	public int uniquePaths(int m, int n) {
		if (m <= 1 || n <= 1) {
			return (m == 0 || n == 0) ? 0 : 1;
		}

		int[][] view = new int[m][n];
		for (int i = 0; i < m; i++)
			view[i][0] = 1;
		for (int i = 0; i < n; i++)
			view[0][i] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				view[i][j] = view[i - 1][j] + view[i][j - 1];
			}
		}
		return view[m - 1][n - 1];
	}

	// 调用公式
	int uniquePaths_2(int m, int n) {
		int N = n + m - 2;// how much steps we need to do
		int k = m - 1; // number of steps that need to go down
		double res = 1;
		// here we calculate the total possible path number
		// Combination(N, k) = n! / (k!(n - k)!)
		// reduce the numerator and denominator and get
		// C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
		for (int i = 1; i <= k; i++)
			res = res * (N - k + i) / i;
		return (int) res;
	}
}
