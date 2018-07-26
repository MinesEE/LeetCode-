/**
Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
class 046PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) return list;
    
    Arrays.sort(nums); // Sort is very important 
    List<Integer> sublist = new ArrayList<Integer>();
    boolean[] blist = new boolean[nums.length];
    dfs(list, sublist, blist, nums);
    
    return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> sublist, boolean[] blist, int[] nums) {
        if (sublist.size() == nums.length) {
            list.add(new ArrayList<Integer>(sublist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (blist[i] == true) continue;
            
            sublist.add(nums[i]);
            blist[i] = true;
            dfs(list, sublist, blist, nums);
            blist[i] = false;
            sublist.remove(sublist.size()-1);
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}