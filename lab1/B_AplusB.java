/**
 * Problem B: A + B (medium)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Give you two decimal integers A and B, please calculate the sum of A and B.
 * 
 * @Input
 * There are multiple test data (less than 1000). 
 * For each test data, there will be two integers, represent A and B (0 <= A, B <= 101000).
 * 
 * @Output
 * One line for each test case, it is the sum of A and B.
 */

package lab1;

import java.util.Scanner;

public class B_AplusB {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = 1001;
		int[] n1 = new int[size];
		int[] n2 = new int[size];
		int[] sum = new int[size];

		while (scanner.hasNext()) {
			// 用string读取输入
			String s1 = scanner.next();
			String s2 = scanner.next();
			// string逆位转为int数组
			for (int i = 0; i < s1.length(); ++i) {
				n1[i] = s1.charAt(s1.length() - 1 - i) - 48;
			}
			for (int i = 0; i < s2.length(); ++i) {
				n2[i] = s2.charAt(s2.length() - 1 - i) - 48;
			}

			// 按位求和
			int i, carryIn, carryOut = 0;
			for (i = 0; i < s1.length() || i < s2.length(); ++i) {
				carryIn = carryOut;
				int realSum = n1[i] + n2[i] + carryIn;
				sum[i] = realSum % 10;
				carryOut = realSum / 10;
			}
			if (carryOut != 0)
				sum[i] = carryOut;
			else
				--i;

			// 按位输出
			while (i >= 0) {
				System.out.print(sum[i--]);
			}
			System.out.println();
		}

		scanner.close();
	}
}
