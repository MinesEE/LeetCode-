// 219. Contains Duplicate II
// Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
// 
// Example 1:
// 
// Input: nums = [1,2,3,1], k = 3
// Output: true
// Example 2:
// 
// Input: nums = [1,0,1,1], k = 1
// Output: true
// Example 3:
// 
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
class HashTable219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if ( k <= 0 || nums == null || nums.length == 0) return false;
        
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                if (Math.abs(hashMap.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    hashMap.put(nums[i], i);
                }
                
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }
}