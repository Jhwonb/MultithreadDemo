import java.util.HashMap;

/**
 * @Title intToRomanTest
 * @Description intת��������
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/29 15:39
 * @Version 1.0.0
 */

public class intToRomanTest {

    // ������������ ����ɶ��ԣ�����ܣ��ķѽϴ�
    private String int2Roman(int num){
        HashMap map = new HashMap();
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        String romanStr = "";
        for (int n = 0; n < 4; n++) {
            if(n == 0){
                int th = num / 1000;
                num = num % 1000;
                if(th == 0){
                    continue;
                }else{
                    for(int i = 0;i<th;i++){
                        romanStr+="M";
                    }
                }
            }else if(n == 1){
                int h = num / 100;
                num = num % 100;
                if(h == 0){
                    continue;
                }else{
                    if(map.containsKey(h*100)){
                        romanStr+=map.get(h*100);
                        continue;
                    }else if(h >= 5){
                        romanStr+="D";
                        h -= 5;
                    }
                    for (int i = 0; i < h; i++) {
                        romanStr+="C";
                    }
                }
            }else if(n == 2){
                int ten = num / 10;
                num = num % 10;
                if(ten == 0){
                    continue;
                }else{
                    if(map.containsKey(ten*10)){
                        romanStr+=map.get(ten*10);
                        continue;
                    }else if(ten >= 5){
                        romanStr+="L";
                        ten -= 5;
                    }
                    for (int i = 0; i < ten; i++) {
                        romanStr+="X";
                    }
                }
            }else{
                if(num > 0){
                    if(map.containsKey(num)){
                        romanStr+=map.get(num);
                        continue;
                    }else if(num >= 5){
                        romanStr+="V";
                        num -= 5;
                    }
                    for (int i = 0; i < num; i++) {
                        romanStr+="I";
                    }
                }
            }
        }
        return romanStr;
    }

    // ���ٽ��ⷽ�� ����ɶ��ԣ�ǿ ���ܣ��ķѽ�С
    /**
     * ̰���㷨�������ҳ���Ŀ��ֵ��ȵ����ֵ��
     * ��һ���ǳ������̰���㷨�����⣬�С�����Ǯ���⡹������������Ǯ��ʱ������ʹ�ô����ֵ��ֽ�ң���Ӳ�ң��Ҹ��˿ͣ������˿͵õ���ֽ�ҵ��������١�
     * */
    private String int2RomanCorrect(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer romanStr = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String roman = romanS[i];
            while (num >= value){
                num -= value;
                romanStr.append(roman);
            }
            if(num == 0){
                break;
            }
        }
        return romanStr.toString();
    }

    // ��������ת��Ϊ��ֵ
    private int roman2Int(String s){
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if(preNum < num){
                sum -= preNum;
            }else{
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        intToRomanTest test = new intToRomanTest();
        System.out.println(test.int2Roman(1994));
        System.out.println(test.int2RomanCorrect(1994));
        System.out.println(test.roman2Int("MCMXCIV"));
    }
}
