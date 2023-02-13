package edu.klein;

public class LeetCodeTheHardestInEasy {

    /**
     * 2423. 删除字符使频率相同
     * <p>
     * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
     * <p>
     * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
     * <p>
     * 输入：word = "abcc" 输出：true 解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
     *
     * @param word
     * @return
     */
    public boolean equalFrequency(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        int sum = 0, div = 0, single = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                sum += count[i];
                div++;
            }
            if (count[i] == 1) {
                single++;
            }
        }
        if (((sum - 1) % div == 0) || sum == div || single == 1) {
            return true;
        } else {
            return false;
        }
    }

}
