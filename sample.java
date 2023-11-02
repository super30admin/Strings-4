//Problem 1: Atoi
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//skip spaces, check sign, add each digit to result, check if we are going out of bounds, return sign*result
class Solution {
    //O(n) 
    public int myAtoi(String input) {
       int sign = 1; 
        int result = 0; 
        int index = 0;
        int n = input.length();
        // skip initial spaces
        while (index < n && input.charAt(index) == ' ') { 
            index++; 
        }
        //Check for signs
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        //add each digit values to result.
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';
            if ((result > Integer.MAX_VALUE / 10) || 
                (result == Integer.MAX_VALUE / 10 &&
                 digit > Integer.MAX_VALUE % 10)) {     
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = 10 * result + digit;
            index++;
        }
        return sign * result;
    }
}

//Problem 2: Reorder Log Files
// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// do a compareTo operation on all the log files, first split to find if 2nd string is a digit, return same.

class Solution {
    // O(nlogn) //O(1)
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (String a, String b)->{
            String[] split1Arr=a.split(" ",2);
            String[] split2Arr=b.split(" ",2);

            boolean isDigit1= Character.isDigit(split1Arr[1].charAt(0));
            boolean isDigit2= Character.isDigit(split2Arr[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                int comp=split1Arr[1].compareTo(split2Arr[1]);
                if(comp==0)
                    return split1Arr[0].compareTo(split2Arr[0]);
                else
                    return comp;
            }
            else if(isDigit1 && !isDigit2)
                return 636;
            else if(!isDigit1 && isDigit2)
                return -2;
            else
                return 0;
        });

        return logs;
    }
}

