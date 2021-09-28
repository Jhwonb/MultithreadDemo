/**
 * @Title TheContainerWithTheMostWater
 * @Description 盛最多水的容器（求面积）
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 输入：height = [1,8,6,2,5,4,8,3,7] 输出：49 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * 输入：height = [4,3,2,1,4]  输出：16
 * Difficulty 中等
 * @Author hboy
 * @Date 2021/9/28 14:40
 * @Version 1.0.0
 */

public class TheContainerWithTheMostWater {

    /**
     * 采用双指针的思想
     * 高度只取决于数组的两端的最小值
     * @author houby
     * @param height
     * @return int
     * @date 2021/9/28 16:27
     */
    public static int maxArea(int[] height) {
        // 双指针，一个指向头，一个指向尾
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
