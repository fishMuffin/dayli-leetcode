package edu.klein;

import edu.klein.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
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
    void testReverseWords() {
        String s = "Let's take LeetCode contest";
        String s1 = new leetCode().reverseWords(s);
        System.out.println(s1);
    }

    @Test
    void testMajorityElement() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int i = new leetCode().majorityElement(nums);
        System.out.println(i);
    }

    @Test
    void testMoveZeroes() {
//        int[] nums = {0,1,0,3,12};
        int[] nums = {2, 1};
        new leetCode().moveZeroes(nums);
    }

    @Test
    void testFindDisappearedNumbers() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = new leetCode().findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }

    @Test
    void testSingleNumber() {
//        int[] nums = {1, 2, 1, 2, 4};
        int[] nums = {-10, -9, -8, -7,};
        int i = new leetCode().singleNumber(nums);
        System.out.println(i);
    }

    @Test
    void testGenerateParenthesis() {
        int i = 3;
        List<String> strings = new leetCode().generateParenthesis(i);
        System.out.println(strings);
    }

    @Test
    void testPlusOne() {
//        int[] nums={4,3,2,1};
        int[] nums = {9, 9, 9, 9};
        int[] ints = new leetCode().plusOne(nums);
        System.out.println(ints);

    }

    @Test
    void testIsHappy() {
//        int i=19;
        int i = 2;
        boolean happy = new leetCode().isHappy(i);
        System.out.println(happy);
    }

    @Test
    void testContainsDuplicate() {
//        int[] nums={1,1,1,3,3,4,3,2,4,2};
//        int[] nums={-24500,-24499,-24498,4,3,2,4,2};
        int[] nums = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean b = new leetCode().containsDuplicate(nums);
        System.out.println(b);
    }

    @Test
    void testMergeTwoLists() {
//        l1 = [1,2,4], l2 = [1,3,4]
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = new leetCode().mergeTwoLists2(l1, l2);
        System.out.println(listNode);
    }

    @Test
    void testMissingNumber() {
        int[] nums = {3, 0, 1};
        int i = new leetCode().missingNumber(nums);
        System.out.println(i);
    }

    @Test
    void testFirstUniqChar() {
        String s = "loveleetcode";
        int i = new leetCode().firstUniqChar(s);
        System.out.println(i);
    }

    @Test
    void testFizzBuzz() {
        int n = 15;
        List<String> strings = new leetCode().fizzBuzz(n);
        strings.forEach(s -> System.out.println(s));
    }

    @Test
    void testIntersect() {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] intersect = new leetCode().intersect(nums1, nums2);
        System.out.println(intersect);
    }

    @Test
    void testIsAnagram() {
        String s = "anagram", t = "nagaram";
        boolean anagram = new leetCode().isAnagram(s, t);
        System.out.println(anagram);
    }

    @Test
    void testIsPalindromeStr() {
//        String s="A man, a plan, a canal: Panama";
        String s = "0P";
        boolean palindrome = new leetCode().isPalindrome(s);
        System.out.println(palindrome);
    }

    @Test
    void testMerge() {
//        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
//        int m = 3, n = 3;
//        int[] nums1 = {0},nums2 = {1};
//        int m = 0, n = 1;
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 5, 6};
        int m = 1, n = 5;
        new leetCode().merge(nums1, m, nums2, n);
    }

    @Test
    void testTitleToNumber() {
//        String columnTitle = "ZY";
        String columnTitle = "FXSHRXW";
        int i = new leetCode().titleToNumber(columnTitle);
        System.out.println(i);
    }

    @Test
    void testThirdMax() {
        int[] nums = {2, 2, 3, 1};
        int i = new leetCode().thirdMax(nums);
        System.out.println(i);
    }

    @Test
    void testCountSegments() {
//        String s="Hello, my name is John";
//        String s=", , , ,        a, eaefa";
        String s = "         ";
        int i = new leetCode().countSegments(s);
        System.out.println(i);
    }

    @Test
    void testValidPalindrome() {
//        String s = "abca";
//        String s = "abc";
//        String s = "tcaac";
//        String s = "teee";
//        String s = "cbbcc";
//        String s = "eedede";
//        String s = "hbakab";
//        String s = "pidbliassaqozokmtgahluruufwbjdtayuhbxwoicviygilgzduudzgligyviciowxbhuyatdjbwfuurulhagtmkozoqassailbdip";
        String s = "aba";
        boolean b = new leetCode().validPalindrome(s);
        System.out.println(b);

    }

    @Test
    void testMaxRepeating() {
//        String sequence = "ababc", word = "ba";
//        String sequence = "ababc", word = "ab";
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";

        int i = new leetCode().maxRepeating1(sequence, word);
        System.out.println(i);
    }

    @Test
    void testContainsNearbyDuplicate() {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        boolean b = new leetCode().containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }


    @Test
    void commonTest() {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println("abca".replace("c", ""));
        System.out.println((int) ' ');
        System.out.println("ZY".charAt(1) - 64);
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) '1');
        System.out.println((int) '9');
    }
}
