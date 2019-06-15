// 69. Sqrt(x)
// Implement int sqrt(int x).
// 
// Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
// 
// Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
// 
// Example 1:
// 
// Input: 4
// Output: 2
// Example 2:
// 
// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since 
//              the decimal part is truncated, 2 is returned.
class Math69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        return binarySearch(x, 1, x);
        
    }
    
    private int binarySearch(int x, int left, int right) {
        if (left + 1 >= right) {
            if (right <= Math.sqrt(x)) {
                return right;
            } else {
                return left;
            }
        }
        
        int mid = left + (right - left) / 2;
        
        if (Math.sqrt(x) == mid) {
            return mid;
        } else if (Math.sqrt(x) < mid) {
            return binarySearch(x, left, mid - 1);
        } else {
            return binarySearch(x, mid, right);
        }
    }
}