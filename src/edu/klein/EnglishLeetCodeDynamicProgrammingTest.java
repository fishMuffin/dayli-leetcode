package edu.klein;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class EnglishLeetCodeDynamicProgrammingTest {

    EnglishLeetCodeDynamicProgramming instance;


    @Before
    public void init() {
        instance = new EnglishLeetCodeDynamicProgramming();
    }

    @Test
    public void testMaxSumAfterPartitioning() {
        int i = instance.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4);
        System.out.println(i);
    }

    @Test
    public void testGenerateParenthesis() {
//        List<String> strings1 = instance.generateParenthesis1(3);
        List<String> list = new ArrayList<>();
        instance.geneParen(new char[6], 0, list);
        System.out.println("s");
//        List<String> strings = instance.generateParenthesis_myself(3);

    }

    @Test
    public void testCountBits() {
        int[] ints = instance.countBits(5);
        int[] ints1 = instance.countBits_my(5);
        System.out.println(ints);
    }

    @Test
    public void testCountVowelStrings() {
//        int i = instance.countVowelStrings(2);
        int i1 = instance.countVowelStrings_second(3);
        int i = instance.countVowelStrings_math2(3);
        System.out.println(i);
    }
}
