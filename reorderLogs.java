// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use a custom comparator to sort the logs according to the constraints
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return logs;

        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean digit1 = Character.isDigit(split1[1].charAt(0));
            boolean digit2 = Character.isDigit(split2[1].charAt(0));

            if (!digit1 && !digit2) {
                // both are Strings

                //check if both strings are the same
                if(split1[1].equals(split2[1])) {
                    return split1[0].compareTo(split2[0]);
                }

                return split1[1].compareTo(split2[1]);
            }
            else if (digit1 && !digit2) {
                // First is Digit and second is String, so we place string first
                return 1;
            }
            else if (!digit1 && digit2) {
                // First is String and second is Digit, so we place string first
                return -1;
            }
            else {
                // both are digits, hence we keep the original order
                return 0;
            }
        });

        return logs;
    }
}