// Time Complexity : O(m * n log n), where m is average log length, n is #logs, n log n for sorting, O(m) for comparing log, split()
// Space Complexity : O(m log n), recursion call stack, O(m) to store split and log n for sorting  
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// implement custom comparator, check if logs are digit type, if yes treat as equal, move digit type to end
// for word type compare substring after log identifier word, if they match compare identifiers

class Solution {
    class CustomComparator implements Comparator<String>{
        public int compare(String log1, String log2){
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            if(isDigit1 && isDigit2){
                return 0;
            }
            else if(isDigit1){
                return 1;
            }
            else if(isDigit2){
                return -1;
            }
            else{
                int res = split1[1].compareTo(split2[1]);
                if(res==0)
                    return split1[0].compareTo(split2[0]);
                else return res;
                
            }
        }    
    }
    
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new CustomComparator());
        return logs;
    }
}