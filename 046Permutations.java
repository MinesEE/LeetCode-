/**
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
import java.util.*;

class 046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list  = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) return list;
        
        List<Integer> sublist = new ArrayList<Integer>();
        dfs(list, sublist, nums);
        
        return list;
    }
    public void dfs(List<List<Integer>> list, List<Integer> sublist, int[] nums) {
        if (sublist.size() == nums.length) {
            list.add(new ArrayList<Integer>(sublist)); //Most important line
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sublist.contains(nums[i])) continue;
            
            int len = sublist.size();
            sublist.add(nums[i]);
            dfs(list, sublist, nums);
            sublist.remove(len);
        }
    }
}