/**
 * Problem G: Find Score X in Lab 1 CS203 (median)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * In CS203 lab 1, OJ sorted the scores of Group 3 students in ascending order in array S.
 * Cuperman wants to know the first position of a given score X, could you help him?
 * 
 * @Input
 * Standard input will contain multiple test cases. 
 * The first line of the input is a single integer T (1 <= T <= 10) which is the number of test cases.
 * T test cases follow, for each test case:
 * The first line contains an integer N( 1 <= N <= 10^4 ).
 * The second line contains N integers, which are sorted scores {S[1], S[2], S[3], …, S[n]}. where 0 <= S[i] <= 10^9.
 * Then a single line with an integer Q (0 <= Q <= 10^4).
 * Then there will be Q lines. Each line will give an integer x.
 * 
 * @Output
 * For each query, output the first position i in array S such that S[i] = X, if X is not in the array S, output -1.
 */

package lab2;

import java.util.Scanner;

public class G_FindScore {
	private static int size, number;
	private static int[] scores;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int count = 0;
		while (++count <= cases) {
			size = in.nextInt();
			scores = new int[size];
			for (int i = 0; i < size; ++i)
				scores[i] = in.nextInt();
			number = in.nextInt();
			for (int i = 0; i < number; ++i)
				System.out.println(findFirstPosition(in.nextInt()));
		}
		in.close();
	}

	public static int findFirstPosition(int score) {
		int left = 0;
		int right = size - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (scores[mid] >= score)
				right = mid;
			else
				left = mid + 1;
		}
		if (scores[left] == score)
			return left + 1;
		return -1;
	}

}
