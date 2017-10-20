/**
 * Problem B: Binary Search (easy)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Given an ascending sorted array A with n integers, and if integer m is in the array, returns “YES”, otherwise “NO”
 * 
 * @Input
 * The first line will be an integer T(100<=T<=1000), which is the number of test cases. For each case have two lines. 
 * The first line of the input contains two number n and m, n is the length of the array(1<=n<=106). 
 * You should determine whether m (1<=m<=10^8) is in the array or not. The second line contains the values in the array.
 * 
 * @Output
 * For each case, output only one line print YES or NO.
 */

package lab2;

import java.util.Scanner;

public class B_BinarySearch {
	private static int length;
	private static int number;
	private static int[] numbers;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		int count = 0;
		while (++count <= testCases) {
			length = in.nextInt();
			number = in.nextInt();
			numbers = new int[length];
			for (int i = 0; i < length; ++i)
				numbers[i] = in.nextInt();
			System.out.println(binarySearch() < 0 ? "NO" : "YES");
		}
		in.close();
	}

	private static int binarySearch() {
		int left = 0;
		int right = length - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (numbers[mid] < number)
				left = mid + 1;
			else if (numbers[mid] > number)
				right = mid - 1;
			else
				return mid;
		}
		return -1;
	}

}
