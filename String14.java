class String14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int ind = 0;
        for (int i = strs[0].length(); i >= 0; i--) {
            String temp = strs[0].substring(0, i);
            
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].indexOf(temp) != 0) {
                    ind = 0;
                    break;
                } else {
                    ind++;
                }
            }
            if (ind == strs.length - 1) {
                return temp;
            }
        }
        return "";
    }
}