// 84. Largest Rectangle in Histogram
// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
// 
//  
// 
// 
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
// 
//  
// 
// 
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
// 
//  
// 
// Example:
// 
// Input: [2,1,5,6,2,3]
// Output: 10
class Greedy84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int max = 0;
        
        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];
        lessFromLeft[0] = -1;
        lessFromRight[heights.length - 1] = heights.length;
        
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        
        for (int j = heights.length - 2; j >= 0; j--) {
            int p = j + 1;
            while (p <= heights.length - 1 && heights[p] >= heights[j]) {
                p = lessFromRight[p];
            }
            lessFromRight[j] = p;
        }
        
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return max;
    }
}