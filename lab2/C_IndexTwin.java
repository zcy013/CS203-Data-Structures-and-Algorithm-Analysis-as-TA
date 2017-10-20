/**
 * Problem C: Index Twin (easy)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Given an sorted integer array A and a specific target m. Cuperman defines (i,j) is index twin if A[i] + A[j] = m. 
 * Could you help Cuperman to find how many index twins are in the given array A with a specific target m.
 * 
 * @Input
 * The first line will be an integer T(1<T<=10), which is the number of test cases. For each case contain two lines. 
 * The first line contains two numbers n(1<=n<=5000) and m(1<=m<=10^8), n is the size of array A. m is the specified target.
 * The second line contains n integers: a1, a2, ... an (1<=ai <= 10^6, 1 <= i <= n).
 * 
 * @Output
 * For each case print a number, the number of index twins.
 */

package lab2;

import java.util.Scanner;

public class C_IndexTwin {
	private static int size, target;
	private static int[] array;
	private static int result;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		C_IndexTwin it = new C_IndexTwin();
		int cases = in.nextInt();
		int count = 0;
		while (++count <= cases) {
			result = 0;
			size = in.nextInt();
			target = in.nextInt();
			array = new int[size];
			for (int i = 0; i < size; ++i)
				array[i] = in.nextInt();
			for (int left = 0; left < size && array[left] <= target / 2; ++left) {
				it.findRightTwin(left);
			}
			System.out.println(result);
		}
		in.close();
	}

	private int findRightTwin(int left) {
		int leftTwin = array[left++];
		int right = size - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (array[mid] < target - leftTwin)
				left = mid + 1;
			else if (array[mid] > target - leftTwin)
				right = mid - 1;
			else {
				++result;
				return mid;
			}
		}
		return -1;
	}

}
