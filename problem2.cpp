#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution {
public:
    int myAtoi(string s) {
        long long int s_len = s.size();
        int i{};
        long long int res{};
        bool flag{false};
        //if (s_len == 0) return 0;
        while(i<s_len && s.at(i) == ' '){
            ++i;
        }
        if(i<s_len && s.at(i)=='-'){
            ++i;
            flag = true;
        }
        else if(i<s_len && s.at(i) == '+'){
            ++i;
        }
        while(res <= INT_MAX && res >= INT_MIN && i<s_len && isdigit(s.at(i)) ){
            res = res*10 + int(s.at(i)) - 48;
            ++i;
            if(flag && -1*res<INT_MIN) return INT_MIN;
            if(!flag && res>INT_MAX) return INT_MAX;
        }
        return flag?-res:res;
        
    }
};