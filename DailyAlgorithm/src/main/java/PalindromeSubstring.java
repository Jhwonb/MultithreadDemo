import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Title PalindromeSubstring
 * @Description ����һ���ַ��� s���ҵ� s �С�����Ļ����Ӵ��� ���ģ��������������ͬ
 * @Example     �������룺s = "babad" �����"bab" ���ͣ�"aba" ͬ���Ƿ�������Ĵ𰸡�
 * @Difficulty  �е�
 * @Author      hboy
 * @Date        2021/8/28 16:55
 * @Version 1.0.0
 */

public class PalindromeSubstring {

    // �ҵĽ���
    public static String longestPalindrome(String s) {
        String subS = "";
        if (s.length() > 0) {
            subS = String.valueOf(s.charAt(0));
        }
        // ����һ��ջ ���ڵ���ȡ���ݽ��бȶ�
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
