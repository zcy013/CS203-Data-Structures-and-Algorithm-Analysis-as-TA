/**
 * Problem D: Index Triple (median)
 * 
 * Time Limit: 2 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Do you remember Index Twin? This time, Cuperman defines (i, j, k) as index triple if A[i]+A[j]+A[k] = m. 
 * Given a sorted array A and specific target m, determine whether there is an index triple in the array A with specific target m
 * 
 * @Input
 * The first line contains an integer T(10<T<=100), which is the number of test cases. For each case contain two lines. 
 * The first line contains two numbers n(1<=n<=5000) and m(1<=m<=10^8), n is the size of array A. m is the specified target.
 * The second line contains n integers: a1, a2, ... an (1<=ai <= 10^6 , 1 <= i <= n).
 * 
 * @Output
 * For each case prints YES or NO
 */

package lab2;

import java.util.Scanner;

public class D_IndexTriple {
	private static int size, target;
	private static int[] array;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		D_IndexTriple it = new D_IndexTriple();
		int cases = in.nextInt();
		int count = 0;
		while (++count <= cases) {
			String result = "NO";
			size = in.nextInt();
			target = in.nextInt();
			array = new int[size];
			for (int i = 0; i < size; ++i)
				array[i] = in.nextInt();
			for (int first = 0, limit = target / 3; first < size && array[first] < limit; ++first) {
				if (it.hasSecond(first)) {
					result = "YES";
					break;
				}
			}
			System.out.println(result);
		}
		in.close();
	}

	private boolean hasSecond(int first) {
		int limit = (target - array[first]) / 2;
		for (int second = first + 1; second < size && array[second] <= limit; ++second) {
			if (hasThird(first, second))
				return true;
		}
		return false;
	}

	private boolean hasThird(int first, int second) {
		int remain = target - array[first] - array[second];
		int left = second + 1;
		int right = size - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (array[mid] < remain)
				left = mid + 1;
			else if (array[mid] > remain)
				right = mid - 1;
			else
				return true;
		}
		return false;
	}

}
