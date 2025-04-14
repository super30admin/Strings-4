// TC: O(n log n)
// SC: O(1)

import java.util.*;

public class LC937 {
    private boolean isDigitLog(String log){
        int firstSpace = log.indexOf(" ");
        return Character.isDigit(log.charAt(firstSpace+1));
    }
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (l1, l2) -> {
            boolean a = isDigitLog(l1);
            boolean b = isDigitLog(l2);
            if(a && b) return 0;
            if(a && !b) return 1;
            if(!a && b) return -1;
            int fs1 = l1.indexOf(" "), fs2 = l2.indexOf(" ");
            int x = l1.substring(fs1+1).compareTo(l2.substring(fs2+1));
            if(x>0 || x<0) return x;
            return l1.substring(0, fs1).compareTo(l2.substring(0, fs2));
        });
        return logs;
    }
}
