//atoi
class Solution {
public:
    int myAtoi(string str) {
        int i =0;
        int sign = 1;
        long res = 0;
        while(i < str.length() && str[i]==' ')
            i++;
        if(str[i] == '-' || str[i] == '+')
        {    
            sign = (str[i] == '-')?-1:1;
            i++;
        }
        while(i < str.length() && str[i] >= '0' && str[i] <= '9')
        {
            res = 10*res + sign*(str[i]-'0');
            i++;
            if(res < INT_MIN)
                return INT_MIN;
            else if(res > INT_MAX)
                return INT_MAX;
        }
        
        return res;
        
    }
};
