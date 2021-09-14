import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Title FindMedianOfTwoArrays
 * @Description Ѱ�����������������λ��
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С�������� nums1 �� nums2�������ҳ���������������������� ��λ�� ��
 * ʾ����    ���룺nums1 = [1,3], nums2 = [2] �����2.00000 ���ͣ��ϲ����� = [1,2,3] ����λ�� 2
 *          ���룺nums1 = [1,2], nums2 = [3,4] �����2.50000 ���ͣ��ϲ����� = [1,2,3,4] ����λ�� (2 + 3) / 2 = 2.5
 *
 * Ҫ��ʱ�临�Ӷ�O(log(m+n))
 * @Author hboy
 * @Date 2021/9/14 15:37
 * @Version 1.0.0
 */

public class FindMedianOfTwoArrays {

    // �����ƽ⡪��ð������ ������ʱ�临�Ӷ�Ҫ��
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ��λ��
        double medianNum = 0.00;
        int n1len = nums1.length;
        int n2len = nums2.length;
        if(n1len + n2len == 1){
            return n1len == 0 ? nums2[0] : nums1[0];
        }
        // ������ƴ������
        int[] newArr = mergeArrs(nums1,nums2);
        int newArrlen = newArr.length;
        // �ϲ�����Ϊż�����ȣ�ȡ��λ����Ҫ���м�����ֵ���/2
        if (newArrlen % 2 == 0) {
            medianNum = (double)(newArr[newArrlen / 2] + newArr[(newArrlen / 2) - 1]) / 2;
        }else{
            medianNum = newArr[newArrlen / 2];
        }

        return medianNum;
    }

    // �ϲ����鲢���򡪡�ð������
    private static int[] mergeArrs(int[] nums1, int[] nums2) {
        int n1len = nums1.length;
        int n2len = nums2.length;
        int[] newArr = new int[n1len + n2len];
        System.arraycopy(nums1,0,newArr,0,n1len);
        System.arraycopy(nums2, 0, newArr, n1len, n2len);
        // ð������
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
