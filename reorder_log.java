//TC: O(m*nlog(n)) n - no of logs and m the length of each log
//SC: O(m*log(n))
//leetcode : successful


//approach: custom sort
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //custom sort
        
        Arrays.sort(logs,(a,b)->{
            String [] a1 = a.split(" ",2);
            String [] b1 = b.split(" ",2);
            boolean isDigit1 = Character.isDigit(a1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(b1[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int comp = a1[1].compareTo(b1[1]);
                if(comp !=0){
                    return comp;
                }
                else
                    return a1[0].compareTo(b1[0]);
            }
            else if(!isDigit1 && isDigit2)
                return -1;
            else if(isDigit1 && !isDigit2)
                return 1;
            else 
                return 0; 
        });
        return logs;
    }
    
}