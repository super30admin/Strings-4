class ReorderLogFile {
  /**
   * Time Complexity: O(n m logn )
   * 
   * Space Complexity: O(mlogn)
   *   m -> average word length in the strings
   * 
   * Were you able to solve this on leetcode? Yes.
   */
  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (str1, str2) -> {
        
        String[] strArr1 = str1.split(" ", 2);
        String[] strArr2 = str2.split(" ", 2);
        
        boolean str1IsDigit = Character.isDigit(strArr1[1].charAt(0));
        boolean str2IsDigit = Character.isDigit(strArr2[1].charAt(0));
        
        if(!str1IsDigit && !str2IsDigit) {
            // both are Strings
            
            if(strArr1[1].equals(strArr2[1])) {
                return strArr1[0].compareTo(strArr2[0]);
            }
            
            return strArr1[1].compareTo(strArr2[1]);
            
        } else if(!str1IsDigit && str2IsDigit) {
            return -1;
        } else if(str1IsDigit && !str2IsDigit) {
            return 1;
        } else {
            return 0;
        }

    });
    
    return logs;
}
}