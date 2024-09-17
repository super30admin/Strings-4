//Time Complexity-O(n*mlogn)// where is n is size of logs and m is number of comparison we are doing
//Space Complexity-O(1)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a,b)->{
            String[] logsa=a.split(" ",2);
            String[] logsb=b.split(" ",2);
            boolean isDigita=Character.isDigit(logsa[1].charAt(0));
            boolean isDigitb=Character.isDigit(logsb[1].charAt(0));
            if(!isDigita && !isDigitb)
            {
                int comp=logsa[1].compareTo(logsb[1]);
                if(comp==0)
                {
                    return logsa[0].compareTo(logsb[0]);
                }
                return comp;
            }
            else if(!isDigita && isDigitb)
            {
                return -1;
            }
            else if(isDigita && !isDigitb)
            {
                return 1;
            }
            else {
                return 0;
            }
        });
        return logs;
        
    }
}