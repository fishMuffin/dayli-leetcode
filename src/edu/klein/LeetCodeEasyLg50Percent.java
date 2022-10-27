package edu.klein;

import java.util.Stack;

public class LeetCodeEasyLg50Percent {

    /**
     * 1470. 重新排列数组 输入：nums = [2,5,1,3,4,7], n = 3 输出：[2,3,5,4,1,7] 解释：由于 x1=2, x2=5, x3=1, y1=3,
     * y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
     */
    public int[] shuffle(int[] nums, int n) {
        int[] temp = new int[nums.length];
        for (int i = 0, j = 0, k = n; i < nums.length && j <= n && k <= nums.length; ) {
            temp[i] = nums[j];
            temp[i + 1] = nums[k];
            i += 2;
            j++;
            k++;
        }
        return temp;
    }

    /**
     * 1512. 好数对的数目
     * <p>
     * 给你一个整数数组 nums 。
     * <p>
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     * <p>
     * 返回好数对的数目。
     * <p>
     * 输入：nums = [1,2,3,1,1,3] 输出：4 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                res += getFullPairs(count[i]);
            }
        }
        return res;
    }

    private int getFullPairs(int num) {
        int res = 0;
        for (int i = 1; i < num; i++) {
            res += i;
        }
        return res;
    }

    /**
     * 1221. 分割平衡字符串
     * <p>
     * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
     * <p>
     * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * <p>
     * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
     * <p>
     * 返回可以通过分割得到的平衡字符串的 最大数量 。
     * <p>
     * 输入：s = "RLLLLRRRLR" 输出：3 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     *
     *
     * 提交次数:1 解决方式: 参考答案 未来是否需要更优化的解题方法:否 未来是否需要复盘:是
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int res=0,d=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='L') d++;
            else d--;
            if(d==0) res++;
        }
        return res;
    }
}
