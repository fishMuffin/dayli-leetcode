package edu.klein;

import java.text.ParseException;
import java.util.Arrays;
import org.junit.Test;

public class LeetCodeEasyLg50PercentTest {

    @Test
    public void commonTest() {
        LeetCodeEasyLg50Percent lg50Percent = new LeetCodeEasyLg50Percent();
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        int[] shuffle = lg50Percent.shuffle(nums, n);
        Arrays.stream(shuffle).forEach(s-> System.out.print(s+" "));
    }

    @Test
    public void testNumIdenticalPairs(){
        LeetCodeEasyLg50Percent lg50Percent = new LeetCodeEasyLg50Percent();
//        int[] nums = {1,2,3,1,1,3};
        int[] nums = {1,2,3,1,1,1,1};
        int i = lg50Percent.numIdenticalPairs(nums);
    }


}
