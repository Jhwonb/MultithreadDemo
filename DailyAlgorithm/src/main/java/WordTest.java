import java.util.*;
import java.util.function.BiConsumer;

/**
 * @Title WordTest
 * @Description 串联所有单词的子串  难度有有点高，暂时搁置
 * @Company hjsj
 * @Author hboy
 * @Date 2021/8/5 17:03
 * @Version 1.0.0
 */

public class WordTest {

    private List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0){
            return list;
        }
        // 先获取words[]中的字符串的长度
        int oneWordLength = words[0].length();
        int wordsLength = words.length;
        int allLength = oneWordLength * wordsLength;
        int sLength = s.length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return list;
    }

    public static void main(String[] args) {
        WordTest wordTest = new WordTest();
        System.out.println(wordTest.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
}
