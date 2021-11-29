class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (str1, str2) ->{
            String[] strArr1 = str1.split(" ", 2);
            String[] strArr2 = str2.split(" ", 2);
            
            // second part is digit or letter
            boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));
            
            if(!isDigit1 && !isDigit2){
                // both are letters
                int compare = strArr1[1].compareTo(strArr2[1]);
                if(compare == 0){
                    // compare identifiers
                    return strArr1[0].compareTo(strArr2[0]);
                } 
                return compare;
            } else if(!isDigit1 && isDigit2){
                return -1;
            } else if(isDigit1 && !isDigit2){
                return 1;
            } else{
                return 0;
            }
        });
        return logs;
    }
}
