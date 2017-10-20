/**
 * Problem D: Find the Spy (median)
 * 
 * Time Limit: 2 Sec  Memory Limit: 128 MB
 * 
 * @Description
 * The soldiers in special group are standing in a circle waiting to be executed. 
 * The soldiers are numbered from 0. At first, the soldier numbered 0 is the leader. 
 * For each round of the game, counting begins at the next soldier after the leader in the circle 
 * and proceeds around the circle in clock-wise direction. 
 * After k-1 soldiers are counted, the next person is removed from that circle. 
 * And the next person after the removed soldier becomes the new leader. 
 * The procedure is repeated with the remaining soldiers, starting with the next leader, until only one soldier remains. 
 * The remained soldier is spy.
 * 
 * @Input
 * First line will be a positive integer T (T<=10), which is the number of messages.
 * For each message, the line will be n and k, the number of soldiers and the counting number. (1 <= n <= 100, 1 <= k <= 100)
 *  
 *  @Output
 *  For each message, print the number of the last soldier.
 */

package lab3;

import java.util.LinkedList;
import java.util.Scanner;

public class D_FindSpy {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int cases = cin.nextInt();
		for (int count = 0; count < cases; ++count) {
			int soldiers_number = cin.nextInt();
			int counting_number = cin.nextInt();
			LinkedList<Integer> soldiers = new LinkedList<>();
			for (int i = 0; i < soldiers_number; ++i)
				soldiers.add(i);
			int leader = 0;
			while (soldiers.size() > 1) {
				leader = (leader + counting_number) % soldiers.size();
				soldiers.remove(leader);
			}
			System.out.println(soldiers.get(0));
		}
		cin.close();
	}

}
