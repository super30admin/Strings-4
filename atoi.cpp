//Time : O(n) where n is the length of the string
//Space : O(1)
class Solution {
public:
    int myAtoi(string str) {
        int i = str.find_first_not_of(' ');
        if(str.empty() || i == -1)
            return 0;
        int result = 0;
        int sign = 1;
        int limit = INT_MAX/10;
        if(str[i] == '-' || str[i] == '+'){
            sign = (str[i++] == '-')?-1:1;
        }
        while(i < str.length() && isdigit(str[i])){
            if(result > limit || (result == limit && (str[i] - '0' > 7))){
                if(sign == 1 ) return INT_MAX;
                if(sign == -1) return INT_MIN;
            }
            result = result * 10 + (str[i++] - '0');
        }
        return result*sign;
    }
};