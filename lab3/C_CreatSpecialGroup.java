/**
 * Problem C: Create Special Group (easy)
 * 
 * Time Limit: 1 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * The army master created a special group. The combat value of soldiers in the special group list are random. 
 * The army master has four basic instructions in the special group: 
 * 		1) Insert (x, y), 	2) Delete(x), 	3) Update(x,y), 	4) Reverse.
 * Given a special group list, and a set of instructions, could you print the special group list after each instruction? 
 * For simplicity, Insert is 1, Delete is 2, Update is 3 and Reverse is 4 in the input.
 * 
 * @Input
 * First line will be a positive integer T (T<=50), which is the number of messages.
 * For each message, the first line will be an integer n, n is the number of soldiers at first. 
 * Then there will be n integers which are the combat value of soldiers.
 * Then an integer m, m is the number of operations. 
 * Then will be m lines, each is a command:
 * 		1 x y : insert soldier with combat value y at position x.
 * 		2 x: 	remove the soldiers at position x
 * 		3 x y: 	set combat value of soldier at position x as y.
 * 		4: 		reverse the army
 * The input guarantee that the army will not be empty during the operation.
 * (1 <= n, m <= 100, all labels will be in range [0, 1233])
 * 
 * @Output
 * For each test case, output the special group after each instruction.
 */

package lab3;

import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class C_CreatSpecialGroup {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int cases = cin.nextInt();
		for (int count = 0; count < cases; ++count) {
			LinkedList<Integer> soldiers = new LinkedList<>();
			int number_soldiers = cin.nextInt();
			for (int i = 0; i < number_soldiers; ++i)
				soldiers.add(cin.nextInt());
			int number_instructions = cin.nextInt();
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 0; j < number_instructions; ++j) {
				int instru = cin.nextInt();
				switch (instru) {
				case 1:
					soldiers.add(cin.nextInt(), cin.nextInt());
					break;
				case 2:
					soldiers.remove(cin.nextInt());
					break;
				case 3:
					soldiers.set(cin.nextInt(), cin.nextInt());
					break;
				case 4:
					Collections.reverse(soldiers);
					break;
				}
				Iterator<Integer> it = soldiers.iterator();
				while (it.hasNext())
					stringBuilder.append("" + it.next() + (it.hasNext() ? ' ' : '\n'));
			}
			System.out.print(stringBuilder);
		}
		cin.close();
	}

}
