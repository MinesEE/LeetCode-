// 169. Majority Element
// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
// 
// You may assume that the array is non-empty and the majority element always exist in the array.
// 
// Example 1:
// 
// Input: [3,2,3]
// Output: 3
// Example 2:
// 
// Input: [2,2,1,1,1,2,2]
// Output: 2

// Majority Voting Algorithm 
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int count = 1;
        int candidate = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                candidate = nums[i];
            } else {
                if (candidate != nums[i]) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        return candidate;
    }
}


// Hashmap solution容易理解，但是空间复杂度太高了
class Array169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash.put(nums[i], hash.get(nums[i]) + 1);
                if (hash.get(nums[i]) > nums.length / 2) {
                    return nums[i];
                }
            } else {
                hash.put(nums[i], 1);
            }
        }
        return nums[0];
    }
}