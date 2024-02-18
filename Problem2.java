// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b)->{
            String[] arr1 = a.split(" ",2);
            String[] arr2 = b.split(" ",2);
            boolean dig1 = Character.isDigit(arr1[1].charAt(0));
            boolean dig2 = Character.isDigit(arr2[1].charAt(0));
            if(!dig1 && !dig2){
                int comp = arr1[1].compareTo(arr2[1]);
                if(comp == 0)
                    return arr1[0].compareTo(arr2[0]);
                return comp;
            }
            else if(!dig1 && dig2){
                return -1;
            }
            else if(dig1 && !dig2){
                return 1;
            }
            else{
                return 0;
            }
        });
        return logs;
    }
}