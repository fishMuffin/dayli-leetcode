package edu.klein;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EnglishLeetCodeDynamicProgramming {

    public int maxSumAfterPartitioningThirdTry(int[] arr, int k) {
        int[] ret = new int[arr.length];
        int max = arr[0];
        for (int i = 0; i < k; i++) {
            max = Math.max(arr[i], max);
            ret[i] = max * (i + 1);
        }
        for (int i = k; i < arr.length; i++) {
            max = arr[i];
            for (int j = 0; j < k; j++) {
                max = Math.max(max, arr[i - j]);
                ret[i] = Math.max(ret[i], ret[i - (j+1)] + max * (j + 1));
            }
        }
        System.out.println("Third:");
        for (int i : ret) {
            System.out.print(i + ",");
        }
        System.out.println();
        return ret[ret.length - 1];
    }

    /**
     * 1043. Partition Array for Maximum Sum
     * <p>
     * Given an integer array arr, partition the array into (contiguous) subarrays of length at most
     * k. After partitioning, each subarray has their values changed to become the maximum value of
     * that subarray.
     * <p>
     * Return the largest sum of the given array after partitioning. Test cases are generated so
     * that the answer fits in a 32-bit integer.
     * <p>
     * Input: arr = [1,15,7,9,2,5,10], k = 3 Output: 84 Explanation: arr becomes
     * [15,15,15,9,10,10,10]
     * <p>
     * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4 [1,7,7,7,7,9,9,9,9,9,9] Output: 83 Input: arr =
     * Input: arr = [1,1,4,5,7,3,6,1,9,9,3], k = 4 [1,7,7,7,7,9,9,9,9,9,9] Output: 83 Input: arr =
     *
     * @param arr
     * @param k
     * @return
     */


    public int maxSumAfterPartitioningMyFirstFailure(int[] arr, int k) {
        int tempSum = 0;
        int index = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                if (i + 1 <= k) {
                    tempSum += (i + 1) * max;
                }

//                tempSum += (k - (i + 1)) * max;
            } else {
                if (i - index + 1 <= k) {
                    tempSum += max;
                } else {
                    tempSum += arr[i];
                }
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > max) {
//                max = arr[i];
//                for (int j = k; j > 0 && i >= 0 && i < arr.length; j--) {
//
//                }
//            }
//            tempSum += arr[i];
//            max = Math.max(arr[i], max);
//            index++;
//        }
        return 0;
    }

    public int maxSumAfterPartitioningSecondTrySuccess(int[] arr, int k) {
        int[] ret = new int[arr.length];
        int max = arr[0];
        for (int i = 0; i < k; i++) {
            max = Math.max(arr[i], max);
            ret[i] = max * (i + 1);
        }
        for (int i = k; i < arr.length; i++) {
            max = arr[i];
            for (int j = 1; j <= k; j++) {
                max = Math.max(max, arr[i - j + 1]);
                ret[i] = Math.max(ret[i], ret[i - j] + j * max);
            }
        }
        return ret[ret.length - 1];
    }

    public int maxSumAfterPartitioning(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len];

        int max = A[0];
        for (int i = 0; i < K; i++) {
            max = Math.max(max, A[i]);
            dp[i] = max * (i + 1);
        }

        for (int i = K; i < len; i++) {
            max = A[i];
            for (int j = 1; j <= K; j++) {
                max = Math.max(max, A[i - j + 1]);
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }
        System.out.println("other:");
        for (int i : dp) {
            System.out.print(i + ",");
        }
        System.out.println();
        return dp[len - 1];
    }

    /**
     * 22. Generate Parentheses
     * <p>
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed
     * parentheses.
     * <p>
     * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"]
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        geneParen(new char[n * 2], 0, list);
        return list;
    }


    public void geneParen(char[] current, int pos, List<String> result) {
        if (current.length == pos) {
            if (isWellFormedParentheses(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            geneParen(current, pos + 1, result);
            current[pos] = ')';
            geneParen(current, pos + 1, result);
        }
    }

    private Boolean isWellFormedParentheses(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis_failure(int n) {
        Stack<Character> stack = new Stack<>();
        char[] chars = new char[n * 2];
//        for (int j = 0, k = 0, l = 0; j < n; j++) {
//            chars[l++] = '(';
//            for (; k < n; k++) {
//                chars[l++] = ')';
//            }
//        }

        return new ArrayList<>();
    }


    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }


    /**
     * 338. Counting Bits
     * <p>
     * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
     * ans[i] is the number of 1's in the binary representation of i.
     * <p>
     * Input: n = 5 Output: [0,1,1,2,1,2] Explanation: 0 --> 0 1 --> 1 2 --> 10 3 --> 11 4 --> 100 5
     * --> 101
     * <p>
     * Need to review in the future
     *
     * @param n
     * @return
     */

    public int[] countBits_my(int n) {
        int range = 1;
        int[] ret = new int[n + 1];
        ret[0] = 0;
        int start = 0;
        for (int i = 1; i < ret.length; i++) {
            if (i == range) {
                range *= 2;
                start = 0;
            }
            ret[i] = ret[start++] + 1;
        }
        return ret;
    }


    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        ret[0] = 0;
        int pow = 1;
        for (int i = 1, t = 0; i <= n; i++, t++) {
            if (i == pow) {
                pow *= 2;
                t = 0;
            }
            ret[i] = ret[t] + 1;
        }
        return ret;
    }

//    public int[] countBits_my(int n) {
//        int[] ret = new int[n + 1];
//        ret[0] = 0;
//        if(n==1) return ret;
//        int range = 2;
//        for (int j = 0; j < n; j++) {
//
//        }
////        int[] ret = {0, 1, 1, 2, 1, 2, 2, 3};
//    }

    /**
     * 1641. Count Sorted Vowel Strings
     * <p>
     * Given an integer n, return the number of strings of length n that consist only of vowels (a,
     * e, i, o, u) and are lexicographically sorted.
     * <p>
     * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes
     * before s[i+1] in the alphabet.
     * <p>
     * <p>
     * Input: n = 2 Output: 15 Explanation: The 15 sorted strings that consist of vowels only are
     * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]. Note that "ea"
     * is not a valid string since 'e' comes after 'a' in the alphabet.
     * <p>
     * <p>
     * Need to review in the future
     *
     * @param n
     * @return
     */
    public int countVowelStrings_second(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int j = 1; j < n; j++) {
            o += u;
            i += o;
            e += i;
            a += e;
        }
        return a + e + i + o + u;
    }

    public int countVowelStrings_first_failure(int n) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        int result = 0;
        for (int i = 0; i < vowels.length; i++) {
            for (int j = i; j < n; j++) {

            }
        }
        return result;
    }

    public int countVowelStrings_math2(int n) {
        int[] memo = new int[]{1, 1, 1, 1, 1};
        while (n > 0) {
            for (int i = 1; i < 5; i++) {
                memo[i] += memo[i - 1];
            }
            n--;
        }
        return memo[4];
    }

//    int a = 1, e = 1, i = 1, o = 1, u = 1;
//
//    public int countVowelStrings_math1(int n) {
//        for (int j = 1; j < n; j++) {
//            increment();
//        }
//        return a + e + i + o + u;
//    }
//
//    private void increment() {
//        a = a + e + i + o + u;
//        e = e + i + o + u;
//        i = i + o + u;
//        o = o + u;
//    }

}
