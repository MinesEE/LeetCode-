// 136. Single number
// Given a non-empty array of integers, every element appears twice except for one. Find that single one.
// 
// Note:
// 
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
// 
// Example 1:
// 
// Input: [2,2,1]
// Output: 1
// Example 2:
// 
// Input: [4,1,2,1,2]
// Output: 4
class HashTable136 {
    // Use XOR
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int result = 0;
        for (int i = 0; i < nums.length;i++) {
            result  = result ^ nums[i];
        }
        return result;
        
        
        
        
//     public int singleNumber(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
//         if (nums.length == 1) return nums[0];
//         
//         HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//         for (int i = 0; i < nums.length; i++) {
//             if (hashMap.containsKey(nums[i])) {
//                 hashMap.remove(nums[i]);
//             } else {
//                 hashMap.put(nums[i], 1);
//             }
//         }
//         for (Integer k: hashMap.keySet()) {
//             if (hashMap.get(k) == 1) {
//                 return k;
//             }
//         }
//         return 0;
     }
}