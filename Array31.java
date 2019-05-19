// 31. Next Permutation
// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
// 
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
// 
// The replacement must be in-place and use only constant extra memory.
// 
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
class Array31 {
    public void nextPermutation(int[] nums) {
        
        int N = nums.length - 1;
        int ind = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(nums, 0, N);
            return;
        }
        for (int i = ind + 1; i <= N; i++) {
            if (nums[i] <= nums[ind]) { // <= not <
                int temp = nums[ind];
                nums[ind] = nums[i-1];
                nums[i-1] = temp;
                break;
            } else if (i < N){
                continue;
            } else {
                int temp = nums[ind];
                nums[ind] = nums[N];
                nums[N] = temp;
            }
        }
        
        reverse(nums, ind + 1, N);
        return;

        
    }
    private void reverse(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        
        for (int i = left; i <= mid; i++) {
            int temp = nums[i];
            nums[i] = nums[right - i + left];
            nums[right - i + left] = temp;
        }
    }
}