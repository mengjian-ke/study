package com.data_structure.leetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * <p>
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 * <p>
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/4/17 03:09
 */
public class NextGreaterElementI {

    class Solution {
        public int[] nextGreaterElement(int[] nums1,
                                        int[] nums2) {
            // [1,3,4,2]
            final HashMap<Integer, Integer> intsMap = new HashMap<>();
            final Stack<Integer> sta = new Stack<>();
            for (int i : nums2) {
                while (!sta.isEmpty() && i > sta.peek()) {
                    intsMap.put(
                            sta.pop(),
                            i
                    );
                }
                sta.push(i);
            }

            sta.forEach(a -> intsMap.put(a,
                                         -1));

            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                int key = nums1[i];
                result[i] = intsMap.get(key);
            }
            return result;
        }

        public int[] nextGreaterElement1(int[] nums1,
                                         int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] res = new int[nums1.length];
            for (int value : nums2) {
                while (!stack.empty() && value > stack.peek()) {
                    map.put(
                            stack.pop(),
                            value
                    );
                }
                stack.push(value);
            }
            while (!stack.empty()) {
                map.put(
                        stack.pop(),
                        -1
                );
            }
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }

    @Test
    public void demo1() {
        int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(
                nums1,
                nums2
        )));
    }

}
