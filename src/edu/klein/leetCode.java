package edu.klein;

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


}
