//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4553 👎 0

package editor.cn;


public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        int len = solution.lengthOfLongestSubstring("abcaabbcdb");
        System.out.println(len);
        System.out.println();
    }

    /**
     *i=0;start=0;res=1 a=1
     * i=1;start=0;res=2; b=2
     * i=2;start=0;res=3; c=3
     * i=3;start=1;res=3;a=4
     * i=4;start=4;res=3;a=5
     * i=5;start=4;res=3;b=6
     * i=6;start=6;res=3;b=7
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] last = new int[128];
            int n = s.length();

            int res = 0;
            int start = 0; // 窗口开始位置
            for(int i = 0; i < n; i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index]);//last[index]上一次相同字符出现的位置，start所有字符上一次出现的最大位置
                res   = Math.max(res, i - start + 1);//i - start + 1  与上次字符出现的差，res，字符相差最大的差
                last[index] = i+1;//修改相同字符最后出现的位置
                System.out.println(i+"--"+start+"--"+res+"--"+last[index]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}