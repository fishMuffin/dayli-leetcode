package edu.klein;

import org.junit.jupiter.api.Test;


class leetCodeTest {

	@Test
	public void testTowSum() {
//		int[] nums = new int[]{2, 7, 11, 15};
//		int target = 9;
//		int[] nums = new int[]{3,2,4};
//		int target = 6;
		int[] nums = new int[]{3, 3};
		int target = 6;
		int[] res = new edu.klein.leetCode().twoSum(nums, target);
		output(res);
	}

	@Test
	public void testDivisorGame() {
		boolean b = new edu.klein.leetCode().divisorGame(3);
		System.out.println(b);
	}

	public void output(int[] res) {
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
