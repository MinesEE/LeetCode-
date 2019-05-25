// 11. Container With Most Water
// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
// 
// Note: You may not slant the container and n is at least 2.


class Array11 {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        
        int left = 0;
        int right = height.length - 1;
        
        int max = Math.min(height[left], height[right]) * right;
        
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left); // Here should be right - left
            max = Math.max(max, temp);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}