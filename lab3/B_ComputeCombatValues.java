/**
 * Problem B: Compute Combat Values of Soldiers (median)
 * 
 * Time Limit: 2 Sec  Memory Limit: 128 MB
 * 
 * @Description (simplified)
 * Give you two polynomial, please calculate the addition among them.
 * Each time, ItakEjgo will give you the (coefficient, exponent) pairs (i.e., in ascending order of soldiers level)
 * of two polynomials. For example, f(x) = 1+2x+3x^2 will be given as (1 0), (2 1), (3 2). 
 * You return the polynomial after addition to him.
 * Please pay attention to the special cases, e.g., the result is 0, the sum of compact values is 0 or 1 at level i. 
 * We follow all these definitions and notations in Math.
 * p.s. Based on the story(I've omitted it for it's too long) of this problem,
 * 		the coefficients could be negative values and the exponents could not.
 * 
 * @Input
 * First line will be a positive integer T (T<=100), which is the number of messages.
 * The first line will be an integer n, which is the number of terms of the first polynomial. 
 * Then n lines will be the coefficients and exponents of the terms.
 * After n + 1 lines, there will be an integer m for the number of terms of the second polynomial. 
 * And m lines of (coefficient, exponent) pairs.
 * (0 <= n, m <= 1000, all exponents are in the range [0, 10^9], all coefficients are in the range [-10000, 10000])
 * 
 * @Output
 * For each message, print the polynomial with the same syntax as the sample shows.
 */

package lab3;

import java.util.Scanner;

public class B_ComputeCombatValues {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int cases = cin.nextInt();
		int count = 0;
		while (++count <= cases) {
			int n, m, i, j, len;
			n = cin.nextInt();
			int[][] branch1 = new int[n][2];
			for (i = 0; i < n; ++i) {
				branch1[i][0] = cin.nextInt();
				branch1[i][1] = cin.nextInt();
			}
			m = cin.nextInt();
			int[][] branch2 = new int[m][2];
			for (j = 0; j < m; ++j) {
				branch2[j][0] = cin.nextInt();
				branch2[j][1] = cin.nextInt();
			}
			len = n + m;

			StringBuilder str = new StringBuilder();
			Item solider;
			if (count != 1)
				System.out.println();
			for (i = j = 0; i + j < len;) {
				if (i >= n) {
					solider = new Item(branch2[j][0], branch2[j][1]);
					++j;
				} else if (j >= m || branch1[i][1] < branch2[j][1]) {
					solider = new Item(branch1[i][0], branch1[i][1]);
					++i;
				} else if (branch1[i][1] > branch2[j][1]) {
					solider = new Item(branch2[j][0], branch2[j][1]);
					++j;
				} else {
					int coe = branch1[i][0] + branch2[j][0];
					if (coe != 0)
						solider = new Item(coe, branch1[i][1]);
					else
						solider = new Item(0, 0);
					++i;
					++j;
				}
				if (solider.getCoe() == 0)
					continue;
				else if (solider.getCoe() > 0 && !str.toString().equals(""))
					str.append("+" + solider);
				else
					str.append(solider);
			}
			if (str.toString().equals(""))
				System.out.print("0");
			else
				System.out.print(str);

		}
		cin.close();
	}

}

class Item {
	private int coe, exp;

	public Item(int coefficient, int exponent) {
		coe = coefficient;
		exp = exponent;
	}

	public int getCoe() {
		return coe;
	}

	public int getExp() {
		return exp;
	}

	@Override
	public String toString() {
		if (coe == 0)
			return "0";
		if (exp == 0)
			return coe + "";
		if (coe != 1 && coe != -1 && exp != 1)
			return coe + "x^" + exp;
		String str;
		if (coe == 1)
			str = "x";
		else if (coe == -1)
			str = "-x";
		else
			return coe + "x";
		if (exp != 1)
			return str + "^" + exp;
		else
			return str;
	}
}
