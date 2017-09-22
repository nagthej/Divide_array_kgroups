/*From the given permutaions of numbers, we are trying to find a group 
where the sum in all groups should be equal */ 

/*Algorithm for the problem: If we have to divide into k groups, if the total sum is 'sum', 
then each groups sum should be (sum / k). so here we are trying to find the groups. 
so basically if we generate all the permutations of an array, 
and for each array start putting elements in one group 
and start a new group as soon as the sum reaches (sum / k) */

/* If the function returns true for even one of the permutation then the answer is true 
(Yes It is possible to divide into k groups). */

package com.nagthej.examples;

import java.util.ArrayList;
import java.util.List;

public class ArraySumGrpK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(7);
		
		System.out.println(separate(list, 2));

	}

	public static boolean separate(List<Integer> list, int k) {
		boolean result = false;

		int kSum = 0;
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}

		if (sum % k == 0) {
			kSum = sum / k;
			boolean[] visited = new boolean[list.size()];
			int[] grpSum = new int[k];

			grpSum[0] = list.get(list.size() - 1);
			visited[list.size() - 1] = true;
			result = isGrpPossible(list, k, grpSum, visited, kSum, list.size(),
					0, list.size() - 1);

		}

		return result;
	}

	public static boolean isGrpPossible(List<Integer> list, int k,
			int[] grpSum, boolean[] visited, int kSum, int n, int curIndex,
			int limitIndex) {

		if (grpSum[curIndex] == kSum) {

			if (curIndex == k - 2)
				return true;

			return isGrpPossible(list, k, grpSum, visited, kSum, n,
					curIndex + 1, n - 1);

		}

		for (int i = limitIndex; i >= 0; i--) {

			if (visited[i]) {
				continue;
			}

			int tmp = grpSum[curIndex] + list.get(i);

			if (tmp <= kSum) {

				visited[i] = true;
				grpSum[curIndex] += list.get(i);

				boolean result = isGrpPossible(list, k, grpSum, visited, kSum,
						n, curIndex, i - 1);

				visited[i] = false;
				grpSum[curIndex] -= list.get(i);

				if (result) {
					return true;
				}

			}
		}

		return false;

	}

}
