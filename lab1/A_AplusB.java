/**
 * Problem A: A+B (easy)
 * 
 * Time Limit: 1 Sec  Memory Limit: 64 MB
 * 
 * @Description
 * Give you two integers A and B. Please print the sum of the two integers.
 * 
 * @Input
 * Two integers: A B (0<= A <=10^6, 0 <= B <= 10^6)
 * 
 * @Output
 * Sum of the two integers: S
 */

package lab1;

import java.util.Scanner;

public class A_AplusB {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1, n2;
		n1 = in.nextInt();
		n2 = in.nextInt();
		System.out.println(n1 + n2);
		in.close();
	}

}
