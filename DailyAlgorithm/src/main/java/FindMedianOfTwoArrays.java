import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Title FindMedianOfTwoArrays
 * @Description 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例：    输入：nums1 = [1,3], nums2 = [2] 输出：2.00000 解释：合并数组 = [1,2,3] ，中位数 2
 *          输入：nums1 = [1,2], nums2 = [3,4] 输出：2.50000 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 要求：时间复杂度O(log(m+n))
 * @Author hboy
 * @Date 2021/9/14 15:37
 * @Version 1.0.0
 */

public class FindMedianOfTwoArrays {

    // 暴力破解——冒泡排序 不符合时间复杂度要求
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 中位数
        double medianNum = 0.00;
        int n1len = nums1.length;
        int n2len = nums2.length;
        if(n1len + n2len == 1){
            return n1len == 0 ? nums2[0] : nums1[0];
        }
        // 两数组拼接排序
        int[] newArr = mergeArrs(nums1,nums2);
        int newArrlen = newArr.length;
        // 合并数组为偶数长度，取中位数需要将中间两个值相加/2
        if (newArrlen % 2 == 0) {
            medianNum = (double)(newArr[newArrlen / 2] + newArr[(newArrlen / 2) - 1]) / 2;
        }else{
            medianNum = newArr[newArrlen / 2];
        }

        return medianNum;
    }

    // 合并数组并排序——冒泡排序
    private static int[] mergeArrs(int[] nums1, int[] nums2) {
        int n1len = nums1.length;
        int n2len = nums2.length;
        int[] newArr = new int[n1len + n2len];
        System.arraycopy(nums1,0,newArr,0,n1len);
        System.arraycopy(nums2, 0, newArr, n1len, n2len);
        // 冒泡排序
        for (int i = 0; i < newArr.length - 1; i++) {
            for (int j = i + 1; j < newArr.length; j++) {
                int temp = newArr[j];
                if(newArr[i] > temp){
                    newArr[j] = newArr[i];
                    newArr[i] = temp;
                }
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 4, 4}));
    }
}
