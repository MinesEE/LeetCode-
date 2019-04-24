/** 
Given an array of integers, return indices of the two 
numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, 
and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.*;
// public class 001TwoSum {
//     public int[] twoSum(int[] nums, int target) {
//     	int[] index = new int[]{-1, -1};
//     	if (nums == null || nums.length < 2) {
//     		return index;
//     	}
//     	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//     	for (int i = 0; i < nums.length; i++) {
//     		if (map.containsKey(target - nums[i])) {
//     			index[0] = map.get(target - nums[i]);
//     			index[1] = i;
//     			return index;
//     		} else {
//     			map.put(nums[i], i);
//     		}
//     	}
//     	return index;
//     }
// }

public class 001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                index[0] = hash.get(target - nums[i]);
                index[1] = i;
                return index;
            } else {
                hash.put(nums[i], i);
            }
        }
        index[0] = -1;
        index[1] = -1;
        return index;
    }
}