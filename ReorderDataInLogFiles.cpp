// Time Complexity - O(l*nlogn), l is the avg length of each log, n are the total number of logs.
// Space Copmlexity - O(l*k), l is the avg length of eaach log, k is the number of comparisions. Is this correct?

class Solution {
    pair<string, string> breakStr(const string& str) {
        pair<string, string> p;
        int spaceIdx = str.find(' ');
        p.first = str.substr(0, spaceIdx); 
        p.second = str.substr(spaceIdx + 1); 
        return p;
    }

public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        stable_sort(logs.begin(), logs.end(), [&](const string& str1, const string& str2) {
            pair<string, string> s1 = breakStr(str1);
            pair<string, string> s2 = breakStr(str2);

            bool isDigit1 = isdigit(s1.second[0]);
            bool isDigit2 = isdigit(s2.second[0]);

            if (!isDigit1 && !isDigit2) {
                if (s1.second == s2.second) {
                    return s1.first < s2.first;
                } else {
                    return s1.second < s2.second;
                }
            } else if (!isDigit1 && isDigit2) {
                return true;  // str1 is a letter-log, str2 is a digit-log
            } else if (isDigit1 && !isDigit2) {
                return false;  // str1 is a digit-log, str2 is a letter-log
            } else {
                return false;  // str1 and str2 are both digit-logs
            }
        });

        return logs;
    }
};