// Time: O(nklogk)
// Space: O(1)

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b)->{
            String [] s1 = a.split(" ",2);
            String [] s2 = b.split(" ",2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if (!isDigit1 && !isDigit2){
                int comp = s1[1].compareTo(s2[1]);
                if (comp == 0){
                    return s1[0].compareTo(s2[0]);
                }
                return comp;
            }else if(!isDigit1 && isDigit2){
                return -1;
            }else if(isDigit1 && !isDigit2){
                return 1;
            }else{
                return 0;
            }
        });
        return logs;
    }
}
