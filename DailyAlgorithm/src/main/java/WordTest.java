import java.util.*;

/**
 * @Title WordTest
 * @Description 串联所有单词的子串
 * @Company hjsj
 * @Author hboy
 * @Date 2021/8/5 17:03
 * @Version 1.0.0
 */

public class WordTest {

    private List<Integer> findSubstring(String s, String[] words) {
        List<String> wordsList = Arrays.asList(words);
        List<Integer> list = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();
        // 先获取words[]中的字符串的长度
        int wordLength = words[0].length();
        for (int i = 0; i < s.length(); ) {
            String singleS = s.substring(i,i+4);
            if(Arrays.binarySearch(words,singleS) > -1){
                deque.push(singleS);

            }
        }

        return list;
    }

    public static void main(String[] args) {
        WordTest wordTest = new WordTest();
        System.out.println(wordTest.findSubstring("", new String[]{"aa", "bb"}));
    }
}
