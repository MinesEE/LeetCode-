// 229. Majority Element II
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
// 
// Note: The algorithm should run in linear time and in O(1) space.
// 
// Example 1:
// 
// Input: [3,2,3]
// Output: [3]
// Example 2:
// 
// Input: [1,1,1,3,3,2,2,2]
// Output: [1,2]
class Array229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) return list;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (!list.contains(nums[i]) && map.get(nums[i]) > nums.length / 3) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}