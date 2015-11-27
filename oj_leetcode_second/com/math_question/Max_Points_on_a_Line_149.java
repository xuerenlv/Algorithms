package com.math_question;

public class Max_Points_on_a_Line_149 {

	public static void main(String[] args) {
		Point[] points = new Point[3];
		points[0] = new Point(0, 0);
		points[1] = new Point(1, 1);
		points[2] = new Point(2, 2);

		System.out.println(new Solution_Max_Points_on_a_Line_149().maxPoints(points));
	}

}

/**
 * Definition for a point.
 */
class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

class Solution_Max_Points_on_a_Line_149 {
	public int maxPoints(Point[] points) {
		int len = points.length;
		if (len <= 2) {
			return len;
		}
		int[][] count_num = new int[len][len];

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				num_of_points(points, i, j, count_num);
			}
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (count_num[i][j] > max) {
					max = count_num[i][j];
				}
			}
		}
		return max;
	}

	// 两点确定一条直线，然后遍历剩下的点，判断其是否在这条直线上
	void num_of_points(Point[] points, int a, int b, int[][] count_num) {
		int num = 2;

		float k_para = (points[b].x - points[a].x) == 0 ? 10240
				: (float) (points[b].y - points[a].y) / (float) (points[b].x - points[a].x);
		float b_para = (points[a].y - k_para * points[a].x);

		// System.out.println(k_para+" "+b_para);
		for (int i = 0; i < points.length; i++) {
			if (i == a || i == b) {
				continue;
			}
			Point is_one = points[i];
			if (Math.abs(k_para - 10240) < 0.01) {
				if (is_one.x == points[a].x) {
					num++;
				}
			} else {
				if (Math.abs(is_one.y - k_para * is_one.x - b_para) < 0.001) {
					num++;
				}
			}

		}

		count_num[a][b] = num;
	}
}