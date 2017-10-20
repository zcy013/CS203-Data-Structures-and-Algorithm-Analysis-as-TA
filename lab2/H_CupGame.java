/**
 * Problem H: Cuperman’s Cup Game
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Cuperman has two cups A and B. There are x balls in A, y balls in B. You can move balls between these two cups. 
 * The number of balls can be moved from A to B (or from B to A) is equal to the number of balls in B (or in A). 
 * For example, if A has 3 balls and B has 2 balls, you only can move 2 balls from A to B, 
 * but cannot move 2 balls from B to A. Now Cuperman wants to know, how many move steps he need to obtain one empty cup.
 * 
 * @Input
 * The first line will be an integer T (T <= 10^5), which is the number of test cases.
 * For each test case, you will be given two integers x and y. (0 <= x, y <= 100000)
 * 
 * @Output
 * For each test case, output the number problem required. If you can't make any cup empty, output -1.
 */

package lab2;

import java.util.Scanner;

public class H_CupGame {
	private static int Aballs, Bballs;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int count = 0;
		while (++count <= cases) {
			Aballs = in.nextInt();
			Bballs = in.nextInt();
			System.out.printf("%d\n", move());
		}
		in.close();
	}

	public static int move() {
		int steps = 0;
		while (Aballs != Bballs) {
			if (Aballs < Bballs) {
				Bballs -= Aballs;
				Aballs *= 2;
			} else {
				Aballs -= Bballs;
				Bballs *= 2;
			}
			++steps;
			if (steps >= 20)
				return -1;
		}
		return ++steps;
	}

}
