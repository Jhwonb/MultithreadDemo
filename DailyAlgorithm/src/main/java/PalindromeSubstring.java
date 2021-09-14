import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Title PalindromeSubstring
 * @Description ����һ���ַ��� s���ҵ� s �С�����Ļ����Ӵ��� ���ģ���һ���ַ����������������ͬ
 * @Example     �������룺s = "babad" �����"bab" ���ͣ�"aba" ͬ���Ƿ�������Ĵ𰸡�
 * @Difficulty  �е�
 * @Author      hboy
 * @Date        2021/8/28 16:55
 * @Version 1.0.0
 */

public class PalindromeSubstring {

    // �ҵĽ��⡪��δ�����       �������� ʱ�临�Ӷ�O(n?)
    public static String longestPalindrome(String s) {
        int sLen = s.length();
        if(sLen < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // ��Ϊs.getChatAt(i)��ÿ�ζ����һ���Ƿ��±�Խ�磬���Կ�����ת��ΪcharArr[]��
        char[] charArr = s.toCharArray();
        // ö�����г��ȴ���1���Ӵ�
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
     * ��֤�Ƿ�Ϊ�����Ӵ�
     * @author houby
     * @param charArr �Ӵ�
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
     * ������ɢ��
     * -ö�����п��ܵĻ����Ӵ�������λ��;
     * -����λ�ÿ�����һ���ַ��������Ӵ�����Ҳ�������������ڵ��ַ���ż���ַ���;
     * -��¼��Ӵ�����ر���;
     * ʱ�临�Ӷ�O(n?)  �ռ临�Ӷ�O(1)
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
        // ��Ϊs.getChatAt(i)��ÿ�ζ����һ���Ƿ��±�Խ�磬���Կ�����ת��ΪcharArr[]��
        char[] charArr = s.toCharArray();
        // ö�����г��ȴ���1���Ӵ�
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
        // ��left == right��ʱ�򣬻����Ӵ�������һ���ַ��������Ӵ�����Ϊ����
        // ��left  right + 1 ��ʱ�򣬻����Ӵ������������ַ��������Ӵ�����Ϊż��
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
        // ����ѭ����ǡ������s.charAt(i) != s.charAt(j)
        // �����Ӵ��ĳ���Ϊ j-i+1-2 = j-i-1
        return j-i-1;
    }

    /**
     * ��̬�滮��
     * -״̬: dp[i][j] ��ʾ�Ӵ�s[i..j] �Ƿ�Ϊ�����Ӵ�
     * -�õ�״̬ת�Ʒ���: dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
     * -�߽�����: j-1-(i+1) + 1 <2 �� j-i<3
     * -��ʵ���൱��һ����άͼ  ����s = "ababa"  db[i][j]��ʾ�Ӵ�  �����൱��i�������൱��j (t:true f:false)
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
        // ���ڶԽ���Ϊ���ַ������Ը�������ֱ�Ӹ�ֵtrue
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }
        // ��Ϊs.getChatAt(i)��ÿ�ζ����һ���Ƿ��±�Խ�磬���Կ�����ת��ΪcharArr[]��
        char[] charArr = s.toCharArray();
        // ������У�������� ����db[0][0]=true������±�1��ʼ����
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
                // ֻҪdp[i][j] == true����s[i...j]�ʹ�������Ӵ�����ʱֻ��Ҫ�Ƚϳ��ȼ���
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
