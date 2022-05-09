package edu.klein;

import org.junit.jupiter.api.Test;

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
    void subStringTest() {
        String s = "MCMCMXCIV"; //1994
        String str = "CM";
        String cm1 = s.replaceFirst("CM", "");
        System.out.println(cm1);
        String substring = s.substring(1, 3);
        String substring1 = s.substring(2);
        String substring2 = s.substring(3);
        System.out.println(substring);
        System.out.println(substring1);
        System.out.println(substring2);
//        int res = 0;
//        Map<String, Integer> mapSpecial = new LinkedHashMap<>();
//        mapSpecial.put("CM", 900);
//        mapSpecial.put("CD", 400);
//        mapSpecial.put("XC", 90);
//        mapSpecial.put("XL", 40);
//        mapSpecial.put("IX", 9);
//        mapSpecial.put("IV", 4);
//        String[] strList = {};
//        String[] strings = mapSpecial.keySet().toArray(strList);
//        for (int i = 0; i < strings.length; i++) {
//            String key = strings[i];
//            if (s.length() < key.length()) break;
//            if (s.contains(key)) {//MCMXCIV->MXCIV
//                s = s.substring(s.indexOf(key), key.length());
////                s.substring()
//
//
//                res += mapSpecial.get(key);
//                i = 0;
//            }
//        }
//        s.substring()
    }
}
