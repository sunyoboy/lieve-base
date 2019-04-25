package com.lieve.leetcode;

import sun.security.util.BitArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: sunyoboy@gmail.com
 * Date: 19/2/22
 * Time: 上午8:49
 */
public class Sum {

    public int sum(int a, int b) {
        if (b == 0) {
            return a;
        }

        int sumValue = a ^ b;
        int carray = (a & b) << 1; // carray 为进位
        return sum(sumValue, carray);

        /**
         * A^B 表示A + B 中每位不进位的和,
         * (A&B) << 1 表示 A+B 表示每一位相加的进位
         * A,B 分别可取00,01,10,11.
         * 组合位00与01, 00与10, 00与11, 01与10, 01与11, 10与11.
         * 分析: A: 0b01, B: 0b10, A^B = 0b11 A&B = 0b00
         *      A: 0b01, B: 0b11, A^B = 0b10, A&B = 0b01
         *      A: 0b10, B:0b11, A^B = 0b01, A&B = 0b10
         */
    }

static class Solution {
    public int sum(int a, int b) {
        if (b ==0) {
            return a;
        }

        int sumValue = a ^ b;
        int carray = (a & b) << 1;
        while (carray !=0 ) {
            a = (sumValue ^ carray);
            b = (sumValue & carray) << 1;
            sumValue = a;
            carray = b;
        }
        return sumValue;
    }

    /**
     *
     *  1 ^ 11 : 2
        1 ^ 11 : 2
        11 ^ 11 : 0
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        traversal(nums, result);
        return result;
    }

    public void traversal(int[] nums, List<Integer> result) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
    }

    public int findMinPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return 0;
    }

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        return findMinPositive(nums);
    }
}


    public static void main(String[] args) {
        /*System.out.println(new Sum().sum(1,2));
        System.out.println(new Sum().sum(-2,3));
        int n = 8;
        int b = 0b1000;
        int fourthBitFromRight = (n & (1 << 3)) >> 3;
        System.out.println(fourthBitFromRight);
        fourthBitFromRight = (n & 0b1000) / 0b1000;
        System.out.println(n);
        // System.out.println(b);
        System.out.println(fourthBitFromRight);*/
        // int[] nums = {1,1,3};
        int[] nums = {4,3,2,7,8,2,3,1};
        int[] nums2 = {1,2,0};
        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap;
        // System.out.println(new Solution().findDisappearedNumbers(nums));
        System.out.println(new Solution().findMinPositive(nums2));

    }
}
