//Time - O(1)
//space - O(1)
class Solution {
public:
    int myAtoi(string s) {
        int sign = 1;
        int i = 0;
        while(s[i] == ' '){
            i++;
        }
        
        if(s[i] == '+'){
            sign = 1;
            i++;
        }else if(s[i] == '-'){
            sign = -1;
            i++;
        }

        int result = 0;
        
        while(i<s.size() && s[i]>='0' && s[i]<='9'){
            if(result>INT_MAX/10 || (result == INT_MAX/10 && s[i]>'7')){
                if(sign == 1) return INT_MAX;
                else return INT_MIN;
                
            }
            
            result = result*10 + (s[i++]-'0');
        }
        
        return result*sign;
    }
};