class String8 {
    public int myAtoi(String str) {
        str = str.trim();
        int num = 0;
        int sign = 1;
        char curState = 's';
        
        for (int i = 0; i < str.length(); i++) {
            curState = transition(curState, str.charAt(i));
            if (curState == 'N') sign = -1;
            if (curState == 'F') return num * sign;
            
            if (curState == 'S') {
                int val = (int) str.charAt(i) - '0';
                int next = num * 10 + val;
                if (next / 10 != num) return (sign == 1) ? Integer.MAX_VALUE: Integer.MIN_VALUE;
                num = next;
            }
        }
        if (curState == 's' || curState == 'P' || curState == 'N') return 0;
        return num * sign;
    }
    
    private char transition(char curState, char cur) {
        switch (curState) {
            case 's':
                if (cur == '+') return 'P';
                else if (cur == '-') return 'N';
                else if (Character.isDigit(cur)) return 'S';
                else return 'F';
            case 'S':
                if (Character.isDigit(cur)) return 'S';
                else return 'F';
            case 'N':
                if (Character.isDigit(cur)) return 'S';
                else return 'F';
            case 'P':
                if (Character.isDigit(cur)) return 'S';
                else return 'F';
            default:
                return 'F';
        }
    }
}