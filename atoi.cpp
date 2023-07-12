// Time Complexity - O(l), l is thr length of input string.
// Space Complexity - O(1).

class Solution {
public:
    int myAtoi(string s) {
        int idx = s.find_first_not_of(' ');
        if(idx != -1)
            s = s.substr(idx);
        
        if(s.length() == 0)
            return 0;
        
        int limit = INT_MAX/10;
        
        if(!isdigit(s[0]) && s[0] != '+' && s[0] != '-')
            return 0;
        
        char sign = (s[0] == '-') ? '-' : '+';
        
        int l = s.length();
        int answer = 0;
        char curr;
        int digit;
        for(int i = 0; i < l; i++){
            curr = s[i];
            if(isdigit(curr)){
                digit = curr - '0';
                if(sign == '+'){
                    if(answer > limit)
                        return INT_MAX;
                    else if(answer == limit && digit >= 7)
                        return INT_MAX;
                }
                else{
                    if(answer > limit)
                        return INT_MIN;
                    else if(answer == limit && digit >= 8)
                        return INT_MIN;
                }
                answer = answer*10 + digit;
            }
            else if(i != 0)
                break;
        }

        return (sign == '-') ? -1*answer : answer;
    }
};