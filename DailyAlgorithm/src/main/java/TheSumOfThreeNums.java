import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title TheSumOfThreeNums
 * @Description 三数之和 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 示例：输入：nums = [-1,0,1,2,-1,-4] 输出：[[-1,-1,2],[-1,0,1]]
 * 输入：nums = [] 输出：[]；  输入：nums = [0] 输出：[]
 * @Difficulty  中等
 * @Author hboy
 * @Date 2021/10/8 13:35
 * @Version 1.0.0
 */

public class TheSumOfThreeNums {


    /**
     * 暴力破解，可行，但是在大数据量下会非常慢，因其时间复杂度为O(n?)
     * @author houby
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @date 2021/10/8 15:00
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    List<Integer> numList = new ArrayList();
                    if(nums[i]+nums[j]+nums[k] == 0){
                        Integer temp[] = {nums[i],nums[j],nums[k]};
                        Arrays.sort(temp);
                        numList = Arrays.asList(temp);
                        if(sumList.contains(numList)){
                            continue;
                        }
                        sumList.add(numList);
                    }
                }
            }
        }
        return sumList;
    }

    /**
     * 根据解析，通过排序+双指针的做法即可
     * @author houby
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @date 2021/10/8 15:02
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sumList = new ArrayList();
        int len = nums.length;
        // 枚举 a
        for (int first = 0; first < len; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = len - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < len; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    sumList.add(list);
                }
            }
        }
        return sumList;
    }

    public static void main(String[] args) {
        System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }
}
