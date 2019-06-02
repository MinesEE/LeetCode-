// 93. Restore IP Addresses
// Given a string containing only digits, restore it by returning all possible valid IP address combinations.
// 
// Example:
// 
// Input: "25525511135"
// Output: ["255.255.11.135", "255.255.111.35"]
class String93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        if (s.length() > 12) return list;
        dfs(list, new StringBuilder(), s, 0, 0);
        return list;
        
    }
    
    private void dfs(List<String> list, StringBuilder sb, String s, int ipIndex, int strIndex) {
        if (ipIndex > 4) return;
        if (ipIndex == 4 && strIndex == s.length()) {
            sb.setLength(sb.length() - 1);
            list.add(sb.toString());
            return;
        }
        int length = sb.length();
        for (int i = 0; i < 3; i++) {
            if (strIndex + i < s.length()) {
                String subStr = s.substring(strIndex, strIndex + i + 1);
            
                if (isValid(subStr)) {
                    sb.append(subStr);
                    sb.append('.');
                    dfs(list, sb, s, ipIndex + 1, strIndex + i + 1);
                    sb.setLength(length);
                }
            } else break/return;
        }
    }
    private boolean isValid(String str) {
        if (str.charAt(0) == '0') {
            return str.equals("0");
        }
        int num = Integer.parseInt(str);
        if (num >=0 && num <= 255) return true;
        return false;
    }
}