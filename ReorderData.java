/*
write a new  custom comparator function to sort the logs.
for 2 logs:
split them at space into 2 splits.
Check if they are digit or letter logs by checking the value at second split of each log 
and set the letter log or digit log flag accordingly.
if both are digit logs, then maintain order
if one is digit and one is letter return letter
if both are letter, sort them accoring to the char at split 1

time complexity: O(NlogN)
space complexity : O(NlogN)

*/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0)return new String[0];
        
        Comparator<String> myComp = new Comparator<String>(){
            public int compare(String s1, String s2){
                
                String[]split1 = s1.split(" ",2);
                String[]split2 = s2.split(" ",2);
                
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                if(!isDigit1 && !isDigit2){ //both are letter logs
                    int cmp = split1[1].compareTo(split2[1]);
                    if(cmp != 0)return cmp;
                    return split1[0].compareTo(split2[0]);
                }
                
                else if(!isDigit1 && isDigit2){
                    //s1 is letter log
                    return -1;
                }
                else if(isDigit1 && !isDigit2){//s2 is letter log
                    return 1;
                }else{
                    return 0;//both are equal
                }
                
            }
        };
        Arrays.sort(logs,myComp);
        return logs;
    }
}