/** 
 * Problem D: CS203 Lucky numbers (hard)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Cuperman defines CS203 Lucky number as that if you rotate the number 180 degrees the number will not change.
 * For example, 69, 96, 111, 181 are lucky numbers. 87, 76 are not.
 * (0, 1, 8 will not change in this way, 6 will change into 9, 9 will change into 6. 2 and 5 can't change to each other)
 * In this problem, you are asked to the number of CS203 lucky number between range L and R.
 * 
 * @Input 
 * There are multiple test cases(less than 10), each test will contain two integers L and R.
 * Notice the range of L and R is 0 <= L <= R <= 1012
 * 
 * @Output
 * A single line for each test case, represent the number of lucky number in [L, R].
 */

package lab1;

import java.util.*;

public class D_LuckyNumber {
	static long leftBound, rightBound;
	static Set<Long> numbers;
	static int maxBits;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int testCase = 0;
		while (/*++testCase <= 10 &&*/ in.hasNext()) {
			leftBound = in.nextLong();
			rightBound = in.nextLong();
			maxBits = (int) Math.log10(rightBound) + 1;// 右界数的位数
			numbers = new HashSet<>();
			checkRange("0");
			checkRange("00");
			checkRange("1");
			checkRange("11");
			checkRange("8");
			checkRange("88");
			checkRange("69");
			checkRange("96");
			System.out.println(numbers.size());
		}
		in.close();
	}

	private static void expand(String center) {
		String newString = "0" + center + "0";
		checkRange(newString);
		newString = "1" + center + "1";
		checkRange(newString);
		newString = "8" + center + "8";
		checkRange(newString);
		newString = "6" + center + "9";
		checkRange(newString);
		newString = "9" + center + "6";
		checkRange(newString);
	}

	private static void checkRange(String newString) {
		long newNumber = Long.parseLong(newString);
		if (newNumber <= rightBound && newNumber >= leftBound) {
			if (newNumber % 10 != 0 || newNumber == 0)
				// System.out.println(newNumber);
				numbers.add(newNumber);
		}
		if (newString.length() + 2 <= maxBits) {
			expand(newString);
		}
	}

}
