import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Title PalindromeSubstring
 * @Description 给你一个字符串 s，找到 s 中【最长】的回文子串。 回文：即一个字符串的正序跟倒序相同
 * @Example     ——输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。
 * @Difficulty  中等
 * @Author      hboy
 * @Date        2021/8/28 16:55
 * @Version 1.0.0
 */

public class PalindromeSubstring {

    // 我的解题——未解出。       暴力解题 时间复杂度O(n?)
    public static String longestPalindrome(String s) {
        int sLen = s.length();
        if(sLen < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // 因为s.getChatAt(i)会每次都检查一遍是否下标越界，所以可以先转换为charArr[]。
        char[] charArr = s.toCharArray();
        // 枚举所有长度大于1的子串
        for (int i = 0; i < sLen - 1; i++) {
            for (int j = i + 1; j < sLen; j++) {
                if (j - i + 1 > maxLen && verifyIsPalindromeSubstring(charArr, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen + begin);
    }

    /**
     * 验证是否为回文子串
     * @author houby
     * @param charArr 子串
     * @return void
     * @date 2021/9/7 17:54
     */
    private static boolean verifyIsPalindromeSubstring(char[] charArr, int left, int right) {
        while (left < right) {
            if(charArr[left] != charArr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 中心扩散法
     * -枚举所有可能的回文子串的中心位置;
     * -中心位置可能是一个字符（奇数子串），也可能是两个相邻的字符（偶数字符）;
     * -记录最长子串的相关变量;
     * 时间复杂度O(n?)  空间复杂度O(1)
     * @author houby
     * @param s
     * @return java.lang.String
     * @date 2021/9/7 18:02
     */
    public static String longestPalindrome1(String s) {
        int sLen = s.length();
        if(sLen < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // 因为s.getChatAt(i)会每次都检查一遍是否下标越界，所以可以先转换为charArr[]。
        char[] charArr = s.toCharArray();
        // 枚举所有长度大于1的子串
        for (int i = 0; i < sLen - 1; i++) {
            int oddlen = expandAroundCenter(charArr, i, i);
            int evenlen = expandAroundCenter(charArr, i, i + 1);
            if(Math.max(oddlen,evenlen) > maxLen){
                maxLen = Math.max(oddlen,evenlen);
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static int expandAroundCenter(char[] charArr, int left, int right){
        // 当left == right的时候，回文子串中心是一个字符，回文子串长度为奇数
        // 当left  right + 1 的时候，回文子串中心是连个字符，回文子串长度为偶数
        int len = charArr.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len){
            if(charArr[i] == charArr[j]){
                i--;
                j++;
            }else{
                break;
            }
        }
        // 跳出循环后，恰好满足s.charAt(i) != s.charAt(j)
        // 回文子串的长度为 j-i+1-2 = j-i-1
        return j-i-1;
    }

    /**
     * 动态规划法
     * -状态: dp[i][j] 表示子串s[i..j] 是否为回文子串
     * -得到状态转移方程: dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
     * -边界条件: j-1-(i+1) + 1 <2 即 j-i<3
     * -其实就相当于一个二维图  例：s = "ababa"  db[i][j]表示子串  纵轴相当于i，横轴相当于j (t:true f:false)
     *    0  1  2  3  4
     *  0 t  f  t  f  t
     *  1    t  f  t  f
     *  2       t  f  t
     *  3          t  f
     *  4             t
     * @author houby
     * @param s
     * @return java.lang.String
     * @date 2021/9/13 17:31
     */
    public static String longestPalindrome2(String s) {
        int sLen = s.length();
        if (sLen < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        //
        boolean[][] dp = new boolean[sLen][sLen];
        // 由于对角线为单字符，所以给对象线直接赋值true
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }
        // 因为s.getChatAt(i)会每次都检查一遍是否下标越界，所以可以先转换为charArr[]。
        char[] charArr = s.toCharArray();
        // 先填充列，再填充行 由于db[0][0]=true，则从下标1开始即可
        for (int j = 1; j < sLen; j++) {
            for (int i = 0; i < j; i++) {
                if(charArr[i] != charArr[j]){
                    dp[i][j] = false;
                }else{
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][j] == true，则s[i...j]就代表回文子串，此时只需要比较长度即可
                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abcaaa"));
    }
}
