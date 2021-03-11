//Time - O(nlogn)
//Space - O(1)
class Solution {
public:
 
    bool static comp(string& a, string & b){
        string temp1 = a.substr(a.find(" "));
        string temp2 = b.substr(b.find(" "));
        if(temp1 == temp2){
            return a<b;
        }
        
        return temp1<temp2;
        
    }
    vector<string> reorderLogFiles(vector<string>& logs) {
        vector<string> vec;

        for(string str :logs){
            if(isalpha(str[str.size()-1])) vec.push_back(str);
        }

        sort(vec.begin(),vec.end(),comp);
        
        for(string str :logs){
            if(isdigit(str[str.size()-1])) vec.push_back(str);
        }
        
        return vec;
        
    }
};