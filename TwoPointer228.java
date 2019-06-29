// 228. Summary Ranges
// Given a sorted integer array without duplicates, return the summary of its ranges.
// 
// Example 1:
// 
// Input:  [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
// Example 2:
// 
// Input:  [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
class TwoPointer228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        
        if (nums == null || nums.length == 0) return list;
        
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) continue;
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[p]);
                if (i - p > 1) {
                    sb.append('-');
                    sb.append('>');
                    sb.append(nums[i - 1]);
                }
                list.add(sb.toString());
                p = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[p]);
        if (nums.length - p > 1) {
            sb.append('-');
            sb.append('>');
            sb.append(nums[nums.length - 1]);
        }
        list.add(sb.toString());
        return list;
    }
}