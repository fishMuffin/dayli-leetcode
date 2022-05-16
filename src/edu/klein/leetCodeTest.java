package edu.klein;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


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

    @Test
    void testAllCellsDistOrder() {
        int[][] ints = new leetCode().allCellsDistOrder(2, 3, 1, 2);
//        int[][] ints = new leetCode().allCellsDistOrder1(2, 3, 1, 2);
        System.out.println(ints);
    }


    @Test
    void testCountCharacters() {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        int i = new leetCode().countCharacters(words, chars);
        System.out.println(i);
    }

    @Test
    void testIsBoomerang() {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        boolean boomerang = new leetCode().isBoomerang(points);
        System.out.println(boomerang);
    }

    @Test
    void testIsPalindrome() {
        boolean palindrome = new leetCode().isPalindrome(12345321);
        System.out.println(palindrome);
    }


    @Test
    public void testBubleSort() {
        int[] nums = {1, 7, 5, 3, 2};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        output(nums);
    }

    @Test
    void testRomanToInt() {
//        String s = "XLIII";
        String s = "MCMXCIV"; //1994
        int i = new leetCode().romanToInt1(s);
        System.out.println(i);
    }

    public void output(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    @Test
    void testLongestCommonPrefix() {
//        String str=""
//                ["flower","flow","flight"]
//        String[] strs = {"flower", "flow", "flight"};
//        ["ab", "a"]
//        String[] strs = {""};
        String[] strs = {"ab", "a"};
//        String[] strs = {"flower", "flower","flower","flower"};
        String s = new leetCode().longestCommonPrefix(strs);
        System.out.println(s);
    }

    @Test
    void testIsValid() {
        String str = "()[]{}";
        boolean valid = new leetCode().isValid(str);
        System.out.println(valid);
    }

    @Test
    void testRemoveDuplicates() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = new leetCode().removeDuplicates(nums);
        System.out.println(i);
    }

    @Test
    void testRemoveElement() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums = {3, 2, 2, 3};
//        int[] nums = {4, 5};
        int val = 2;
//        int val = 3;
//        int val = 5;
        int i = new leetCode().removeElement(nums, val);
        System.out.println(i);
    }

    @Test
    void testStrStr() {
//        String haystack = "hello";
//        String needle = "llo";
        String haystack = "mississippi";
        String needle = "issip";
        int i = new leetCode().strStr(haystack, needle);
        System.out.println(i);
    }

    @Test
    void testSearchInsert() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int i = new leetCode().searchInsert(nums, target);
        System.out.println(i);
    }

    @Test
    void testMaxSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {5,4,-1,7,8};
//        int[] nums = {-2,1};
        int i = new leetCode().maxSubArray(nums);
        System.out.println(i);
    }

    @Test
    void testGcdOfStrings() {
//        String str1 = "ABABABAB";
//        String str2 = "ABABAB";
//        String str1 = "ABCDEF";
//        String str2 = "ABC";
//        String str1 = "LEET";
//        String str2 = "CODE";
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
//        String str1 = "AAAAAAAAA";
//        String str2 = "AAACCC";
        String s = new leetCode().gcdOfStrings(str1, str2);
        System.out.println(s);
    }

    @Test
    void testFindOcurrences() {
        String text = "alice is a good girl she is a good student";
        String first = "a", second = "good";
        String[] ocurrences = new leetCode().findOcurrences(text, first, second);
        Arrays.stream(ocurrences).forEach(s -> System.out.println(s));
    }

    @Test
    void testHeightChecker() {
        int[] nums = {1, 1, 4, 2, 1, 3};
        int i = new leetCode().heightChecker(nums);
        System.out.println(i);
    }

    @Test
    void testReverseString() {
        char[] s = {'H', 'e', 'l', 'l', 'o'};
        new leetCode().reverseString(s);
    }
    @Test
    void testReverseWords(){
        String s = "Let's take LeetCode contest";
        String s1 = new leetCode().reverseWords(s);
        System.out.println(s1);
    }


    @Test
    void commonTest() {
        String s = "()[]{}";
        byte[] bytes = s.getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }
}
