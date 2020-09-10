// Time Complexity : O(n log(n) * l) --> where n is the length of the input string array and l is the average length of each string (this is because of using compareTo function)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (937): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String s1Arr[] = s1.split(" ", 2);
            String s2Arr[] = s2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1Arr[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2Arr[1].charAt(0));
            
            if (!isDigit1 && !isDigit2) {
                int comp = s1Arr[1].compareTo(s2Arr[1]);
                if (comp == 0) return s1Arr[0].compareTo(s2Arr[0]);
                else return comp;
            }
            else if (!isDigit1 && isDigit2) return -1;
            else if (isDigit1 && !isDigit2) return 1;
            else return 0;
        });
        
        return logs;
    }
}