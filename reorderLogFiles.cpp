class Solution {
public:
    static bool compare(const pair<string,pair<string,string>> a,const pair<string,pair<string,string>> b) {
    if (a.second.second==b.second.second) return a.second.first<b.second.first;
    return a.second.second<b.second.second;
}
    
vector<string> reorderLogFiles(vector<string> files) {
     vector<pair<string,pair<string,string>>> p;
     vector<string> answer,digits;
    
    for (auto x:files) {
        string s=x;
        size_t pos = s.find(' ');
        string index = s.substr(0,pos);
        string body = s.substr(pos+1);
        if ( !isdigit(body[0]) ) {
            p.push_back({s,{index,body}});
        } else {
            digits.push_back(s);
        }
    }
    
    sort(p.begin(),p.end(),compare);
    for (auto x:p) {
        answer.push_back(x.first);
    } 
    for (auto x: digits) {
        answer.push_back(x);
    }
    
    return answer;
}
};