// TC: O(n)
// SC: O(1)

public class LC8 {
    public int myAtoi(String s) {
        int ans = 0;
        int ul = Integer.MAX_VALUE;
        int ll = Integer.MIN_VALUE;
        boolean isPositive = true;
        int n = s.length();
        // Remove Leading Spaces
        int i=0;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        // Check Sign
        if(i<n && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            if(s.charAt(i)=='-') isPositive = false;
            i++;
        }
        int sign = (!isPositive) ? -1 : 1;
        // Conversion
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            char ch = s.charAt(i);
            int digit = ch-'0';
            if(isPositive){
                if(ans > (ul-digit)/10) return ul;
            } else {
                if(ans < (ll+digit)/10) return ll;
            }
            ans = (ans*10) + sign * digit;
            i++;
        }
        return ans;
    }
}