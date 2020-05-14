// Time Complexity : nlogn
// Space Complexity :n
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1,s2) -> {
            String[] str1=s1.split(" ",2);
            String[] str2=s2.split(" ",2);
            
       
    boolean isLetter1 = Character.isAlphabetic(str1[1].charAt(0));  
    boolean isLetter2 = Character.isAlphabetic(str2[1].charAt(0));  
            if(isLetter1 && isLetter2)
            {
             int diff=str1[1].compareTo(str2[1]);
                 if(diff ==0){
                     return str1[0].compareTo(str2[0]);
                 }
                 else{return diff;}
             
            }
            
            else if(isLetter1 && !isLetter2){
                return -1;
            }
            else if(!isLetter1 && isLetter2){
               return 1; 
            }
            else{
                return 0;
            }
        });
        return logs;
    }
}