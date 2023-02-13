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

    @Test
    public void testMaxProfit() {
        int[] list1 = {7, 1, 5, 3, 6, 4, 2, 10};
        int[] list2 = {7, 6, 4, 3, 1};
        int[] list3 = {2, 4, 1};
//        assert lg50Percent.maxProfit(list1) == 5 : "list1";
        int i1 = lg50Percent.maxProfit_self2(list1);
        System.out.println(i1);
//        int i2 = lg50Percent.maxProfit(list2);
//        System.out.println(i2);
//        int i3 = lg50Percent.maxProfit(list3);
//        System.out.println(i3);
    }


}
