
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Any problem you faced while coding this :
//Approach
//1. split  each string in log to two part "keyword" and "value"
//2. If the digit after the keyword is digit then add to digit log
//3. if key word is let then compare and sort then in lexographical order

//Custom comparator should be written for that.
// Refer: https://www.techiedelight.com/sort-vector-pairs-cpp/


class comp{
  public:
    bool operator()(pair<string,string> s1, pair<string,string> s2){
         if(s1.second==s2.second) 
             return s1.first <s2.first;
        return s1.second<s2.second;
    }
};

class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
	vector<string> digitlogs;
	vector<pair<string,string>> letterlogs;
	size_t found=0;
	for(auto &s:logs){
	  found = s.find(" ");
	  if(isalpha(s[found+1])) letterlogs.push_back({s.substr(0,found),s.substr(found+1)});
	  else digitlogs.push_back(s);
	}
	sort(letterlogs.begin(), letterlogs.end(), comp());
	for(int i=0,j=letterlogs.size(); i<logs.size(); ++i){
	  if(i<j) logs[i]= letterlogs[i].first+" "+letterlogs[i].second;
	  else logs[i] = digitlogs[i-j];
	}
	return logs;
}
};
