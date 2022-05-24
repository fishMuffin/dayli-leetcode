package edu.klein;

import edu.klein.common.ListNode;

import java.util.*;

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
     * Todo https://leetcode.cn/problems/generate-parentheses/
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * <p>
     * 难度:中
     * 提交次数:1
     * 解决方式:
     * 未来是否需要更优化的解题方法:
     * 未来是否需要复盘:是
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "(";
            for (int j = 0; j < n; j++) {
                s += ")";
            }
        }
        return null;
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
     *
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


}
