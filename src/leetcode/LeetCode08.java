package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

/**
 * @className: LeetCode08
 * @description:
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器
 * 可以容纳最多的水。
 *
 * 示例 1：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 2：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 示例 3：
 * 输入：height = [1,2,1]
 * 输出：2
 * @author: Miluo
 * @date: 2021/4/16
 **/
public class LeetCode08 {
    public int maxArea(int[] height) {
        ArrayList<Integer> list = new ArrayList<>();
        int x = 0,y = height.length - 1;
        int max = 0 ;
        while (x < y){
            if (height[x] < height[y]) {
                max = Math.max(max,height[x] * (y - x));
                x++;
            } else {
                max = Math.max(max,height[y] * (y - x));
                y--;
            }
        }
        return max;
    }
}
