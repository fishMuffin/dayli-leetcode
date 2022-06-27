package edu.klein;

import edu.klein.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    void testCheckPerfectNumber() {
        int num = 28;
        boolean b = new leetCode().checkPerfectNumber(num);
        System.out.println(b);
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
    void testWordPattern() {
//        String pattern = "abba", str = "dog cat cat dog";
//        String pattern = "abba", str = "dog dog dog dog";
//        String pattern = "a", str = "a";

        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        boolean b = new leetCode().wordPattern1(pattern, str);
        boolean b2 = new leetCode().wordPattern2(pattern, str);
        System.out.println(b);
        System.out.println(b2);
    }

    @Test
    void testArrayRankTransform() {
        int[] arr = {40, 10, 20, 30};
//        int[] arr = {40, 40, 40, 40};
//        int[] arr = {37,12,28,9,100,56,80,5,12};
//        int[] arr = {100,100,100};
//        int[] arr = {-43};
//        int[] arr = {27,46,-3,-36,31,-14,-7,-36,27,-14,41,-40,23};
        int[] ints = new leetCode().arrayRankTransform(arr);
        Arrays.stream(ints).forEach(s -> System.out.println(s));
    }

    @Test
    void testSecondHighest() {
//        String s = "dfa12321afd";
        String s = "abc1111";
//        String s = "ck077";
        int i = new leetCode().secondHighest(s);
        System.out.println(i);
    }

    @Test
    void testIsIsomorphic() {
        leetCode leetCode = new leetCode();
//        assert leetCode.isIsomorphic("egg", "add"):"1";
        assert leetCode.isIsomorphic("abab", "baba") : "2";
//        assert !leetCode.isIsomorphic("badc", "baba"):"3";
//        assert !leetCode.isIsomorphic("papap", "titii"):"4";
//        assert leetCode.isIsomorphic("a", "a"):"5";
//        assert leetCode.isIsomorphic("13", "42"):"6";
    }


    @Test
    void testModifyString() {
        String s1 = new leetCode().modifyString("ubv?w");
        String s2 = new leetCode().modifyString("ubva?");
        String s3 = new leetCode().modifyString("?bvaw");
        String s4 = new leetCode().modifyString("?s??");
        String s5 = new leetCode().modifyString("?");
        System.out.println(s1);
    }

    @Test
    void assertTest() {
        leetCode leetCode = new leetCode();
        int[] list = {0, 1, 2, 4, 5, 7};
        int[] list2 = {0,2,3,4,6,8,9};
        int[] list3 = {-2147483648,-2147483647,2147483647};
        leetCode.summaryRanges(list3);

//        int[] list = {-1, 0, 3, 5, 9, 12};
//        assert leetCode.search(list, 9) == 4 : "list";

//        int[] list = {1, 1, 5, 2, 3};
//        assert leetCode.largestPerimeter(list)==0 : "list";
        //        int[] list = {5, 5, 5, 10, 20};
//        assert leetCode.lemonadeChange(list) : "list";

//        int[] list = {2, 4, 1, 1, 6, 5};
//        int[] list2 = {6,6,5,5,4,1};
//        int[] list3 = {8,2,5,7,7,2,10,3,6,2};
//        assert leetCode.countHillValley(list) == 3 : "list";
//        assert leetCode.countHillValley(list2) == 0 : "list2";
//        assert leetCode.countHillValley(list3) == 6 : "list3";

//        String[] list = {"z"};
//        String[] list2 = {"a","a","a","a","a","a","a","a"};
////        assert leetCode.isPrefixString("z",list) : "z";
//        assert leetCode.isPrefixString("aaaaaaa",list2) : "aaaaaaa";

//        String[] list1_1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list1_2 = {"KFC", "Shogun", "Burger King"};
//        String[] list2_1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2_2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
//        String[] list3_1 = {"Shogun","Tapioca Express","Burger King","KFC"};
//        String[] list3_2 = {"KFC","Burger King","Tapioca Express","Shogun"};
////        leetCode.findRestaurant(list1_1, list1_2);
//        for (String s : leetCode.findRestaurant(list3_1, list3_2)) {
//            System.out.println(s);
//        }

//        assert leetCode.thousandSeparator(123456).equals("123.456") : "123456";
//        assert leetCode.thousandSeparator(1234567).equals("1.234.567") : "1234567";
//        assert leetCode.thousandSeparator(123).equals("123") : "123";
//        assert leetCode.thousandSeparator(12).equals("12") : "12";

//        assert leetCode.detectCapitalUse("leetcode") : "leetcode";
//        assert leetCode.detectCapitalUse("ABC") : "ABC";
//        assert leetCode.detectCapitalUse("Az") : "Az";
//        assert !leetCode.detectCapitalUse("AzA") : "AzA";

//        assert leetCode.areAlmostEqual("abcd", "dbca") : "abcd";
//        assert !leetCode.areAlmostEqual("abcd", "dcba") : "dcba";

//        int[] nums1 = {12,23,36,46,62};
//        int[] nums2 = {9,29,49,50};
//        int[] nums3 = {10,20,21,22,23,33,43,45,46,47};
//        int[] nums4 = {10,20,21,22,23,33,43,45,46,47,57,67};
//        assert leetCode.slowestKey(nums1,"spuda") == 'a' : "nums1";
//        assert leetCode.slowestKey(nums2,"cbcd") == 'c' : "nums2";
//        assert leetCode.slowestKey(nums3,"aeodzyabcd") == 'y' : "nums3";
//        assert leetCode.slowestKey(nums4,"aeodzyabcdxk") == 'y' : "nums4";

//        int[] nums1 = {6, 2, 2, 3, 6};
//        int[] nums2 = {11,7,2,15};
//        assert leetCode.countElements(nums1) == 1 : "nums1";
//        assert leetCode.countElements(nums2) == 2 : "nums2";

//        int[] nums1 = {1, 2, 3, 3, 4};
//        int[] nums2 = {1, 2, 3, 2, 4};
//        int[] nums3 = {4, 3, 3, 2, 2};
//        int[] nums4 = {2};
//        int[] nums5 = {5, 3, 2, 4, 1};
//        assert leetCode.isMonotonic(nums1) : "nums1";
//        assert !leetCode.isMonotonic(nums2) : "nums2";
//        assert leetCode.isMonotonic(nums3) : "nums3";
//        assert leetCode.isMonotonic(nums4) : "nums4";
//        assert !leetCode.isMonotonic(nums5) : "nums5";

//        assert leetCode.numDifferentIntegers("a1b01c001")==1 : "a1b01c001";
//        assert leetCode.numDifferentIntegers("a123bc34d8ef34")==3 : "a123bc34d8ef34";
//        assert leetCode.numDifferentIntegers("leet1234code234")==2 : "leet1234code234";
//        assert leetCode.numDifferentIntegers("gi851a851q8510v")==2 : "gi851a851q8510v";
//        assert leetCode.numDifferentIntegers("0a0") == 1 : "0a0";

//        int[] arr1 = {1, 2, 3, 4, 4, 3, 2, 1};
//        int[] arr2 = {1, 1, 1, 2, 2, 2, 3, 3};
//        int[] arr3 = {1, 1, 2, 2, 2, 2, 3, 3};
//        int[] arr4 = {0,0,1,1,1,1,2,2,3,4};
//        int[] arr5 = {1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3};
//        assert leetCode.hasGroupsSizeX(arr1) : "arr1";
//        assert !leetCode.hasGroupsSizeX(arr2) : "arr2";
//        assert leetCode.hasGroupsSizeX(arr3) : "arr3";
//        assert !leetCode.hasGroupsSizeX(arr4) : "arr4";
//        assert !leetCode.hasGroupsSizeX(arr5) : "arr5";


//        assert leetCode.buddyStrings("cbad", "abcd") : "cbad";
//        assert !leetCode.buddyStrings("ab", "ab") : "ab";
//        assert leetCode.buddyStrings("aa", "aa") : "aa";
//        assert leetCode.buddyStrings("ab", "ba") : "ab";
//        assert leetCode.buddyStrings("abab", "abab") : "abab";
//        assert !leetCode.buddyStrings("abcd", "abcde") : "abcd";

//        int[] arr1 = {1, 0, 0, 0, 0, 0, 0, 0, 1};
//        int[] arr2 = {1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1};
//        int[] arr3 = {0, 0, 1, 0, 1};
//        int[] arr4 = {0};
//        int[] arr5 = {1};
//        assert leetCode.canPlaceFlowers(arr1, 2) : "arr1";
//        assert leetCode.canPlaceFlowers(arr2, 2) : "arr2";
//        assert leetCode.canPlaceFlowers(arr3, 1) : "arr3";
//        assert leetCode.canPlaceFlowers(arr4, 1) : "arr4";
//        assert !leetCode.canPlaceFlowers(arr5, 1) : "arr5";

//        int[] arr1 = {1, 2, 10, 5, 7};
//        int[] arr2 = {2,3,1,2};
//        int[] arr3 = {2,2,2};
//        int[] arr4 = {105,924,32,968};
//        int[] arr5 = {1,2,3};
//        assert leetCode.canBeIncreasing(arr1) : "arr1";
//        assert !leetCode.canBeIncreasing(arr2) : "arr2";
//        assert !leetCode.canBeIncreasing(arr3) : "arr3";
//        assert leetCode.canBeIncreasing(arr4) : "arr4";
//        assert leetCode.canBeIncreasing(arr5) : "arr5";


//        assert leetCode.maximumTime("2?:?0").equals("23:50") : "2?:?0";
//        assert leetCode.maximumTime("0?:3?").equals("09:39") : "0?:3?";
//        assert leetCode.maximumTime("1?:22").equals("19:22") : "1?:22";
//        assert leetCode.maximumTime("?1:2?").equals("21:29") : "?1:2?";

//        int[] arr1 = {5,1,2,1,2,1,1,1,3};
//        int[] arr2 = {1,2,4,4,4,4};
//        int[] arr3 = {1,2,1,2,1,3};
//        int[] arr4 = {2,2};
//        int[] arr5 = {2,2,1,2,2,1,1,1,2,1};
//        assert leetCode.containsPattern(arr1,2,2) : "arr1";
//        assert leetCode.containsPattern(arr2,1,3) : "arr2";
//        assert !leetCode.containsPattern(arr3,2,3) : "arr3";
//        assert leetCode.containsPattern(arr4,1,2) : "arr4";
//        assert !leetCode.containsPattern(arr5,2,2) : "arr5";

//        int[] arr1 = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
//        int[] arr2 = {0,2,1,-6,6,7,9,-1,2,0,1};
//        int[] arr3 = {1,-1,1,-1};
//        int[] arr4 = {0,0,0,0};
//        int[] arr5 = {10,-10,10,-10,10,-10,10,-10};
//        int[] arr6 = {-7,57,-76,5,51,-57,27,83,68,39,-38,43,-79,42,-79,72,-58,-29,-34,23,20,-67,-67,74,10,-90,-91,41,22,-12,-75,-3,51,13,9,58,72,-3,48,-28,78,15,13,22,-68,62,33,-18,21,-2,56,41,27,-33,-35,-36,-6,-73,-9,-45,-16,4,51,-54,-92,79,-92,-12,-9,39,1,-60,78,16,-77,-45,26,-43,44,-21,-27,74,-68,-58,22,52,100,37,48,99,98,-34,36,25,-85,83,99,-64,-37,20,0,13,85,18,98,-91,86,-94,-92,-42,-82,89,67,-13,43,11,75,67,-38,-79,-3,-24,83,-1,74,-93,26,-69,92,40,-32,-89,-100,-36,80,9,92,79,-83,90,-8,-77,1,-60,100,63,87,-51,-33,17,24,-73,-81,-86,52,59,10,-84,-71,-12,24,-53,-14,-44,-48,-91,-57,-82,-5,48,-56,-92,83,-64,-17,-46,65,-15,87,-61,-29,79,-53,-81,-58,70,70,-12,-71,68,-57,-44,-18,-94,-84,7,-51,18,44,96,24,8,61,36,-83,-93,38,82,25,4,37,93,-5,24,-9,-31,15,-73,-91,-36,41,56,-17,3,-94,-26,96,5,-21,-20,60,-53,26,2,-97,41,-72,-29,-83,32,35,-29,82,-38,-15,81,-10,50,22,26,30,-31,74,-74,47,66,53,35,-58,-68,47,-21,78,12,-88,1,12,53,94,1,-43,-36,67,6,-89,44,-86,-22,48,-12,72,-90,-7,-92,30,-17};
//
//        assert leetCode.canThreePartsEqualSum(arr1) : "0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1";
//        assert !leetCode.canThreePartsEqualSum(arr2) : "0,2,1,-6,6,7,9,-1,2,0,1";
//        assert !leetCode.canThreePartsEqualSum(arr3) : "1,-1,1,-1";
//        assert leetCode.canThreePartsEqualSum(arr4) : "0,0,0,0";
//        assert leetCode.canThreePartsEqualSum(arr5) : "10,-10,10,-10,10,-10,10,-10";
//        assert leetCode.canThreePartsEqualSum(arr6) : "arr6";


//        assert leetCode.convertToTitle(701).equals("ZY") : "701";
//        assert leetCode.convertToTitle(2147483647).equals("FXSHRXW") : "2147483647";
//        assert leetCode.reorderSpaces(" practice   makes   perfect").equals("practice   makes   perfect ") : " practice   makes   perfect";
//        assert leetCode.reorderSpaces("  this   is  a sentence ").equals("this   is   a   sentence") : "  this   is  a sentence ";
//        assert leetCode.reorderSpaces("  hello").equals("hello  ") : "  hello";

//        int[] arr1 = {10,2,5,3};
//        int[] arr2 = {3,1,7,11};
//        int[] arr3 = {-2,0,10,-19,4,6,-8};
//        assert leetCode.checkIfExist(arr1) : "10,2,5,3";
//        assert !leetCode.checkIfExist(arr2) : "3,1,7,11";
//        assert !leetCode.checkIfExist(arr3) : "-2,0,10,-19,4,6,-8";

//        assert leetCode.checkOnesSegment("1000000") : "1000000";
//        assert leetCode.checkOnesSegment("110") : "110";
//        assert !leetCode.checkOnesSegment("1001") : "1001";
//        assert !leetCode.checkOnesSegment("101101000") : "101101000";


//        assert leetCode.lengthOfLastWord("luffy is still joyb1oy  ")==5 : "luffy is still joyb1oy  ";
//        assert leetCode.lengthOfLastWord("luffy is still joyboy  ")==6 : "luffy is still joyboy  ";
//        assert leetCode.lengthOfLastWord("luffy is still joyb1oy  sd1 ")==5 : "luffy is still joyb1oy  sd1 ";
//        assert leetCode.countValidWords("alice and  bob are playing stone-game10")==5 : "alice and  bob are playing stone-game10";
//        assert leetCode.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.")==6 : "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.";
////        assert leetCode.countValidWords(". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5")==4 : ". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5";
////        assert leetCode.countValidWords("fzdej0s mss!v  u.0!  3c,i!,h3p63 nk   ipyz-9 - vn1 vk50u")==1 : "fzdej0s mss!v  u.0!  3c,i!,h3p63 nk   ipyz-9 - vn1 vk50u";
//        assert leetCode.countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif ")==49 : " 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif ";


//        assert leetCode.isLongPressedName("alex", "aaleex") : "alex-aaleex";
//        assert !leetCode.isLongPressedName("saeed", "ssaaedd") : "saeed-ssaaedd";


//        int[] banned = {1, 2, 2, 4, 5, 6, 7};
//        int[] banned = {2, 2};
//        int[] banned = {1, 1};
//        int[] banned = {3, 2, 3, 4, 6, 5};
//        int[] errorNums = leetCode.findErrorNums(banned);
//        for (int i = 0; i < errorNums.length; i++) {
//            System.out.println(errorNums[i]);
//        }

//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String [] banned1 = {"hit"};
//        String paragraph1 = "Bob!";
//        String [] banned2 = {"a"};
//        String paragraph2 = "a, a, a, a, b,b,b,c, c";
//        String [] banned3 = {"m","i","s","w","y","d","q","l","a","p","n","t","u","b","o","e","f","g","c","x"};
//        String paragraph3 = "L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' y! Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'";
//        assert leetCode.mostCommonWord(paragraph,banned).equals("ball") : "ball";

//        assert leetCode.mostCommonWord(paragraph1,banned1).equals("bob") : "bob";
//        assert leetCode.mostCommonWord(paragraph2,banned2).equals("b") : "b";
//        assert leetCode.mostCommonWord(paragraph3,banned3).equals("z") : "z";

//        assert leetCode.arrangeCoins(8)==3 : "8";
//        assert leetCode.arrangeCoins(5)==2 : "5";
//        assert leetCode.arrangeCoins(3)==2 : "3";
//        assert leetCode.arrangeCoins(10)==4 : "10";
////        System.out.println(leetCode.arrangeCoins(1000));
//        System.out.println(leetCode.arrangeCoins(1804289383));
//        assert leetCode.arrangeCoins(10)==4 : "10";


//        assert leetCode.firstBadVersion(1)==1 : "5";
//        assert leetCode.firstBadVersion(5)==4 : "5";
//        assert leetCode.firstBadVersion(4)==1 : "4";
//        assert leetCode.firstBadVersion(2126753390)==1702766719 : "4";
//        assert leetCode.firstBadVersion(2)==2 : "2";

//        assert leetCode.findMaxAverage(nums1,4)==12.75 : "0,3,2,1";
//        int[] nums1 = {0,3,2,1};
//        int[] nums2 = {0,3,3};
//        int[] nums3 = {0,3};
//        int[] nums4 = {0,1,2,4,2,1};
//        int[] nums5 = {0,1,2,1,2,1};
//        int[] nums6 = {0,1,2,3,4,5};
//        assert leetCode.validMountainArray(nums1) : "0,3,2,1";
//        assert !leetCode.validMountainArray(nums2) : "0,3,3";
//        assert !leetCode.validMountainArray(nums3) : "0,3";
//        assert leetCode.validMountainArray(nums4) : "0,1,2,4,2,1";
//        assert !leetCode.validMountainArray(nums5) : "0,1,2,1,2,1";
//        assert !leetCode.validMountainArray(nums6) : "0,1,2,3,4,5";
//        assert !leetCode.validMountainArray1(nums6) : "0,1,2,3,4,5";
//        assert leetCode.validMountainArray1(nums4) : "0,1,2,3,4,5";


//        int[] nums={-4,-2,1,4,8};
//        int[] nums1={2,-1,1};
//        int[] nums2={-10,-12,-54,-12,-544,-10000};
//        assert leetCode.findClosestNumber(nums)==1 : "-4,-2,1,4,8";
//        assert leetCode.findClosestNumber(nums1)==1 : "2,-1,1";
//        assert leetCode.findClosestNumber(nums2)==-10 : "-10,-12,-54,-12,-544,-10000";
//        assert leetCode.reverseVowels("leetcode").equals("leotcede") : "leetcode";
//        assert leetCode.reverseVowels("hello").equals("holle") : "hello";
//        assert leetCode.reverseVowels("aA").equals("Aa") : "aA";

//        assert !leetCode.isUgly(14) : "isUgly:14";
//        assert leetCode.isUgly(6) : "isUgly:6";
//        assert leetCode.isUgly(1) : "isUgly:1";
//        assert leetCode.isUgly(8) : "isUgly:8";


//        char[] letters={'c', 'f', 'j'};
//        assert 'f'==leetCode.nextGreatestLetter(letters, 'c') : letters;
//        char[] letters1={'e', 'e', 'n','n'};
//        assert 'e'==leetCode.nextGreatestLetter(letters1, 'n') : letters1;


//        assert leetCode.repeatedSubstringPattern("abcabcabcabc") : "abcabcabcabc";
//        assert !leetCode.repeatedSubstringPattern("aba") : "aba";
//        assert leetCode.repeatedSubstringPattern("ababab") : "ababab";
//        assert !leetCode.repeatedSubstringPattern("ababba") : "ababba";
//        assert leetCode.repeatedSubstringPattern("babbabbabbabbab") : "babbabbabbabbab";
//        assert leetCode.repeatedSubstringPattern("abab") : "abab";
//        assert leetCode.repeatedSubstringPattern("bb") : "bb";
//        assert leetCode.repeatedSubstringPattern("zzz") : "zzz";
//        assert !leetCode.repeatedSubstringPattern("zza") : "zza";
//        assert leetCode.repeatedSubstringPattern("aaaaaaaaaaaaa") : "aaaaaaaaaaaaa";
//        assert leetCode.backspaceCompare("ab##","c#d#") : "1";
//        assert leetCode.backspaceCompare("ab#c","ad#c") : "2";
//        assert !leetCode.backspaceCompare("a#c","b") : "3";
//        assert leetCode.longestWord((String[]) Arrays.asList("a", "banana", "app", "appl", "ap", "apply", "apple").toArray())=="apple" : "apple";
//        assert leetCode.reformat("a0b1c2")=="a0b1c2" : "a0b1c2";
//        assert leetCode.reformat("covid2019")=="a0b1c2" : "covid2019";
//        assert leetCode.reformat1("covid2019")=="a0b1c2" : "covid2019";
//        assert leetCode.reformat2("covid2019")=="a0b1c2" : "covid2019";
//        assert leetCode.reformat2("ab123")=="1a2b3" : "ab123";
//        assert leetCode.reformat2("619mama")=="1a2b3" : "619mama";

//        int[] list = {1, 2, 3, 4, 5};
//        int[] list2 = {-100, -98, -1, 2, 3, 4};
//        assert leetCode.maximumProduct(list) == 60 : "12345";
//        assert leetCode.maximumProduct(list2) == 39200 : "39200";
//        int[] list = {1,3,5,4,5,6,7,1,2,3,4,5,6};
//        assert leetCode.findLengthOfLCIS(list) == 6 : "13547";

//        assert leetCode.maxScore("011101") == 5 : "011101";
//        assert leetCode.maxScore("00111") == 5 : "00111";
//        assert leetCode.maxScore("1111") == 3 : "1111";
//        assert leetCode.maxScore("000") == 2 : "000:"+leetCode.maxScore1("000");


    }

    @Test
    void commonTest() {
//        Pattern compile = Pattern.compile("[0-9]*");
//        Matcher m = compile.matcher("gi851a851q8510v");
//        int count = 0;
//        while (m.find()) {
//            count++;
//            System.out.println(count);
//            System.out.println(m.start());
//            System.out.println(m.end());
//        }

//        System.out.println(701 / 26);
//        System.out.println(701 / 26);
//        System.out.println(2147483647 % 26);
//        System.out.println((2147483647 - 2147483647 % 26) % 26);
//        System.out.println(Math.pow(26,6));
//        System.out.println(2147483647-Math.pow(26,6));

//        System.out.println((int) 'A');

//        String regex = "^[A-Za-z]+(-)(!|,)$";
//        boolean matches = Pattern.matches(regex, "a-b");
//        boolean matches1 = Pattern.matches(regex, "afad");
//        boolean matches2 = Pattern.matches(regex, "ba-c");
//        boolean matches3 = Pattern.matches(regex, "a!");
//        boolean matches4 = Pattern.matches(regex, "!");


//        String[] split = "a b c,c,c,d".replace(",", " ").split(" ");
//        for (String s : split) {
//            System.out.print(s + "-");
//        }
//        System.out.println(Math.pow(10, 2));
//        Integer i = 1;
//        Integer j = 1;
//        System.out.println(i == j);
//        System.out.println((int) '?');
        System.out.println((int) 'a');
        System.out.println((int) 'z');
////        System.out.println("abca".replace("c", ""));
////        System.out.println((int) ' ');
////        System.out.println("ZY".charAt(1) - 64);
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
//        System.out.println((int) '0');
//        System.out.println((int) '9');
    }
}
