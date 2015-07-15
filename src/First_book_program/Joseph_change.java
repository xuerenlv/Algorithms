package First_book_program;

public class Joseph_change {

	public static void main(String[] args) {
		joseph_change(3);
		joseph_change(4);
		joseph_change(0);

	}

	// 变形的Joseph问题
	static void joseph_change(int k) {
		int a = 1;
		if (k <= 0)
			return;

		while (true) {
			for (int b = 1; b <= k; b++) {
				int m = a * k + b;
				int t = 0;
				int n = 2 * k;
				int i;
				for (i = 1; i <= k; i++) {
					t = (t + m - 1) % n;

					// 在后k个就要出局
					if (t < k)
						break;
					else
						n--;
				}
				if (i > k) {
					System.out.println(m);
					return;
				}
			}
			a += 2;
		}
	}
}
