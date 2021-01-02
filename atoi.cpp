class Solution {
public:
    int myAtoi(string str) {
        int sign=1;
        while (str[0]==' ') {
            str.erase(str.begin());
        }
        
        if (str[0]=='-' || str[0]=='+') {
            if (str[0]=='-') {
                sign=-1;
            }
            str.erase(str.begin());
        }
        int i=0;
        long long int sum=0;
        if (isdigit(str[i])) {
            while(isdigit(str[i]) && sum<=INT_MAX) {
                if(!isdigit(str[i])) 
                    break;
                
                sum= sum*10 + (str[i]-'0');
                i++;
            }
        }
        
        if(sum>INT_MAX && sign<0) 
            return INT_MIN;
        if(sum>INT_MAX && sign>0)
            return INT_MAX;
            
        return sign*sum;
    }
};