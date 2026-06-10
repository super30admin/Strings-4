// Time Complexity : O(k * nlogn), k = number of logs
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We sort the input array of logs by using custom comparator where we initially split the logs into 2 parts
using white spaces. Now, as per problem statement, we have to compare the second part of split arrays and
rearrange them. So we identify if the second part is a letter or a digit. If both are digits, do nothing.
If one is letter and other is digit, we swap them such that letter comes first. If both are letters, we compare
them lexicographically and return the comparator value,but, if both letters are equal we compare using the first
part which acts as an identifier.
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] splitArr1 = a.split(" ", 2);
            String[] splitArr2 = b.split(" ", 2);

            boolean isDigit1 = Character.isDigit(splitArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitArr2[1].charAt(0));

            if(!isDigit1 && !isDigit2) {
                int cmp = splitArr1[1].compareTo(splitArr2[1]);
                if(cmp == 0) {
                    return splitArr1[0].compareTo(splitArr2[0]);
                }
                return cmp;
            }
            else if(!isDigit1 && isDigit2) {
                return -24; //dont swap
            }
            else if(isDigit1 && !isDigit2) {
                return 23; //swap instruction
            }
            else {
                return 0;
            }

        });
        return logs;
    }
}