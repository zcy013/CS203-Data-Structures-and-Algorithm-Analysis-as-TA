/**
 * Problem E: Count Points 
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * You have two 2-D point A and B, please calculate how many integer points in segment A, B. 
 * For example, A(1, 3), B(3, 1) only has 1 integer point (2, 2).
 * 
 * @Input
 * There are multiple test cases (less than 1000), for each test, 
 * there will be one line contain four integers ax, ay and bx, by, represent the point A and B.
 * Notice that the absolute value of integer is 10^9.
 * 
 * @Output
 * One line for each test case, write the number of integer point.
 */

package lab1;

import java.util.Scanner;

public class E_CountPoints {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ax, ay, bx, by, dx, dy, temp;
		int testCase = 0;
		while (++testCase <= 1000 && in.hasNext()) {
			ax = in.nextInt();
			ay = in.nextInt();
			bx = in.nextInt();
			by = in.nextInt();
			dx = Math.abs(ax - bx);
			dy = Math.abs(ay - by);
			/*
			 * 问题可以转化为求dx和dy的最大公因子
			 */
			if (dx > dy) {
				temp = dx;
				dx = dy;
				dy = temp;
			}
			while (dx != 0) {
				temp = dx;
				dx = dy % dx;
				dy = temp;
			}
			System.out.println(dy == 0 ? 0 : (dy - 1));
		}
		in.close();
	}
}
