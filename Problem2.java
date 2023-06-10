/*
String to Integer (atoi)
approach: handle different edge cases
time: O(n)
space: O(1)
 */
public class Problem2 {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length()==0) return 0;
        char first = s.charAt(0);
        char sign = '+';
        if (!(first == '+' || first == '-') && !Character.isDigit(first)) return 0;
        if (first=='-') sign = first;
        int res = 0;int limit = Integer.MAX_VALUE/10;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            boolean isDigit = Character.isDigit(c);
            if (isDigit) {
                if (sign=='+') {
                    if (res>limit) return Integer.MAX_VALUE;
                    if (res==limit) {
                        if (c-'0' >= 7) return Integer.MAX_VALUE;
                    }
                } else {
                    if (res>limit) return Integer.MIN_VALUE;
                    if (res==limit) {
                        if (c-'0' >= 8) return Integer.MIN_VALUE;
                    }
                }
                res = res*10+(c-'0');
            } else if (i!=0 && !isDigit) {
                break;
            }
        }
        return sign=='-'?res*-1:res;
    }
}
