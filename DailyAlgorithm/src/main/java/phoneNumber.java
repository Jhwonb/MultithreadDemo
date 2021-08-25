
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @Title phoneNumber
 * @Description 电话号码和字母的组合题
 * @Company hjsj
 * @Author hboy
 * @Date 2021/8/4 11:04
 * @Version 1.0.0
 */

public class phoneNumber {
    private Map<Character, String> phoneMap = new HashMap<Character, String>();

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
        if (digits != null && digits.length() > 0) {
            backtrack(list,digits,0,new StringBuffer());
        }
        return list;
    }

    // 此处适合采用回溯实现
    public void backtrack(List<String> resultList, String digits, int index, StringBuffer sb){
        if (index == digits.length()) {
            resultList.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String num = phoneMap.get(digit);
            for (int i = 0; i < num.length(); i++) {
                sb.append(num.charAt(i));
                backtrack(resultList, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        phoneNumber phone = new phoneNumber();
        System.out.println(phone.letterCombinations(null));

    }
}
