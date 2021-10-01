# Strings-4

## Problem1: Atoi (https://leetcode.com/problems/string-to-integer-atoi/)

//Time Complexity = O(N)
// Space Complexity = O(1)

class Solution {
public int myAtoi(String s) {
if(s == null || s.length() == 0) {
return 0;
}

        s = s.trim();

        if(s.length() == 0) {
            return 0;
        }

        char sign = '+';
        char first = s.charAt(0);
        if(first == '-') {
            sign = '-';
        }
        if(first != '-' && first != '+' && !Character.isDigit(first)) {
            return 0;
        }

        int result = 0;
        int limit = Integer.MAX_VALUE / 10;
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = c - '0';
            if(Character.isDigit(c)) {
                if(sign =='+') {
                    if(result > limit) {
                        return Integer.MAX_VALUE;
                    } else if(result == limit && val > 7) {
                         return Integer.MAX_VALUE;
                    }
                } else {
                     if(result > limit) {
                        return Integer.MIN_VALUE;
                    } else if(result == limit && val > 8) {
                         return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + val;
            } else if(i != 0) {
                break;
            }
        }
        if(sign == '-') {
            return -result;
        }
        return result;
    }

}

## Problem2: Reorder Log files data (https://leetcode.com/problems/reorder-data-in-log-files/)

//Time Complexity = O(NklogN)
// Space Complexity = O(1)

class Solution {
public String[] reorderLogFiles(String[] logs) {
if(logs == null || logs.length == 0) {
return new String[0];
}

        Arrays.sort(logs, (l1,l2) -> {
            String[] str1 = l1.split(" ", 2);
            String[] str2 = l2.split(" ", 2);

            boolean isDigitlog1 = Character.isDigit(str1[1].charAt(0));
            boolean isDigitlog2 = Character.isDigit(str2[1].charAt(0));

            if(!isDigitlog1 && !isDigitlog2) {
                int comp = str1[1].compareTo(str2[1]);
                if(comp == 0) {
                    return str1[0].compareTo(str2[0]);
                }
                return comp;
            } else if(isDigitlog1 && !isDigitlog2) {
                return 1;
            } else if(!isDigitlog1 && isDigitlog2) {
                return -1;
            } else {
                return 0;
            }

        });
        return logs;
    }

}
