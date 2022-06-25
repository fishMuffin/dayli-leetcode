package edu.klein;

import edu.klein.common.ListNode;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class leetCode {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * <p>
     * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
     * <p>
     * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
     * 用 n - x 替换黑板上的数字 n 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * <p>
     * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
     * 输入：n = 3
     * 输出：false
     * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
     *
     * @param n
     * @return
     */
    public boolean divisorGame(int n) {
        int flag = 0;
        for (int i = 1; i < n; ) {
            if (n % i == 0) {
                flag += 1;
                n -= i;
            }
        }
        return flag % 2 != 0;
    }

    /**
     * 给定四个整数 row ,   cols ,  rCenter 和 cCenter 。有一个 rows x cols 的矩阵，你在单元格上的坐标是 (rCenter, cCenter) 。
     * <p>
     * 返回矩阵中的所有单元格的坐标，并按与 (rCenter, cCenter) 的 距离 从最小到最大的顺序排。你可以按 任何 满足此条件的顺序返回答案。
     * <p>
     * 单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。
     * <p>
     * 输入：rows = 2, cols = 3, rCenter = 1, cCenter = 2
     * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
     * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
     *
     * @param rows
     * @param cols
     * @param rCenter
     * @param cCenter
     * @return
     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
//        参考了答案
        int[][] res = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0] - rCenter) + Math.abs(o1[1] - cCenter)) - (Math.abs(o2[0] - rCenter) + Math.abs(o2[1] - cCenter));
            }
        });
        return res;
    }

    public int[][] allCellsDistOrder1(int rows, int cols, int rCenter, int cCenter) {
        int[][] ret = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ret[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter));
            }
        });
        return ret;
    }


    /**
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * <p>
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * <p>
     * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
     * <p>
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     * <p>
     * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * 输出：10
     * 解释：
     * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        for (String word : words) {
            int tick = 0;
            byte[] bytes = word.getBytes();
            byte[] charsBytes = chars.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                for (int j = 0; j < chars.length(); j++) {
                    if (bytes[i] == charsBytes[j]) {
                        tick++;
                        charsBytes[j] = 0;
                        break;
                    }
                }
            }
            if (tick == word.length()) res += tick;
        }
        return res;
    }

    /**
     * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
     * <p>
     * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
     * <p>
     * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：false
     * <p>
     * 参考了答案:
     * 思路:
     * 判断三点是否同直线，直接思路就是判断斜率。
     * 假设三点分别为a(x1, y1), b(x2, y2), c(x3,y3),
     * a、b两点的斜率为 k1 = (y2 - y1) / (x2 - x1)
     * a、c两点的斜率为 k2 = (y3 - y1) / (x3 - x1)
     * 如果在同一直线，则k1 = k2，考虑到分母为0 的情况，可以直接交叉相乘，省去判断0的情况，直接判断
     * (y2 - y1) * (x3 - x1) 与 (y3 - y1) * (x2 - x1)
     * 不相等即为不在同一直线上
     *
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }


    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 例如，121 是回文，而 123 不是。
     * <p>
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String xStr = x + "";
        byte[] bytes = xStr.getBytes();
        for (int i = 0, j = bytes.length - 1; j > i; i++, j--) {
            if (bytes[i] != bytes[j]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     * <p>
     * 输入: s = "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int res = 0;
        Map<String, Integer> mapSpecial = new LinkedHashMap<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        mapSpecial.put("CM", 900);
        mapSpecial.put("CD", 400);
        mapSpecial.put("XC", 90);
        mapSpecial.put("XL", 40);
        mapSpecial.put("IX", 9);
        mapSpecial.put("IV", 4);
        String[] strList = {};
        String[] strings = mapSpecial.keySet().toArray(strList);
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i];
            if (s.length() < key.length()) break;
            if (s.contains(key)) {//MCMXCIV->MXCIV
                s = s.replaceFirst(key, "");
                res += mapSpecial.get(key);
                i = 0;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            res += map.get(String.valueOf(s.charAt(i)));
        }
        return res;
    }


    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /**
     * 答案
     *
     * @param s
     * @return
     */
    public int romanToInt1(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            minLength = minLength < strs[i].length() ? minLength : strs[i].length();
        }
        for (int i = 0; i < minLength; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() == 0) break;
                map.put(strs[j].charAt(i), 1);
            }
            if (map.size() == 1) {
                res += strs[0].charAt(i);
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 输入：s = "()[]{}"
     * 输出：true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Byte> stack = new Stack();
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (!stack.isEmpty() && (stack.peek() + 1 == bytes[i] || stack.peek() + 2 == bytes[i])) {
                stack.pop();
            } else {
                stack.push(bytes[i]);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * <p>
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     * <p>
     * 将最终结果插入 nums 的前 k 个位置后返回 k 。
     * <p>
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
     * <p>
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int res = 0;
        int max = nums[nums.length - 1];
        for (int j = 0; j < nums.length - 1; ) {
            if (nums[j] == nums[j + 1]) {
                for (int k = j; k < nums.length - 1; k++) {
                    nums[k] = nums[k + 1];
                }
            } else {
                j++;
            }
            if (nums[j] == max) {
                res = j + 1;
                break;
            }
        }
        return res;
    }

    /**
     * 给你一个数组 nums  和一个值 val，你需要 原地 移除所有数值等于  val  的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        //双指针优化
        int i = 0;
        for (int j = nums.length; i < j; ) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }

        }
        return i;
        //双指针
//        int left = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != val) {
//                nums[left] = nums[i];
//                left++;
//            }
//        }
//        return left;
    }


    /**
     * 实现strStr()函数。
     * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     * 说明：
     * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
     * <p>
     * 输入：haystack = "hello", needle = "ll"
     * 输出：2
     * <p>
     * hello loo
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int res = -1;
        boolean flag = true;
        for (int i = 0, j = 0; i < haystack.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (haystack.length() - i < needle.length()) return res;
                for (int k = i; j < needle.length(); k++) {
                    if (haystack.charAt(k) != needle.charAt(j)) {
                        flag = false;
                        break;
                    } else {
                        j++;
                    }
                }
                if (flag) {
                    return i;
                } else {
                    flag = true;
                    j = 0;
                    i++;
                }
            } else {
                i++;
            }
        }
        return res;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; ) {
            if (target > nums[i]) {
                i++;
            } else break;
        }
        return i;
    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = pre + nums[i] > nums[i] ? pre + nums[i] : nums[i];
            res = res > pre ? res : pre;
        }
        return res;

//        if (nums.length == 1) return nums[0];
//        int res = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (i + 1 == nums.length - 1 && res == 0 && nums[i + 1] > 0) return nums[i + 1];
//            if (nums[i] > 0 && (nums[i + 1] + nums[i] > 0)) {
//                res += nums[i];
//                res += nums[i + 1];
//                i++;
//            } else if (res != 0 && (nums[i + 1] + nums[i] > 0)) {
//                res += nums[i];
//            }
//
//        }
//        return res;
    }

    public int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    /**
     * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
     * <p>
     * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 X 能除尽 str2 。
     * <p>
     * 输入：str1 = "ABABAB", str2 = "ABAB"
     * 输出："AB"
     * <p>
     * 提交次数:5
     * 解决方式:参考答案后自己解决
     * 未来是否需要更优化的解题方法:是
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        String res = "";
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                for (int j = 0; j < i; j++) {
                    if (str1.charAt(j) == str2.charAt(j)) {
                        res += str1.charAt(j);
                    } else return "";
                }
                break;
            }
        }
        String tmp = "";
        String longer = len1 > len2 ? str1 : str2;
        String shorter = len1 < len2 ? str1 : str2;
        for (int i = 0; i < Math.max(len1, len2); i += res.length()) {
            if (shorter.length() == i && !tmp.equals(shorter)) {
                return "";
            }
            tmp += res;
        }
        return tmp.equals(longer) ? res : "";

//        String res = "";
//        int maxLen = Math.max(str1.length(), str2.length());
//        int minLen = Math.min(str1.length(), str2.length());
//        String longer = str1.length() > str2.length() ? str1 : str2;
//        String another = str1.contains(longer) ? str2 : str1;
//        boolean appendFlag = true;
//        int len = 0;
//        for (int i = 0, j = 0; i < maxLen; i++) {
//
//            if (maxLen % (i + 1) == 0 && minLen % (i + 1) == 0) len = i;
//            if (j == minLen) {
//                j = 0;
//                appendFlag = false;
//            }
//            if (longer.charAt(i) == another.charAt(j)) {
//                if (appendFlag)
//                    res += str1.charAt(i);
//                j++;
//            } else return "";
//        }
//        if (longer.length() % res.length() != 0) {
//            res = res.substring(0, longer.length() % res.length());
//        }
//        return res;
    }

    public String gcdOfStrings1(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) { // 从长度大的开始枚举
            if (len1 % i == 0 && len2 % i == 0) {
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    public boolean check(String t, String s) {
        int lenx = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= lenx; ++i) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }

    /**
     * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
     * <p>
     * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
     * <p>
     * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
     * 输出：["girl","student"]
     * <p>
     * 提交次数:1
     * 解决方式:自己一次解决
     * 未来是否需要更优化的解题方法:否
     *
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] s = text.split(" ");
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].equals(first) && s[i + 1].equals(second) && (i + 2) < s.length) res.add(s[i + 2]);
        }
        return res.toArray(res.toArray(new String[0]));
    }

    /**
     * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
     * <p>
     * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
     * <p>
     * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
     * <p>
     * 返回满足 heights[i] != expected[i] 的 下标数量 。
     * <p>
     * 输入：heights = [1,1,4,2,1,3]
     * 输出：3
     * 解释：
     * 高度：[1,1,4,2,1,3]
     * 预期：[1,1,1,2,3,4]
     * 下标 2 、4 、5 处的学生高度不匹配。
     * <p>
     * 提交次数:3
     * 解决方式:自己一次解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        //参考答案思想
        int res = 0;
        int[] count = new int[101];
        for (int i = 0; i < heights.length; i++) {
            count[heights[i]]++;
        }
        for (int i = 0, j = 0; i < count.length; i++) {
            for (int k = 0; k < count[i]; j++, k++) {
                if (heights[j] != i) res += 1;
            }
        }
        return res;


        //冒泡排序再对比
//        int res = 0;
//        int[] expected = heights.clone();
//        for (int i = 0; i < expected.length; i++) {
//            for (int j = 0; j < expected.length - i - 1; j++) {
//                if (expected[j] > expected[j + 1]) {
//                    int temp = expected[j + 1];
//                    expected[j + 1] = expected[j];
//                    expected[j] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < heights.length; i++) {
//            if (heights[i] != expected[i]) res += 1;
//        }
//        return res;

    }

    public int heightChecker1(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * <p>
     * 输入：s = ["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     * <p>
     * 提交次数:1
     * 解决方式:自己一次解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     */
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] == s[j]) continue;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }


    public String reverseStringToString(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }
        return res;
    }

    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序
     * <p>
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * <p>
     * 提交次数:1
     * 解决方式:自己一次解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String res = "";
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            res += reverseStringToString(split[i]);
            if (i < split.length - 1)
                res += " ";
        }
        return res;
    }

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     * <p>
     * 提交次数:2
     * 解决方式:自己一次解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxCount = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] == nums[j]) count++;
                if (count > maxCount) return nums[i];
            }
        }
        return 0;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 提交次数:2
     * 解决方式:自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0) {
                        continue;
                    } else {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     * <p>
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     * <p>
     * 提交次数:1
     * 解决方式:自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] count = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) res.add(i + 1);
        }
        return res;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 输入: [4,1,2,1,2]
     * 输出: 4
     * <p>
     * 提交次数:1
     * 解决方式:自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     * <p>
     * 官网思路:
     * 任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 任何数和其自身做异或运算，结果是 00，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;


//        for (int i = 0; i < nums.length; i++) {
//            boolean flag = false;
//            int res = nums[i];
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) continue;
//                if (res == nums[j]) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) return res;
//        }
//        return 0;
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * <p>
     * 难度:中
     * 提交次数:1
     * 解决方式:参考答案
     * 未来是否需要更优化的解题方法:是
     * 优化方向:回溯
     * 未来是否需要复盘:是
     *
     * @param n
     * @return
     */
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            res.add("");
        } else {
            gene("", n, n);
        }
        return res;
    }

    public void gene(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            gene(str + "(", left - 1, right);
        }
        if (left < right) {
            if (left > 0) {
                gene(str + "(", left - 1, right);
            }
            gene(str + ")", left, right - 1);
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     * <p>
     * 提交次数:1
     * 解决方式:自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int extras = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += extras;
            if (digits[i] == 10) {
                if (i == 0) {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    return res;
                }
                digits[i] = 0;
                extras = 1;
            } else {
                break;
            }
        }
        return digits;
    }

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * <p>
     * 「快乐数」 定义为：
     * <p>
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false
     * <p>
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     * <p>
     * 提交次数:3
     * 解决方式:自己解决
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:是
     * 优化思路:1.哈希集合检测循环,2.快慢指针法
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        String numStr = n + "";
        if (numStr.length() == 1 && n != 1 && n != 7) return false;
        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            Integer integer = Integer.valueOf(numStr.charAt(i) + "");
            res += Math.pow(integer, 2);
        }
        return res == 1 ? true : isHappy(res);
    }


    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
     * 输出：true
     * <p>
     * 提交次数:2
     * 解决方式:参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }


    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * <p>
     * 提交次数:1
     * 解决方式:参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l2, l1.next);
            return l1;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    /**
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     * <p>
     * 输入：nums = [3,0,1]
     * 输出：2
     * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     * <p>
     * 提交次数:1
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int res = 0;
        int[] count = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * <p>
     * 输入: s = "loveleetcode"
     * 输出: 2
     * <p>
     * 提交次数:3
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int res = -1;
        byte[] bytes = s.getBytes();
        int[][] count = new int[276][2];
        for (int i = 0; i < bytes.length; i++) {
            int index = bytes[i] - 96;
            count[index][0]++;
            count[index][1] += i;
        }
        int min = s.length();
        for (int i = 0; i < count.length; i++) {
            if (count[i][0] == 1) {
                if (min > count[i][1]) {
                    String s1 = Character.toString((char) (i + 96));
                    res = s.indexOf(s1);
                    min = count[i][1];
                }
            }
        }
        return res;
    }

    /**
     * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
     * <p>
     * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
     * answer[i] == "Fizz" 如果 i 是 3 的倍数。
     * answer[i] == "Buzz" 如果 i 是 5 的倍数。
     * answer[i] == i （以字符串形式）如果上述条件全不满足。
     * <p>
     * <p>
     * 输入：n = 15
     * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
     * <p>
     * 提交次数:1
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        }
        return res;
    }

    /**
     * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
     * <p>
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     * <p>
     * 提交次数:1
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count1 = new int[1001];
        int[] count2 = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            count1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            count2[nums2[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count1.length; i++) {
            while (count1[i]-- != 0 && count2[i]-- != 0) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * <p>
     * 提交次数:1
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        boolean res = true;
        int[] count_s = new int[27];
        int[] count_t = new int[27];
        byte[] bytes_s = s.getBytes();
        byte[] bytes_t = t.getBytes();
        for (int i = 0; i < bytes_s.length; i++) {
            count_s[bytes_s[i] - 96]++;
        }
        for (int i = 0; i < bytes_t.length; i++) {
            count_t[bytes_t[i] - 96]++;
        }
        for (int i = 0; i < count_s.length; i++) {
            if (count_s[i] != count_t[i]) res = false;
        }
        return res;
    }


    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 解释："amanaplanacanalpanama" 是回文串
     * <p>
     * 提交次数:2
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        boolean res = true;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90) || (c >= 48 && c <= 57)) {
                str += c;
            }
        }
        str = str.toLowerCase();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                res = false;
                break;
            }
        }
        return res;
    }


    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * <p>
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n
     * <p>
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * <p>
     * 提交次数:2
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:否
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        for (int i = 0, j = 0, k = m; i < nums1.length && k < nums1.length; ) {
            if (i < m) {
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    nums1[i] = nums2[j];
                    j++;
                    k++;
                } else {
                    i++;
                }
            } else {
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
     * <p>
     * 例如：
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * <p>
     * 输入: columnTitle = "ZY"
     * 输出: 701
     * <p>
     * 提交次数:2
     * 解决方式:参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int mul = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            res += (columnTitle.charAt(i) - 64) * mul;
            mul *= 26;
        }
        return res;
    }

    public int titleToNumber1(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }


    /**
     * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
     * <p>
     * 输入：[1, 2]
     * 输出：2
     * 解释：第三大的数不存在, 所以返回最大的数 2 。
     * <p>
     * 输入：[2, 2, 3, 1]
     * 输出：1
     * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
     * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
     * <p>
     * 提交次数:2
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            for (; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
            if ((j + 1) == nums.length || nums[j] != nums[j + 1]) {
                count++;
            }
            if (count == 3) return nums[j];
        }
        if (count < 3) return nums[nums.length - 1];
        return 0;
    }

    /**
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     * <p>
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     * <p>
     * 输入: "Hello, my name is John"
     * 输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     * <p>
     * 提交次数:5
     * 解决方式:自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 32) {
                if (flag)
                    count++;
                flag = false;
            } else {
                flag = true;
            }
        }
        return count;
    }

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * <p>
     * 输入: s = "abca"
     * 输出: true
     * 解释: 你可以删除c字符。
     * <p>
     * 提交次数:7
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int index = 1;
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (s.charAt(i) != s.charAt(j)) {
                index--;
                if (index < 0) return false;
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
//    public boolean validPalindrome(String s) {
//        int[][] count = new int[26][3];
//        for (int i = 0; i < s.length(); i++) {
//            int index = s.charAt(i) - 97;
//            count[index][0]++;
//            count[index][1] = i;
//            count[index][2] += i;
//
//        }
//        int cnt = 0;
//        for (int i = 0; i < 26; i++) {
//            if (count[i][0] % 2 == 1) {
//                cnt++;
//                String replace = s.replace(s.charAt(count[i][1]) + "", "");
//                boolean innerFlag = true;
//                for (int i1 = 0, j = replace.length() - 1; i1 <= j; i1++, j--) {
//                    if (replace.charAt(i1) != replace.charAt(j)) {
//                        innerFlag = false;
//                        break;
//                    }
//                }
//                if (innerFlag) return true;
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i < 26; i++) {
//            sum += count[i][2];
//        }
//        if (cnt > 2) return false;
//        if (cnt == 0) return true;
//        return false;
//    }

    /**
     * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
     * <p>
     * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
     * <p>
     * 输入：sequence = "ababc", word = "ba"
     * 输出：1
     * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
     * <p>
     * 提交次数:2
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        for (int i = 0; i < sequence.length(); ) {
            int index = sequence.indexOf(word, i);
            if (index != -1) {
                res++;
                i = index + word.length();

            }
//        return sequence.contains(word)?(sequence.length()-sequence.replace(word, "").length())/word.length():0;
        }
        return res;
    }

    public int maxRepeating1(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
     * <p>
     * 输入：nums = [1,0,1,1], k = 1
     * 输出：true
     * <p>
     * 输入：nums = [1,2,3,1,2,3], k = 2
     * 输出：false
     * <p>
     * 提交次数:3
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    /**
     * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     * <p>
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     * <p>
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * <p>
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * <p>
     * 提交次数:3
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        String[] s1 = s.split(" ");
        if (s1.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            int i1 = pattern.indexOf(pattern.charAt(i), i + 1);
            if (i1 != -1 && !s1[i1].equals(s1[i])) {
                return false;
            }
            if ((map.containsKey(s1[i]) && (map.get(s1[i])) != pattern.charAt(i))) {
                return false;
            } else {
                map.put(s1[i], pattern.charAt(i));
            }
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) return false;
        Map<Object, Integer> map = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            Integer put1 = map.put(pattern.charAt(i), i);
            Integer put2 = map.put(split[i], i);
            // 注意 如果这里用的是int i定义的 则当i=129时 put1,put2的值虽然一样 但是put1 != put2为true
            if (put1 != put2)
                return false;
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
     * <p>
     * 序号代表了一个元素有多大。序号编号的规则如下：
     * <p>
     * 序号从 1 开始编号。
     * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
     * 每个数字的序号都应该尽可能地小。
     * <p>
     * 输入：arr = [40,10,20,30]
     * 输出：[4,1,2,3]
     * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
     * <p>
     * 输入：arr = [100,100,100]
     * 输出：[1,1,1]
     * 解释：所有元素有相同的序号。
     * <p>
     * 提交次数:5
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        int length = arr.length;
        int[] sorted = new int[length];
        System.arraycopy(arr, 0, sorted, 0, length);
        Arrays.sort(sorted);
        Map<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
        for (int i = 0, rank = 1; i < length; i++) {
            int num = sorted[i];
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        int[] ranks = new int[length];
        for (int i = 0; i < length; i++) {
            ranks[i] = rankMap.get(arr[i]);
        }
        return ranks;
    }

    public int[] arrayRankTransform2(int[] arr) {
        int[] clone = arr.clone();
        int[] res = new int[arr.length];
        Arrays.sort(clone);
        for (int i = 0; i < clone.length; i++) {
            for (int j = 0; j < clone.length; j++) {
                if (i == j) continue;
                if (arr[i] == clone[j]) {
                    res[i] = j + 1;
                }
            }
        }
        return res;
    }

    public int[] arrayRankTransform1(int[] arr) {
        int[] ints = Arrays.stream(arr).distinct().toArray();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[arr.length];
        if (arr.length == 1) {
            res[0] = 1;
            return res;
        }
        if (ints.length == 1 && arr.length != 1) {
            map.put(arr[0], 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i] > arr[j]) {
                    if (map.containsKey(arr[i])) {
                        map.put(arr[i], map.get(arr[i]) + 1);
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }

    /**
     * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
     * 混合字符串 由小写英文字母和数字组成。
     * <p>
     * 输入：s = "dfa12321afd"
     * 输出：2
     * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
     * <p>
     * 提交次数:3
     * 解决方式: 自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public int secondHighest(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                count[s.charAt(i) - 48]++;
            }
        }
        int tick = 1;
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != 0) {
                if (tick == 0) return i;
                tick--;
            }
        }
        return -1;
    }

    /**
     * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
     * <p>
     * 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
     * <p>
     * 输入：num = 28
     * 输出：true
     * 解释：28 = 1 + 2 + 4 + 7 + 14
     * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
     * <p>
     * 提交次数:2
     * 解决方式: 自我完成
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        List<Integer> list = new ArrayList<>();
        if (num != 1) list.add(1);
        int end = num;
        for (int i = 2; i < end; i++) {
            if (num % i == 0) {
                end = num / i;
                list.add(i);
                list.add(end);
            }
        }
        int sum = list.stream().mapToInt(x -> x).sum();
        if (sum == num) return true;
        return false;
    }

    /**
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     * <p>
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * <p>
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     * <p>
     * 输入：s = "egg", t = "add"
     * 输出：true
     * <p>
     * 提交次数:9
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[][] s_count = new int[128][2];
        int[][] t_count = new int[128][2];
        for (int i = 0; i < s.length(); i++) {
            int s_index = s.charAt(i);
            int t_index = t.charAt(i);
            s_count[s_index][0] += 1;
            s_count[s_index][1] += (i + 1) * (Math.pow(10, (s_count[s_index][0] - 1)));
            t_count[t_index][0] += 1;
            t_count[t_index][1] += (i + 1) * (Math.pow(10, (t_count[t_index][0] - 1)));
        }
        boolean b = checkValid(s_count, t_count);
        boolean b1 = checkValid(t_count, s_count);
        if (b && b1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkValid(int[][] s_count, int[][] t_count) {
        boolean flag = true;
        for (int i = 0; i < 128; i++) {
            if (s_count[i][0] > 1) {
                flag = false;
                int j = 0;
                for (; j < 128; j++) {
                    if (t_count[j][0] > 1) {
                        if (s_count[i][0] == t_count[j][0]) {
                            if (s_count[i][1] == t_count[j][1]) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if (flag) return flag;
        return false;
    }

    /**
     * 丑数 就是只包含质因数 2、3 和 5 的正整数。
     * <p>
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 输入：n = 14
     * 输出：false
     * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
     * <p>
     * <p>
     * 提交次数:3
     * 解决方式: 自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if (n == 0) return false;
        while (true) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                break;
            }
        }
        if (n == 1) return true;
        return n == 2 ? true : n == 3 ? true : n == 5 ? true : false;
    }

    /**
     * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母  target，请你寻找在这一有序列表里比目标字母大的最小字母。
     * <p>
     * 在比较时，字母是依序循环出现的。举个例子：
     * <p>
     * 如果目标字母 target = 'z' 并且字符列表为  letters = ['a', 'b']，则答案返回  'a'
     * <p>
     * <p>
     * 输入: letters = ["c","f","j"], target = "c"
     * 输出: "f"
     * <p>
     * 提交次数:2
     * 解决方式: 自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param letters
     * @param target
     * @return
     */

    public char nextGreatestLetter(char[] letters, char target) {
        int[] count = new int[26];
        for (int i = 0; i < letters.length; i++) {
            count[letters[i] - 97]++;
        }
        char first = 'a';
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                first = (char) (i + 97);
                break;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && i > target - 97) {
                return (char) (i + 97);
            }
        }
        return first;
    }

    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * <p>
     * 输入: s = "abab"
     * 输出: true
     * 解释: 可由子串 "ab" 重复两次构成。
     * <p>
     * <p>
     * 提交次数:8
     * 解决方式: 自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;
        if (isRepeatString(1, s)) return true;
        int len = s.length();
        int increase = 2;
        while (true) {
            if (len % increase != 0) {
                increase += 1;
                continue;
            } else if (increase > len / 2) {
                break;
            }
            boolean repeatString = isRepeatString(increase, s);
            if (repeatString) {
                return repeatString;
            } else {
                increase += 1;
            }
        }
        return false;
    }

    private boolean isRepeatString(int increase, String str) {
        boolean res = true;
        int start = 0;
        while (true) {
            int end = start + increase;
            String substring1 = str.substring(start, end);
            String substring2 = str.substring(end, end + increase);
            if (!substring1.equals(substring2)) {
                res = false;
                break;
            }
            if (end + increase >= str.length()) break;
            start += increase;
        }
        return res;
    }


    /**
     * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
     * <p>
     * 注意：你 不能 修改非 '?' 字符。
     * <p>
     * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
     * <p>
     * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
     * <p>
     * 输入：s = "ubv?w"
     * 输出："ubvaw"
     * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
     * <p>
     * <p>
     * 提交次数:2
     * 解决方式: 自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public String modifyString(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '?')
                return "a";
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                String replacement = "";
                if (i == 0) {
                    if (s.charAt(i + 1) == '?') {
                        replacement = "a";
                    } else {
                        replacement = (char) (s.charAt(i + 1) < 122 ? s.charAt(i + 1) + 1 : 97) + "";
                    }
                } else if (i == s.length() - 1) {
                    if (s.charAt(i - 1) == '?') {
                        replacement = "a";
                    } else {
                        replacement = (char) (s.charAt(i - 1) < 122 ? s.charAt(i - 1) + 1 : 97) + "";
                    }
                } else {
                    int c = (s.charAt(i - 1) + 1) < 122 ? s.charAt(i - 1) + 1 : 97;
                    replacement = (char) (c == s.charAt(i + 1) ? c + 1 : c) + "";
                }
                s = s.replaceFirst("\\?", replacement);
            }
        }
        return s;
    }

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
     * <p>
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * <p>
     * 输入：s = "ab##", t = "c#d#"
     * 输出：true
     * 解释：s 和 t 都会变成 ""。
     * <p>
     * <p>
     * 提交次数:2
     * 解决方式: 自己解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        String s_str = getStack(s);
        String t_str = getStack(t);
        return s_str.equals(t_str);
    }

    private String getStack(String s) {
        Stack<String> stack_s = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack_s.push(s.charAt((i)) + "");
            } else {
                if (!stack_s.isEmpty())
                    stack_s.pop();
            }
        }
        return stack_s.toString();
    }

    /**
     * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
     * <p>
     * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
     * <p>
     * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
     * 输出："apple"
     * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
     * <p>
     * 提交次数:1
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        String longest = "";
        Set<String> candidates = new HashSet<String>();
        candidates.add("");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (candidates.contains(word.substring(0, word.length() - 1))) {
                candidates.add(word);
                longest = word;
            }
        }
        return longest;
    }


    /**
     * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
     * <p>
     * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
     * <p>
     * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
     * <p>
     * 输入：s = "a0b1c2"
     * 输出："0a1b2c"
     * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
     * <p>
     * <p>
     * 提交次数:3
     * 解决方式: 自己有解决方案 答案更高效
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:是
     *
     * @param s
     * @return
     */
    public String reformat(String s) {
        StringBuffer res = new StringBuffer("");
        Stack<Character> charList = new Stack<>();
        Stack<Character> numList = new Stack<>();
        if (s.length() <= 1) return s;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) charList.push(s.charAt(i));
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) numList.push(s.charAt(i));
        }
        if (Math.abs(charList.size() - numList.size()) > 1) {
            return res.toString();
        } else if (charList.size() > numList.size()) {
            strAppend(s, res, charList, numList);
        } else {
            strAppend(s, res, numList, charList);
        }
        return res.toString();
    }

    private void strAppend(String s, StringBuffer res, Stack<Character> charList, Stack<Character> numList) {
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                if (!charList.isEmpty())
                    res.append(charList.pop());
            } else {
                if (!numList.isEmpty())
                    res.append(numList.pop());
            }
            flag = !flag;
        }
    }

    public String reformat1(String s) {
        char[] cs = s.toCharArray();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c >= '0' && c <= '9') {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        if (Math.abs(cnt1 - cnt2) > 1) {
            return "";
        }
        boolean num = false;
        if (cnt1 > cnt2) {
            num = true;
        }
        char[] ans = new char[cs.length];
        int p1 = 0, p2 = 1;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c >= '0' && c <= '9') {
                if (num) {
                    ans[p1] = c;
                    p1 += 2;
                } else {
                    ans[p2] = c;
                    p2 += 2;
                }
            } else {
                if (!num) {
                    ans[p1] = c;
                    p1 += 2;
                } else {
                    ans[p2] = c;
                    p2 += 2;
                }
            }
        }
        return new String(ans);
    }


    public String reformat2(String s) {
        char[] chars = s.toCharArray();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') cnt1++;
            if (c >= '0' && c <= '9') cnt2++;
        }
        if (Math.abs(cnt1 - cnt2) > 1) return "";
        char[] res = new char[chars.length];
        int p1 = 0, p2 = 1;
        boolean isNum = true;
        if (cnt1 > cnt2) isNum = !isNum;
        if (!isNum) {
            p2 = 0;
            p1 = 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                res[p2] = chars[i];
                p2 += 2;
            } else {
                res[p1] = chars[i];
                p1 += 2;
            }
        }
        return new String(res);
    }

    /**
     * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     * <p>
     * 输入：nums = [1,2,3,4,5]
     * 输出：60
     * <p>
     * <p>
     * 提交次数:2
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
//        if (nums.length == 3) return nums[0] * nums[1] * nums[2];
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            int tick = 3;
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) continue;
//                if (nums[i] < nums[j]) {
//                    tick--;
//                }
//            }
//            if (tick > 0)
//                list.add(nums[i]);
//        }
//        int res = 1;
//        for (Integer integer : list) {
//            res *= integer;
//        }
//        return res;
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];
        int max = 0;
        Arrays.sort(nums);
        int len = nums.length;
        max = Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 3]);
        return max;
    }


    /**
     * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
     * <p>
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     * <p>
     * 输入：nums = [1,3,5,4,7]
     * 输出：3
     * 解释：最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
     * <p>
     * 提交次数:1
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int right = 1;
        int res = right - left;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                right++;
            } else {
                res = Math.max(right - left, res);
                left = i;
                right = i + 1;
            }
        }
        res = Math.max(right - left, res);
        return res;
    }

    /**
     * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
     * <p>
     * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
     * <p>
     * 输入：s = "011101"
     * 输出：5
     * 解释：
     * 将字符串 s 划分为两个非空子字符串的可行方案有：
     * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
     * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
     * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
     * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
     * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
     * <p>
     * 提交次数:3
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public int maxScore(String s) {
        int divide = 1;
        int res = 0;
        while (divide < s.length()) {
            int leftCnt = 0;
            int rightCnt = 0;
            for (int i = 0; i < divide; i++) {
                if (s.charAt(i) == '0') leftCnt++;
            }
            for (int i = divide; i < s.length(); i++) {
                if (s.charAt(i) == '1') rightCnt++;
            }
            res = Math.max(leftCnt + rightCnt, res);
            divide++;
        }
        return res;
    }

    public int maxScore1(String s) {
        char[] chars = s.toCharArray();
        int leftCnt = 0;
        int rightCnt = 0;
        boolean isLeft = true;
        for (int i = 0; i < chars.length; ) {
            if (isLeft) {
                if (chars[i] == '0') {
                    i++;
                    if (i == chars.length && isLeft) break;
                    leftCnt++;
                } else {
                    isLeft = false;
                    if (i == 0) i++;
                }
            } else if (chars[i] == '1') {
                i++;
                rightCnt++;
            } else {
                i++;
            }
        }
        return leftCnt + rightCnt;
    }


    /**
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * <p>
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
     * <p>
     * 输入：s = "leetcode"
     * 输出："leotcede"
     * <p>
     * 提交次数:2
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:是
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        String template = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        boolean leftFlag;
        boolean rightFlag;
        for (int left = 0, right = s.length() - 1; left < right; ) {
            if (!template.contains(chars[left] + "")) {
                left++;
                leftFlag = false;
            } else {
                leftFlag = true;
            }
            if (!template.contains(chars[right] + "")) {
                right--;
                rightFlag = false;
            } else {
                rightFlag = true;
            }
            if (leftFlag && rightFlag) {
                if (chars[left] != chars[right]) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                }
                left++;
                right--;
            }
        }
        return new String(chars);
    }


    /**
     * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
     * <p>
     * 输入：nums = [-4,-2,1,4,8]
     * 输出：1
     * 解释：
     * -4 到 0 的距离为 |-4| = 4 。
     * -2 到 0 的距离为 |-2| = 2 。
     * 1 到 0 的距离为 |1| = 1 。
     * 4 到 0 的距离为 |4| = 4 。
     * 8 到 0 的距离为 |8| = 8 。
     * 所以，数组中距离 0 最近的数字为 1 。
     * <p>
     * 提交次数:3
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:是
     *
     * @param nums
     * @return
     */
    public int findClosestNumber(int[] nums) {
        int res = nums[0];
        int minLen = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (minLen > current) {
                minLen = current;
                res = nums[i];
            } else if (minLen == current) {
                res = Math.max(nums[i], res);
            }
        }
        return res;
    }

    /**
     * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
     * <p>
     * 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
     * <p>
     * arr.length >= 3
     * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
     * arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     * <p>
     * 输入：arr = [0,3,2,1]
     * 输出：true
     * <p>
     * 输入：arr = [3,5,5]
     * 输出：false
     * <p>
     * 提交次数:4
     * 解决方式: 自我解决+看答案优化
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:否
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray2(int[] arr) {
        if (arr.length < 3) return false;
        if (arr.length == 3)
            if (arr[1] > arr[0] && arr[1] > arr[2])
                return true;
            else
                return false;
        boolean right = true;
        boolean beforeTure = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (i == 0 && arr[i] >= arr[i + 1])
                return false;
            if (i == arr.length - 2 && arr[i] <= arr[i + 1])
                return false;
            if (beforeTure) {
                if (arr[i] >= arr[i + 1]) {
                    beforeTure = false;
                }
            } else {
                if (arr[i] <= arr[i + 1]) {
                    right = false;
                }
            }
        }
        return right;
    }


    public boolean validMountainArray1(int[] arr) {
        int N = arr.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && arr[i] < arr[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == N - 1;
    }

    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int len = arr.length;
        while (i + 1 < len && arr[i] < arr[i + 1]) i++;
        if (i == 0 || i == len - 1) return false;
        while (i + 1 < len && arr[i] > arr[i + 1]) i++;
        return i == len - 1;
    }


    /**
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     * <p>
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     * <p>
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     * <p>
     * <p>
     * <p>
     * 输入：nums = [1,12,-5,-6,50,3], k = 4
     * 输出：12.75
     * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     * <p>
     * <p>
     * 提交次数:5
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        double sum = 0;
        int i = 0;
        while (i <= nums.length) {
            if (i < k) {
                sum += nums[i];
            } else {
                maxSum = Math.max(maxSum, sum);
                if (i == nums.length) break;
                double temp = sum;
                sum = temp - nums[i - k] + nums[i];
            }
            i++;
        }
        return maxSum / k;
    }

    /**
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * <p>
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * <p>
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     * <p>
     * 输入：n = 5, bad = 4
     * 输出：4
     * 解释：
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * 所以，4 是第一个错误的版本。
     * <p>
     * 提交次数:5
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }


    public int firstBadVersion2(int n) {
        return (int) findTheNum(0, n);
    }

    private double findTheNum(double start, double end) {
        if ((int) start == (int) end)
            return start;
        if (isBadVersion((int) ((start + end) / 2))) {
            findTheNum(start, (start + end) / 2);
        } else {
            findTheNum((start + end) / 2, end);
        }
        return 0;
    }

    public int firstBadVersion1(int n) {
        if (n == 1) return 1;
        int left = 0;
        double right = n;
        while (!isBadVersion((int) ((left + right) / 2))) {
            left = (int) Math.ceil((left + right) / 2.0);
        }
        if (left > n / 2) return (left + n) / 2;
        int rightEnd = (int) (right / 2);
        while (isBadVersion(rightEnd)) {
            rightEnd /= 2;
        }
        if (rightEnd == 0) return 1;
        int end = rightEnd * 2;
        while (rightEnd < end) {
            if (isBadVersion(rightEnd)) {
                break;
            } else {
                rightEnd++;
            }
        }
        return rightEnd;
    }

    private boolean isBadVersion(int n) {
        return n >= 1702766719;
    }


    /**
     * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
     * <p>
     * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
     * <p>
     * 输入：n = 8
     * 输出：3
     * 解释：因为第四行不完整，所以返回 3 。
     * <p>
     * 提交次数:4
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * (mid + 1) > (long) 2 * n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left * (left + 1) > 2 * n) left--;
        return left;
    }

    /**
     * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
     * <p>
     * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
     * <p>
     * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
     * <p>
     * <p>
     * <p>
     * 输入:
     * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
     * banned = ["hit"]
     * 输出: "ball"
     * 解释:
     * "hit" 出现了3次，但它是一个禁用的单词。
     * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
     * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
     * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
     * <p>
     * 提交次数:4
     * 解决方式: 自我解答
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String s = paragraph.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= '!' && ch <= '/') || ch == '?' || ch == ';') {
                s = s.replace(ch + "", " ");
            }
        }
        String[] s1 = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if (s1.equals("")) continue;
            if (map.containsKey(s1[i])) {
                map.put(s1[i], map.get(s1[i]) + 1);
            } else {
                map.put(s1[i], 1);
            }
        }
        for (String s2 : banned) {
            if (map.containsKey(s2)) map.remove(s2);
        }
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (res.equals("")) {
                res = entry.getKey();
            } else {
                res = map.get(res) > entry.getValue() ? res : entry.getKey();
            }
        }
        return res;
    }


    /**
     * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
     * <p>
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
     * <p>
     * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     * <p>
     * <p>
     * 输入：nums = [1,2,2,4]
     * 输入：nums = [1,2,2,4,5,6,7]
     * 输出：[2,3]
     * <p>
     * 提交次数:6
     * 解决方式: 自我解答
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[10001];
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (res[nums[i]] == 0) {
                res[nums[i]]++;
            } else {
                result[0] = nums[i];
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (res[i] == 0) result[1] = i;
        }
        return result;
    }

    public int[] findErrorNums1(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res[0] = i;
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }


    /**
     * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入 1 次或多次。
     * <p>
     * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True。
     * <p>
     * 输入：name = "alex", typed = "aaleex"
     * 输出：true
     * 解释：'alex' 中的 'a' 和 'e' 被长按。
     * <p>
     * 输入：name = "saeed", typed = "ssaaedd"
     * 输出：false
     * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     * <p>
     * 提交次数:2
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param name
     * @param typed
     * @return
     */

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public boolean isLongPressedName1(String name, String typed) {
        char[] chars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        int i = 0, j = 0;
        while (i < chars.length && j < typed.length()) {
            if (chars[i] == typedChars[j]) {
                j++;
            } else if (chars[i + 1] == typedChars[j]) {
                i++;
            } else {
                return false;
            }
        }
        return Math.abs(i - name.length()) <= 1 && j == typed.length();
    }


    /**
     * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
     * <p>
     * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
     * <p>
     * 仅由小写字母、连字符和/或标点（不含数字）组成。
     * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
     * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
     * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
     * <p>
     * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
     * <p>
     * 输入：sentence = "alice and  bob are playing stone-game10"
     * 输出：5
     * 解释：句子中的有效单词是 "alice"、"and"、"bob"、"are" 和 "playing"
     * "stone-game10" 不是有效单词，因为它含有数字
     * <p>
     * 提交次数:7
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:是
     *
     * @param sentence
     * @return
     */
    public int countValidWords(String sentence) {
        if (sentence.equals("-")) return 0;
        String[] s = sentence.split(" ");
        String regex = "^[A-Za-z]*(-)?[A-Za-z]*(!|,|\\.)?$";
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("") && Pattern.matches(regex, s[i])) {
                if (s[i].contains("-")) {
                    if ((s[i].charAt(0) != '-' && s[i].charAt(s[i].length() - 1) != '-')) {
                        char pre = s[i].charAt(s[i].indexOf("-") - 1);
                        char next = s[i].charAt(s[i].indexOf("-") + 1);
                        if (pre <= 'z' && pre >= 'a' && next <= 'z' && next >= 'a')
                            res++;
                    }
                } else
                    res++;
            }
        }
        return res;
    }

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * <p>
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * <p>
     * 输入：s = "luffy is still joyb1oy  "
     * 输出：6
     * 解释：最后一个单词是长度为6的“joyboy”。
     * <p>
     * 提交次数:1
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String s1 = s.toLowerCase();
        boolean starting = false;
        boolean end = false;
        boolean isAlpha = true;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s1.charAt(i);
            if (c != ' ') {
                starting = true;
            } else {
                if (starting) end = true;
            }
            if (starting && end) {
                if (isAlpha) {
                    return res;
                } else {
                    starting = false;
                    end = false;
                    res = 0;
                }
            }
            if (c <= 'z' && c >= 'a') {
                res++;
            } else if (c != ' ') {
                isAlpha = false;
            }
        }
        return res;
    }

    public int lengthOfLastWord_ref(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }


    /**
     * 给你一个二进制字符串 s ，该字符串 不含前导零 。
     * <p>
     * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true    。否则，返回 false 。
     * <p>
     * 输入：s = "110"
     * 输出：true
     * <p>
     * 提交次数:1
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param s
     * @return
     */
    public boolean checkOnesSegment(String s) {
        int begin = 0;
        int end = s.length() - 1;
        boolean startFlag = false;
        boolean endFlag = false;
        while (begin < end) {
            if (!startFlag && s.charAt(begin) != '1') {
                begin++;
            } else {
                startFlag = true;
            }
            if (!endFlag && s.charAt(end) != '1') {
                end--;
            } else {
                endFlag = true;
            }
            if (startFlag && endFlag) break;
        }
        if (begin == end) return true;
        return !s.substring(begin, end).contains("0");
    }

    /**
     * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
     * <p>
     * 更正式地，检查是否存在两个下标 i 和 j 满足：
     * <p>
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     * <p>
     * 输入：arr = [7,1,14,11]
     * 输出：true
     * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
     * <p>
     * 提交次数:2
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param arr
     * @return
     */
    public boolean checkIfExist(int[] arr) {
        int[] countG = new int[1001];
        int[] countS = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                countG[arr[i]]++;
            } else {
                countS[Math.abs(arr[i])]++;
            }
        }
        return checkCount(countG) || checkCount(countS);
    }

    private boolean checkCount(int[] count) {
        for (int i = 1; i < count.length; i++) {
            if (count[0] > 1) return true;
            if (count[i] > 0) {
                int twice = i * 2;
                if (twice < count.length && count[twice] > 0)
                    return true;
            }
        }
        return false;
    }


    /**
     * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
     * <p>
     * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
     * <p>
     * 返回 重新排列空格后的字符串 。
     * <p>
     * 输入：text = " practice   makes   perfect"
     * 输出："practice   makes   perfect "
     * 解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
     * <p>
     * 提交次数:3
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param text
     * @return
     */
    public String reorderSpaces(String text) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') count++;
        }
        if (count == 0) return text;
        String[] s = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("")) list.add(s[i]);
        }
        if (list.size() == 1) {
            sb.append(list.get(0));
            sb = appendSpace(sb, count);
            return sb.toString();
        }
        int tailAppend = count % (list.size() - 1);
        int gap = count / (list.size() - 1);
        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j));
            if (j == list.size() - 1) break;
            sb = appendSpace(sb, gap);
        }
        sb = appendSpace(sb, tailAppend);
        return sb.toString();
    }

    private StringBuffer appendSpace(StringBuffer sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
        return sb;
    }


    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     * <p>
     * 例如：
     * <p>
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * <p>
     * ZY -> 701
     * <p>
     * ZZY->
     * ...
     * <p>
     * 输入：columnNumber = 2147483647
     * 输出："FXSHRXW"
     * <p>
     * 输入：columnNumber = 701
     * 输出："ZY"
     * <p>
     * 提交次数:1
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public String convertToTitle_unfinished(int columnNumber) {
        String res = "";
        while (columnNumber > 0) {
            int tail = columnNumber % 26;
            if (tail != 0) {
                res += (char) (tail + 64) + "";
                columnNumber -= tail;
            } else {
                res += "Z";
            }
        }
        return res;
    }

    /**
     * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
     * <p>
     * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
     * <p>
     * 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
     * 输出：true
     * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
     * <p>
     * 输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
     * 输出：false
     * <p>
     * <p>
     * 提交次数:5
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param arr
     * @return
     */
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0)
            return false;
        else {
            int third = sum / 3;
            int temp = 0;
            int tick = 0;
            for (int i = 0; i < arr.length; i++) {
                temp += arr[i];
                if (temp == third) {
                    sum -= third;
                    temp = 0;
                    tick++;
                }
            }
            return tick >= 3;
        }
    }

    /**
     * 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
     * <p>
     * 模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
     * <p>
     * 如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
     * <p>
     * 输入：arr = [1,2,1,2,1,2,1,3], m = 2, k = 2
     * 输出：true
     * 解释：模式 (1,2) 长度为 2 ，且连续重复 2 次。另一个符合题意的模式是 (2,1) ，同样重复 2 次。
     * <p>
     * 提交次数:3
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param arr
     * @param m
     * @param k
     * @return
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        if (m * k > arr.length) return false;
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i; j < arr.length && j + m < arr.length; j++) {
                if (arr[j] == arr[j + m]) {
                    temp++;
                } else {
                    temp = 0;
                }
                if ((temp / m + 1) >= k) return true;
            }
        }
        return false;
    }

    /**
     * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
     * <p>
     * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
     * <p>
     * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
     * <p>
     * 输入：time = "2?:?0"
     * 输出："23:50"
     * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
     * <p>
     * 输入：time = "1?:22"
     * 输出："19:22"
     * <p>
     * 提交次数:3
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param time
     * @return
     */
    public String maximumTime(String time) {
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') {
                time = time.replaceFirst("\\?", "2").replaceFirst("\\?", "3");
            } else if (time.charAt(1) <= '3') {
                time = time.replaceFirst("\\?", "2");
            } else {
                time = time.replaceFirst("\\?", "1");
            }
        }
        if (time.charAt(1) == '?') {
            if (time.charAt(0) == '2') {
                time = time.replaceFirst("\\?", "3");
            } else {
                time = time.replaceFirst("\\?", "9");
            }
        }
        if (time.charAt(3) == '?') {
            time = time.replaceFirst("\\?", "5");
        }
        if (time.charAt(4) == '?') {
            time = time.replaceFirst("\\?", "9");
        }
        return time;
    }

    public String maximumTime_ref(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);
    }

    /**
     * 给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。如果数组本身已经是严格递增的，请你也返回 true 。
     * <p>
     * 数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
     * <p>
     * 输入：nums = [1,2,10,5,7]
     * 输出：true
     * 解释：从 nums 中删除下标 2 处的 10 ，得到 [1,2,5,7] 。
     * [1,2,5,7] 是严格递增的，所以返回 true 。
     * <p>
     * <p>
     * [105,924,32,968]
     * [2,3,1,2]
     * <p>
     * <p>
     * 提交次数:3
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:是
     *
     * @param nums
     * @return
     */

    public boolean canBeIncreasing(int[] nums) {
        int length = nums.length;
        int last = nums[0];
        int count = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] <= last) {
                count++;
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    last = nums[i - 1];
                    continue;
                }
            }
            last = nums[i];
        }
        return count <= 1;
    }


    public boolean canBeIncreasing_ref(int[] nums) {
        int n = nums.length;
        int count = 0;
        int last = nums[0];
        for (int i = 1; i < n; ++i) {
            // 此时要校验删除哪个元素
            if (nums[i] <= last) {
                ++count;
                // 此时，删除nums[i - 1]不解决问题，只能删除nums[i]
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    last = nums[i - 1];
                    continue;
                }
            }
            last = nums[i];
        }
        return count <= 1;
    }


    public boolean canBeIncreasing_unfinsh(int[] nums) {
        int res[] = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                if (nums[i + 1] < nums[i + 2] && nums[i - 1] > nums[i + 1]) {
                    for (int j = i, begin = i; j < res.length; j++) {
                        if (j == begin + 1) j++;
                        res[i] = nums[j];
                        i++;
                    }
                } else {
                    for (int j = i + 1; j < nums.length; j++) {
                        res[i] = nums[j];
                        i++;
                    }
                }
            } else {
                res[i] = nums[i];
            }
        }
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i] > res[i + 1]) return false;
        }
        return true;
    }


    /**
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * <p>
     * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
     * <p>
     * 输入：flowerbed = [1,0,0,0,0,0,0,0,1], n = 3
     * 输出：true
     * <p>
     * 提交次数:6
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:是
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n <= 1) return true;
        int count = 0;
        int start = 0;
        int preCount = 0;
        while (start < flowerbed.length && flowerbed[start] == 0) {
            preCount++;
            start++;
        }
        if (start == flowerbed.length && preCount == start) {
            return n * 2 - 1 <= preCount;
        }
        n = flowerChecker(preCount, n, true);
        if (n == 0) return true;
        for (int i = start; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                n = flowerChecker(count, n, false);
                if (n == 0) return true;
                count = 0;
            }
        }
        n = flowerChecker(count, n, true);
        return n <= 0;
    }

    private int flowerChecker(int count, int n, boolean isEdge) {
        int countCal = 1;
        if (isEdge) countCal = 0;
        if (count >= n * 2 + countCal) return 0;
        else {
            n -= ((count - countCal) / 2);
        }
        return n;
    }


    /**
     * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
     * <p>
     * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
     * <p>
     * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
     * <p>
     * <p>
     * 输入：s = "ab", goal = "ba"
     * 输出：true
     * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
     * <p>
     * 提交次数:5
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:是
     * 未来是否需要复盘:是
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.length() < 2) return false;
        int[] count = new int[26];
        boolean isSame = false;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] > 0) {
                isSame = true;
                break;
            } else {
                count[s.charAt(i) - 'a']++;
            }
        }
        if (s.equals(goal) && isSame) return true;
        char[] chars = s.toCharArray();
        int start = -1;
        int end = -1;
        boolean flag = true;
        for (int i = 0; i < goal.length(); i++) {
            if (i - 1 >= 0 && chars[i] != chars[i - 1] && flag) flag = false;
            if (goal.charAt(i) != chars[i]) {
                if (start == -1)
                    start = i;
                else {
                    if (end == -1)
                        end = i;
                }
            }
            if (start != -1 && end != -1) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                return new String(chars).equals(goal);
            }
        }
        return flag;
    }

    /**
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * <p>
     * 输入：deck = [1,1,1,2,2,2,3,3]
     * 输出：false
     * 解释：没有满足要求的分组。
     * <p>
     * 输入：deck = [1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     * <p>
     * 提交次数:5
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;
        List<Integer> list = new ArrayList<>();
        int[] count = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            count[deck[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (!list.contains(count[i]))
                    list.add(count[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
        }

        for (int i = 2; i <= min; i++) {
            boolean flag = true;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }


    /**
     * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
     * <p>
     * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
     * <p>
     * 返回对 word 完成替换后形成的 不同 整数的数目。
     * <p>
     * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
     * <p>
     * 输入：word = "a1b01c001"
     * 输出：1
     * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
     * <p>
     * 输入：word = "a123bc34d8ef34"
     * 输出：3
     * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
     * <p>
     * 提交次数:4
     * 解决方式: 参考答案
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:是
     *
     * @param word
     * @return
     */
    public int numDifferentIntegers(String word) {
        String[] words = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                continue;
            }
            int j = 0; //对前导零的处理，因为考虑‘00000’的情况，所以到最后一位的前一位即可
            while (words[i].charAt(j) == '0' && j < words[i].length() - 1) {
                j++;
            }
            set.add(words[i].substring(j));
        }
        return set.size();
    }

    public int numDifferentIntegers_unfinish(String word) {
        List<String> list = new ArrayList<>();
        boolean flag = false;
        char[] chars = word.toCharArray();
        int begin = -1;
        int end = -1;
        for (int i = 0; i < chars.length; i++) {
            if (!flag) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    begin = i;
                    end = i;
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    end++;
                } else {
                    String substring = word.substring(begin, end + 1);
                    String toAdd = trimZero(substring);
                    if (!list.contains(toAdd)) list.add(toAdd);
                    begin = i;
                    end = i;
                    flag = false;
                }
            }
        }
        if (end > begin || (chars[chars.length - 1] >= '0' && chars[chars.length - 1] <= '9')) {
            String substring = word.substring(begin, end + 1);
            String toAdd = trimZero(substring);
            if (!list.contains(toAdd)) list.add(toAdd);
        }
        return list.size();
    }

    private String trimZero(String input) {
        if (input.length() == 1) return input;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(input.length() - 1) != '0' && input.charAt(i) == '0') {
                input = input.replaceFirst("0", "");
            } else {
                break;
            }
        }
        return input;
    }


    /**
     * 如果数组是单调递增或单调递减的，那么它是 单调 的。
     * <p>
     * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
     * <p>
     * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
     * <p>
     * 输入：nums = [6,5,4,4]
     * 输出：true
     * <p>
     * 提交次数:3
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;
        boolean isAlwaysUp = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                isAlwaysUp = nums[i] - nums[i + 1] < 0;
                if (i == nums.length - 1) return true;
                break;
            }
        }
        for (int i = 1; i < nums.length - 1; i++) {
            int sub = nums[i] - nums[i + 1];
            if (isAlwaysUp) {
                if (sub > 0) return false;
            } else {
                if (sub < 0) return false;
            }
        }
        return true;
    }

    /**
     * 给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
     * <p>
     * 输入：nums = [11,7,2,15]
     * 输出：2
     * 解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
     * 元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
     * 总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
     * <p>
     * 提交次数:1
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param nums
     * @return
     */
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[0] && nums[i] < nums[nums.length - 1]) count++;
        }
        return count;
    }

    /**
     * LeetCode 设计了一款新式键盘，正在测试其可用性。测试人员将会点击一系列键（总计 n 个），每次一个。
     * <p>
     * 给你一个长度为 n 的字符串 keysPressed ，其中 keysPressed[i] 表示测试序列中第 i 个被按下的键。releaseTimes 是一个升序排列的列表，其中 releaseTimes[i] 表示松开第 i 个键的时间。字符串和数组的 下标都从 0 开始 。第 0 个键在时间为 0 时被按下，接下来每个键都 恰好 在前一个键松开时被按下。
     * <p>
     * 测试人员想要找出按键 持续时间最长 的键。第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1] ，第 0 次按键的持续时间为 releaseTimes[0] 。
     * <p>
     * 注意，测试期间，同一个键可以在不同时刻被多次按下，而每次的持续时间都可能不同。
     * <p>
     * 请返回单次按键 持续时间最长 的键，如果有多个这样的键，则返回 按字母顺序排列最大 的那个键。
     * <p>
     * 输入：releaseTimes = [9,29,49,50], keysPressed = "cbcd"
     * 输出："c"
     * 解释：按键顺序和持续时间如下：
     * 按下 'c' ，持续时间 9（时间 0 按下，时间 9 松开）
     * 按下 'b' ，持续时间 29 - 9 = 20（松开上一个键的时间 9 按下，时间 29 松开）
     * 按下 'c' ，持续时间 49 - 29 = 20（松开上一个键的时间 29 按下，时间 49 松开）
     * 按下 'd' ，持续时间 50 - 49 = 1（松开上一个键的时间 49 按下，时间 50 松开）
     * 按键持续时间最长的键是 'b' 和 'c'（第二次按下时），持续时间都是 20
     * 'c' 按字母顺序排列比 'b' 大，所以答案是 'c'
     * <p>
     * 提交次数:4
     * 解决方式: 自我解决
     * 未来是否需要更优化的解题方法:否
     * 未来是否需要复盘:否
     *
     * @param releaseTimes
     * @param keysPressed
     * @return
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] keeps = new int[keysPressed.length()];
        keeps[0] = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            keeps[i] = releaseTimes[i] - releaseTimes[i - 1];
        }
        int maxKeeps = keeps[0];
        char res = keysPressed.charAt(0);
        for (int i = 1; i < keeps.length; i++) {
            if (keeps[i] > maxKeeps) {
                maxKeeps = keeps[i];
                res=keysPressed.charAt(i);
            }else if(keeps[i] == maxKeeps&&keysPressed.charAt(i)>res){
                res=keysPressed.charAt(i);
            }
        }
        return res;
    }
}