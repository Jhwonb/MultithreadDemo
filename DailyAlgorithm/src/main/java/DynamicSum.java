/**
 * @Title DynamicSum
 * @Description ����һ������ nums �����顸��̬�͡��ļ��㹫ʽΪ��runningSum[i] = sum(nums[0]��nums[i])��
 *              �뷵�� nums �Ķ�̬�͡�
 * @Example     �������룺nums = [1,2,3,4] �����[1,3,6,10] ���ͣ���̬�ͼ������Ϊ [1, 1+2, 1+2+3, 1+2+3+4]��
 * @Difficulty  ��
 * @Author      hboy
 * @Date        2021/8/28 16:26
 * @Version 1.0.0
 */

public class DynamicSum {

    // �ҵĽ���
    public static int[] runningSum(int[] nums) {
        int numsLength = nums.length;
        int[] runningSum = new int[numsLength];
        int temNum = 0;
        for (int i = 0; i < numsLength; i++) {
            temNum = 0;
            for (int j = 0; j <= i; j++) {
                temNum+=nums[j];
            }
            runningSum[i] = temNum;
        }
        return runningSum;
    }

    // �ٷ����� ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
    public static int[] runningSum2(int[] nums) {
        int numsLength = nums.length;
        for (int i = 1; i < numsLength; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(runningSum2(new int[]{3,1,2,10,1}));
    }
}
