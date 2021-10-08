import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title TheSumOfThreeNums
 * @Description ����֮�� ����һ������ n ������������nums���ж�nums���Ƿ��������Ԫ�� a��b��c ��ʹ��a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 * ʾ�������룺nums = [-1,0,1,2,-1,-4] �����[[-1,-1,2],[-1,0,1]]
 * ���룺nums = [] �����[]��  ���룺nums = [0] �����[]
 * @Difficulty  �е�
 * @Author hboy
 * @Date 2021/10/8 13:35
 * @Version 1.0.0
 */

public class TheSumOfThreeNums {


    /**
     * �����ƽ⣬���У������ڴ��������»�ǳ���������ʱ�临�Ӷ�ΪO(n?)
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
     * ���ݽ�����ͨ������+˫ָ�����������
     * @author houby
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @date 2021/10/8 15:02
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sumList = new ArrayList();
        int len = nums.length;
        // ö�� a
        for (int first = 0; first < len; first++) {
            // ��Ҫ����һ��ö�ٵ�������ͬ
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c ��Ӧ��ָ���ʼָ����������Ҷ�
            int third = len - 1;
            int target = -nums[first];
            // ö�� b
            for (int second = first + 1; second < len; second++) {
                // ��Ҫ����һ��ö�ٵ�������ͬ
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // ��Ҫ��֤ b ��ָ���� c ��ָ������
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // ���ָ���غϣ����� b ����������
                // �Ͳ��������� a+b+c=0 ���� b<c �� c �ˣ������˳�ѭ��
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
