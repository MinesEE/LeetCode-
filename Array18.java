// 18. 4Sum
// Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
// 
// Note:
// 
// The solution set must not contain duplicate quadruplets.
// 
// Example:
// 
// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
// 
// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]
// Accepted
// 232,553
// Submissions
// 763,204
// Seen this question in a real interview before?
class Array18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        if (nums.length <= 3) return list;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
                while (nums[j] == nums[j + 1] && j < nums.length - 3) {
                    j++;
                }
            }
            while (nums[i] == nums[i +1] && i < nums.length - 4) {
                i++;
            }
        }
        return list;
    }
}