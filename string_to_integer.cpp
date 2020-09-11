//Time Complexity: O(n)
//Space complexity: O(1)
//Approach
//1. Traverse to remove all the spaces in the front
//2. Derive the sign if present
//3. Traverse till you find a digit and add it to the result
//4. Maintain a max_digit:INT_MAX/10 to handle the over and underflow situation

class Solution {
public:
    int myAtoi(string str) {
        //edge
        if(str.length()==0)
            return 0;
        
        //logic
        int i=0;
        while(str[i] ==' '){
            i++;
        }
        string new_str = str.substr(i);
        //cout<<new_str<<endl;
        if(!isdigit(new_str[0]) && new_str[0] !='-' && new_str[0] !='+'){
            return 0;
        }
        
        char sign ='+';
        if(new_str[0] =='-'){
            sign = '-';
        }
        int max_limit = INT_MAX/10;
       // cout<<INT_MIN<<endl;
        int num =0;
        for(i=0;i<new_str.length();i++){
            if(!isdigit(new_str[i]) && i!=0){
                break;
            }
            if(i==0 &&(new_str[i] =='-' || new_str[i] =='+')){
                continue;
            }
            //a valid digit is found but the number has already exceeded integer bound
            if(num>max_limit){
                 return sign =='+'? INT_MAX: INT_MIN;
             }
            
            
            if(num<max_limit){
                num = num*10 + new_str[i]-'0';
                //cout<<num<<endl;
            }else if(num == max_limit){ //check edge cases
                if(sign=='+'){
                    if((new_str[i]-'0') >= 7)
                        return INT_MAX;
                    else
                        return (num*10 + (new_str[i]-'0'));
                }else if(sign == '-'){
                     if((new_str[i]-'0') >= 8)
                        return INT_MIN;
                    else
                        return -(num*10 + (new_str[i]-'0'));
                }
            }
        }
        
        if(sign == '-')
            return -num;
        else return num;
    }
};
