/**
 * Problem A: Combine Soldier Lists (easy)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Here are two branches of soldiers. 
 * In each branch, the soldiers are in an ordered (i.e., non-decreasing) list by their combat values.
 * You need combine two soldier lists to one army list. And the army list should still be ordered. 
 * Each time, ItakEjgo will give you two ordered soldiers list, and you must return the army list to him after combination.
 * 
 * @Input
 * First line will be a positive integer T (T<=10), which is the number of messages. 
 * For each message, the first line will be two integer n and m, which is the number of soldiers in the two branches. 
 * The second line will be the combat values of one branch. The third line will be the combat values of the other branch. 
 * (1 <= n, m <= 100000, the combat values will in the range [0, 10^9]) 
 * 
 * @Output
 * For each message, prints the combat value of each soldier in army list after combination. 
 */

package lab3;

import java.util.Scanner;

public class A_CombineSoldierList {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int messages = in.nextInt();
		int count = 0;
		while (++count <= messages) {
			int n = in.nextInt();// number of soldiers in branch 1
			int m = in.nextInt();// number of soldiers in branch 2
			int len = n + m;
			int[] branch1 = new int[n];
			int[] branch2 = new int[m];
			int i, j;
			for (i = 0; i < n; ++i)
				branch1[i] = in.nextInt();
			for (j = 0; j < m; ++j)
				branch2[j] = in.nextInt();

			StringBuilder str = new StringBuilder();
			// print result to str then print the str out, to improve performance
			for (i = j = 0; i + j < len;) {
				if (i >= n) {
					str.append(branch2[j]);
					++j;
				} else if (j >= m) {
					str.append(branch1[i]);
					++i;
				} else if (branch1[i] <= branch2[j]) {
					str.append(branch1[i]);
					++i;
				} else {
					str.append(branch2[j]);
					++j;
				}
				str.append(i + j < len ? ' ' : '\n');
			}
			System.out.print(str);

		}
		in.close();
	}

}
