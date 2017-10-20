/**
 * Problem F: CS203 Seat Arrangement (hard)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * In the CS203 midterm examination, Dr.Tang requires K students to sit in a row. 
 * However, it only has N available seats in that row, at positions seat[1], seat[2], …, seat[n]. 
 * To prevent cheating, Dr. Tang wants to assign the students to these available seats, 
 * such that the minimum distance between any two adjacent students is as large as possible. 
 * Could you tell him what is the largest minimum distance?
 * 
 * @Input
 * Standard input will contain multiple test cases. 
 * The first line of the input is a single integer T (1 <= T <= 10) which is the number of test cases.
 * T test cases follow, for each test case:
 * The first line contains two integers N and K (2 <= K <= N <= 100000)
 * The second line contains N integers, which are the positions of available seats, 
 * i.e., the i-th integer is the position of seat[i] (0 <= seat[i] <= 109).
 * 
 * @Output
 * Each test case prints a single line. The largest minimum distance between any two adjacent students.
 */

package lab2;

import java.util.*;

public class F_SeatArrangement {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int cases = in.nextInt();
		int count = 0;
		F_SeatArrangement sa = new F_SeatArrangement();
		while (++count <= cases) {
			sa.readInput();
			System.out.printf("%d\n", sa.searchDistance());
		}
	}

	private static int seatNumber, studentNumber;
	private static int[] positions;

	public void readInput() {
		seatNumber = in.nextInt();
		studentNumber = in.nextInt();
		positions = new int[seatNumber];
		for (int i = 0; i < seatNumber; ++i) {
			positions[i] = in.nextInt();
		}
		Arrays.sort(positions);// Sort into ascending numerical order.
	}

	public int searchDistance() {
		int maxPossible = (positions[seatNumber - 1] - positions[0]) / (studentNumber - 1);// 最大可能值（不一定能取到）
		int left, right, mid;
		left = 1;
		right = maxPossible;
		int result = 0;
		// 从0到最大可能值进行二分查找
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (checkDistance(mid)) {
				if (mid > result)
					result = mid;
				left = mid + 1;// 继续向右检查是否能取到更大的值
			} else
				right = mid - 1;
		}
		return result;
	}

	private boolean checkDistance(int minDistance) {// 检查是否能以某一间距分配所有学生，使每两相邻学生间距不小于该间距
		int prePosition = 0;
		for (int student = 1; student < studentNumber; ++student) {// 为每一个学生分配座位
			boolean canFind = false;
			for (int position = prePosition + 1; position < seatNumber; ++position) {// 从前一个学生的下一个位置开始查找
				if (positions[position] - positions[prePosition] >= minDistance) {
					prePosition = position;
					canFind = true;
					break;
				}
			}
			if (!canFind)
				return false;
		}
		return true;
	}

}
