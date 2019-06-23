// 179. Largest Number
// Given a list of non negative integers, arrange them such that they form the largest number.
// 
// Example 1:
// 
// Input: [10,2]
// Output: "210"
// Example 2:
// 
// Input: [3,30,34,5,9]
// Output: "9534330"
// Note: The result may be very large, so you need to 
// return a string instead of an integer.
class String179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) break;
            k++;
        }
        if (k == nums.length) return "0";
        
        List<Integer> sb = new ArrayList<Integer>();
        sb.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int size = sb.size();
            for (int j = 0; j < size; j++) {
                if (!helper(Integer.toString(sb.get(j)), Integer.toString(nums[i]))) {
                    sb.add(j, nums[i]);
                    break;
                }
            }
            if (size != sb.size()) {
                continue;
            } else {
                sb.add(nums[i]);
            }
        }
        
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < sb.size(); i++) {
            st.append(sb.get(i));
        }
        return st.toString();
         
    }
    private boolean helper(String s, String t) {
        // if (s == null || s.length() == 0) return false;
        // if (t == null || t.length() == 0) return true;
        
        int s1 = s.length();
        int t1 = t.length();
        int size = Math.min(s1, t1);
        int k = 0;
        while (k < size) {
            int i = s.charAt(k) - t.charAt(k);
            if (i > 0) return true;
            else if (i < 0) return false;
            else {
                k++;
            }
        }
        if (s1 == t1) {
            return true;
        } else if (s1 > t1) {
            return helper(s.substring(t1, s1), t);
        } else {
            return helper(s, t.substring(s1, t1));
        }
    }
}