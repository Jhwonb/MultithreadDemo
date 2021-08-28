import java.util.Arrays;
import java.util.HashMap;

/**
 * @Title test
 * @Description 两数字之和
 * @Company hjsj
 * @Author hboy
 * @Date 2021/7/14 18:19
 * @Version 1.0.0
 */

public class SumOfTwoNumbers {

    // 算法1：暴力枚举  时间复杂度为O(n^2)
    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            // 第一个数字
            int firstNum = nums[i];
            for(int j = i+1;j<nums.length;j++){
                int secondNum = nums[j];
                if((firstNum + secondNum) == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    // 算法1：使用HashMap 时间复杂度为O(1)
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int firstNum = nums[i];
            if(sumMap.containsKey(target - firstNum)){
                return new int[]{sumMap.get(target - firstNum),i};
            }
            sumMap.put(firstNum,i);
        }
        return new int[0];
    }

    // 算法2：一个字符串中不出现重复字母最长的长度
    public int lengthOfLongestSubstring(String s) {
        HashMap map = new HashMap();
        int start = 0;
        int end = 0;
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {

        }

        return length;
    }

    public static void main(String[] args) {
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        int[] nums = {3,2,95,4,-3};
        int target = 92;
        System.out.println(Arrays.toString(sumOfTwoNumbers.twoSum2(nums,target)));
        System.out.println(sumOfTwoNumbers.lengthOfLongestSubstring("dvdf"));
    }

}
