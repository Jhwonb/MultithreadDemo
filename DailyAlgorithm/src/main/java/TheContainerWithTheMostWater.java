/**
 * @Title TheContainerWithTheMostWater
 * @Description ʢ���ˮ���������������
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����(i,ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i�������˵�ֱ�Ϊ(i,ai) �� (i, 0) ���ҳ����е������ߣ�ʹ��������x�Ṳͬ���ɵ�����������������ˮ��
 * ���룺height = [1,8,6,2,5,4,8,3,7] �����49 ���ͣ�ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ49��
 * ���룺height = [4,3,2,1,4]  �����16
 * Difficulty �е�
 * @Author hboy
 * @Date 2021/9/28 14:40
 * @Version 1.0.0
 */

public class TheContainerWithTheMostWater {

    /**
     * ����˫ָ���˼��
     * �߶�ֻȡ������������˵���Сֵ
     * @author houby
     * @param height
     * @return int
     * @date 2021/9/28 16:27
     */
    public static int maxArea(int[] height) {
        // ˫ָ�룬һ��ָ��ͷ��һ��ָ��β
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
