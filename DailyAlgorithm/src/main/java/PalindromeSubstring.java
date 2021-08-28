import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Title PalindromeSubstring
 * @Description 给你一个字符串 s，找到 s 中【最长】的回文子串。 回文：即正序跟倒叙相同
 * @Example     ——输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。
 * @Difficulty  中等
 * @Author      hboy
 * @Date        2021/8/28 16:55
 * @Version 1.0.0
 */

public class PalindromeSubstring {

    // 我的解题
    public static String longestPalindrome(String s) {
        String subS = "";
        if (s.length() > 0) {
            subS = String.valueOf(s.charAt(0));
        }
        // 创建一个栈 用于倒序取数据进行比对
        Deque deque = new LinkedList();
        String temSubs = "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                temSubs = s.substring(map.get(c),i+1);
                if(temSubs.length()>subS.length()){
                    subS = temSubs;
                }
                continue;
            }
            deque.push(c);
            map.put(c,i);
        }
        return subS;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
