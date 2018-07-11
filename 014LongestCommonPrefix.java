public class 014LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    
	    String first = strs[0];
	    for (int i = 0; i < first.length(); i++) {
	        for (int j = 1; j < strs.length; j++) {
	            if (i >= strs[j].length() || first.charAt(i) != strs[j].charAt(i)) {
	                return first.substring(0, i);
	            }
	        }
	    }
	    return first;
	}
}