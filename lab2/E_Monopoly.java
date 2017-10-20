/**
 * Problem E: Monopoly (median)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Monopoly is a very popular game. Now we will play a simple Monopoly game. 
 * There are N houses in a ring, labeled as 0, 1 … N – 1. 
 * These houses belong to N different people and the ith house has an income a[i] and a fortune f[i]. 
 * At first, f[i] = 1 for i ∈ [0, N-1]. ItakEjgo moves K steps from house X. 
 * For each move step, he can only move from house i to house i + 1, or from house N – 1 to house 0. 
 * If he comes to the ith house, he will give some money to the person who owns this house and his fortune will become a[i] * f[i]. 
 * After K moves, these N people want to know how much money they get. 
 * Please notice that ItakEjgo comes to house X also need 1 move step.
 * 
 * @Input
 * The first line will be an integer T (0 <= T <= 100), which is the number of test cases.
 * For each test case: The first line will be 3 integers: N (1<= N <= 1000), K (0 <= K <= 10^9), X (0 <= X < N).
 * Then will be N numbers, the ith number represent the income a[i]. (0 <= a[i] <= 10^9)
 * 
 * @Output
 * For each test case, you should output N numbers. 
 * The ith number should be the fortune of the ith person f[i] module 123456789.  (i.e., f[i]%123456789)
 */

package lab2;

import java.util.Scanner;

public class E_Monopoly {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		E_Monopoly monopoly = new E_Monopoly();
		int cases = in.nextInt();
		int count = 0;
		while (++count <= cases) {
			monopoly.readInput();
			monopoly.move();
			monopoly.printResult();
		}
	}

	private static int housesNumber, steps, origin;
	private static int[] incomes;
	private static long[] fortunes;

	public void readInput() {
		housesNumber = in.nextInt();
		steps = in.nextInt();
		origin = in.nextInt();
		incomes = new int[housesNumber];
		fortunes = new long[housesNumber];
		for (int i = 0; i < housesNumber; ++i) {
			incomes[i] = in.nextInt();
		}
	}

	public void move() {
		int rings = steps / housesNumber;// 转的圈数
		int offset = steps % housesNumber;// 初始位置到最终位置的位移量
		int[] times = new int[housesNumber];// 经过每个房子的次数
		for (int i = 0; i < housesNumber; ++i)
			times[i] = rings;
		for (int i = 0, position = origin; i < offset; ++i, ++position) {
			if (position == housesNumber)
				position = 0;
			++times[position];
		}
		for (int i = 0; i < housesNumber; ++i)
			fortunes[i] = quickExpMod((long)incomes[i], (long)times[i], 123456789L);
	}

	private long quickExpMod(long base, long power, long mod) {// 快速幂取模算法，返回值为base^power%mod
        base %= mod;
		base %= mod;
		long result = 1;
		while (power != 0) {
			if ((power & 1) == 1) {
				result = (result * base) % mod;
			}
			power >>= 1;
			base = (base * base) % mod;
		}
		return result;
	}

	public void printResult() {
		for (int i = 0; i < housesNumber; ++i) {
			System.out.printf("%d%c", (int)fortunes[i], i == housesNumber - 1 ? '\n' : ' ');
		}
	}
}
