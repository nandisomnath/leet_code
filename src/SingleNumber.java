/*
136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1

Constraints:

    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.
 
 */

import java.util.HashMap;

public class SingleNumber {

  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> count = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      Integer c = count.get(nums[i]);
      if (c == null) {
        count.put(nums[i], 1);
      } else {
        count.put(nums[i], c + 1);
      }
    }

    for (int key : count.keySet()) {
      Integer value = count.get(key);
      if (value == 1) {
        return key;
      }

    }

    return nums[0];
  }

  public static void main(String[] args) {

  }

}
