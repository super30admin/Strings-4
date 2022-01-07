class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (l1, l2) -> {
            String [] splitArray1 = l1.split(" ", 2);
            String [] splitArray2 = l2.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(splitArray1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitArray2[1].charAt(0));
            
            if(!isDigit1 && !isDigit2){
                String str1 = splitArray1[1];
                String str2 = splitArray2[1];
                
                int comp = str1.compareTo(str2);
                
                if(comp == 0){
                    return splitArray1[0].compareTo(splitArray2[0]);
                }
                
                return comp;
                
            }else if(!isDigit1 && isDigit2){
                return -1;
            }else if(isDigit1 && !isDigit2){
                return 1;
            }else return 0;
        });
        
        return logs;
    }
}
//TC: O(n)
//SC: O(1)
