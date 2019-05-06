class Array128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) continue;
            if (hash.containsKey(nums[i] - 1) && !hash.containsKey(nums[i] + 1)) {
                int temp = hash.get(nums[i] - 1);
                hash.put(nums[i], temp + 1);
                hash.put(nums[i] - temp, temp + 1);
                max = Math.max(max, temp + 1);
            } else if (!hash.containsKey(nums[i] - 1) && hash.containsKey(nums[i] + 1)) {
                int temp = hash.get(nums[i] + 1);
                hash.put(nums[i], temp + 1);
                hash.put(nums[i] + temp, temp + 1);
                max = Math.max(max, temp + 1);
            } else if (hash.containsKey(nums[i] - 1) && hash.containsKey(nums[i] + 1)) {
                int temp1 = hash.get(nums[i] - 1);
                int temp2 = hash.get(nums[i] + 1);
                hash.put(nums[i] - temp1, temp1 + temp2 + 1);
                hash.put(nums[i] + temp2, temp1 + temp2 + 1);
                max = Math.max(max, temp1 + temp2 + 1);
            } else {
                hash.put(nums[i], 1);
            }
        }
        return max;
    }
}