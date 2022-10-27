package edu.klein;

import java.text.ParseException;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class LeetCodeEasyLg50PercentTest {

    LeetCodeEasyLg50Percent lg50Percent;

    @Before
    public void init() {
        lg50Percent = new LeetCodeEasyLg50Percent();
    }


    @Test
    public void commonTest() {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] shuffle = lg50Percent.shuffle(nums, n);
        Arrays.stream(shuffle).forEach(s -> System.out.print(s + " "));
    }

    @Test
    public void testNumIdenticalPairs() {
//        int[] nums = {1,2,3,1,1,3};
        int[] nums = {1, 2, 3, 1, 1, 1, 1};
        int i = lg50Percent.numIdenticalPairs(nums);
    }

    @Test
    public void testBalancedStringSplit() {
        int rllllrrrlr = lg50Percent.balancedStringSplit("RLLLLRRRLR");
        System.out.println(rllllrrrlr);
    }


}
