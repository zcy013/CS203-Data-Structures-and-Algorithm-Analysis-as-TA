/**
 * Problem A: Sum of Squares (easy)
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Given an integer N, compute 1^2 + 2^2 + 3^2 + ... + N^2
 * 
 * @Input
 * The first line will be an integer T(1<T<=1000), which is the number of test cases.
 * For each test data, you will be given an integer N (1 <= N <= 10^6 ).
 * 
 * @Output
 * For each case please print the sum of 1^2 + 2^2 + 3^2 + ... + N^2.
 */

package lab2;

import java.util.Scanner;

public class A_SumOfSquares {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int count = 0;
		while (++count <= cases) {
			int n = in.nextInt();
			long sum = 1L;
			for (long i = 2L; i <= n; ++i)
				sum += i * i;
			System.out.println(sum);
		}
		in.close();
	}

}
