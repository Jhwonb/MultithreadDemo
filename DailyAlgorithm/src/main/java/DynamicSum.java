/**
 * @Title DynamicSum
 * @Description 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i])。
 *              请返回 nums 的动态和。
 * @Example     ——输入：nums = [1,2,3,4] 输出：[1,3,6,10] 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]。
 * @Difficulty  简单
 * @Author      hboy
 * @Date        2021/8/28 16:26
 * @Version 1.0.0
 */

public class DynamicSum {

    // 我的解题
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

    // 官方解题 时间复杂度O(n) 空间复杂度O(1)
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
