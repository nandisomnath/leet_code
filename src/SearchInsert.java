/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

 

Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104


 */

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid = end / 2; // (0+nums.length) == (nums.length)


        // in last time the condition will be false beacause
        // that time start == mid, end == mid + 1 
        while (start < mid) {

            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] == target) {
                return mid;
            }

            // start have a value so I have to add it to get mid
            mid = (start + end) / 2;
        }

        
        if (target < nums[start]) {
            return start;
        }

        if (target > nums[end]) {
            return end + 1;
        }

        // if target need to place in middle like
        // nums[start] = 1, nums[end] = 3, target = 2.
        // in this case it will be shift end index.
        // in while loop this place is missed by mid value because mid value is 
        // more likely going to be equal with start value.
        if (nums[start] < target && target < nums[end]) {
            return end;
        }

        // This also miss by while loop because it break the loop when 
        // this condition comes true so I have to check it explicitly.
        if (nums[start] == target) {
            return start;
        }

        return end;

    }

    public static void main(String[] args) {
        int[] nums = { 1,3,5,6 };
        int target = 5;

        SearchInsert si = new SearchInsert();
        int n = si.searchInsert(nums, target);
        System.out.println(n);

    }
}

// 0 1 2 3 4 5 6 7 8 9
