// Problem: Reorder Data in Log Files
// Time complexity: O(n log n), where n is the number of logs.
// Space complexity: O(n), where n is the number of logs.
// Did this code run successfully on LeetCode: Yes

// approach:
// 1. Separate letter logs and digit logs.
// 2. Sort letter logs by content, then by identifier.
// 3. Concatenate letter logs with digit logs at the end.

#include <vector>
#include <string>
#include <algorithm>
using namespace std;
class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        vector<string> letterLogs;
        vector<string> digitLogs;

        for (const string& log : logs) {
            int pos = log.find(' ');
            if (isdigit(log[pos + 1])) {
                digitLogs.push_back(log);
            } else {
                letterLogs.push_back(log);
            }
        }

        sort(letterLogs.begin(), letterLogs.end(), [](const string& a, const string& b) {
            int idxA = a.find(' ');
            int idxB = b.find(' ');

            string idA = a.substr(0, idxA);
            string contentA = a.substr(idxA + 1);
            string idB = b.substr(0, idxB);
            string contentB = b.substr(idxB + 1);

            if (contentA != contentB)
                return contentA < contentB;
            return idA < idB;
        });

        // Concatenate
        letterLogs.insert(letterLogs.end(), digitLogs.begin(), digitLogs.end());
        return letterLogs;
    }
};
