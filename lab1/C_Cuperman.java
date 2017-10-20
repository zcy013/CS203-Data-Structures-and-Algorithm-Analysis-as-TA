/**
 * Problem C: Cuperman’s Problem (medium)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * Doudizhu is a very popular poker card game. It has three players, two of them are Farmers, 
 * Farmer has 17 cards and the third player is Dizhu, Dizhu has 20 cards. 
 * In this problem, you are asked to help Cuperman to sort his cards by the following order:
 * Red joker is the left most one, and White joker will be the second one.
 * Then sort the cards by the number of cards Cuperman has. If the number of cards are the same,
 * sort them as the follow order: Red joker > White joker > 2 > A > K > Q > J > 10 > 9 > 8 > 7 > 6 > 5 > 4 >3.
 * For example, if he not a Dizhu, he has Red joker, four K, three 2, four 9, one A, two 6, two 5, the order will be
 * Red joker K K K K 9 9 9 9 2 2 2 6 6 5 5 A
 * 
 * @Input
 * There are multiple test cases (less than 20).
 * For each case, you will be given a string in the first line show whether Cuperman is a Farmer or Dizhu.
 * Next line contains either 17 or 20 cards, i.e., the cards in Cuperman’s hand.(Red joker will be RJ, and White joker will be WJ).
 * 
 * @Output
 * One line for each test case, give the cards in order according to the problem.
 * Please notice that there are no space in the end of line.
 */

package lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C_Cuperman {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] names = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "WJ", "RJ" };
		Map<String, Integer> name2order = new HashMap<>();// name到order的映射关系
		for (int i = 0; i < names.length; ++i) {
			name2order.put(names[i], i + 1);
		}

		int[] result = new int[15];// 记录每种牌的个数
		int testCase = 0;// 局数
		while (++testCase < 20 && scanner.hasNext()) {
			// result = new int[15];
			int cardsAmount = scanner.next().equals("Dizhu") ? 20 : 17;// 判断身份和牌数
			for (int count = 0; count < cardsAmount; ++count) {// 读取输入，对每种牌计数
				String thisCard = scanner.next();
				++result[name2order.get(thisCard) - 1];
			}

			int type, count = 0;
			for(type = 14; type > 12; --type) {
				if(result[type] != 0) {
					System.out.print(names[type] + " ");
					--result[type];
					++count;
				}
			}
			for (int amount = 4; amount > 0; --amount) {
				for (type = 12; type >= 0 && count < cardsAmount; --type) {// 按牌的种类遍历，查数
					if (result[type] == amount)
						do {
							System.out.print(names[type]);
							System.out.print(++count < cardsAmount ? " " : "\n");
						} while (--result[type] > 0);
				}
			}
		}
		scanner.close();
	}
}
