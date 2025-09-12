//time complexity- O(nk log(n) where k is the max size of a log,
// and n is the number of log files
//space complexity- O(1)
import java.util.*;
public class ReorderDataInLogFiles {
    static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b)->{
            String[] s1 = a.split(" ", 2);
            String[] s2 = b.split(" ", 2);

            boolean d1 = Character.isDigit(s1[1].charAt(0));
            boolean d2 = Character.isDigit(s2[1].charAt(0));

            if(d1 && d2) {
                return 0;
            } else if(!d1 && d2) {
                return -1;
            } else if(d1 && !d2) {
                return 1;
            } else {
                int temp = s1[1].compareTo(s2[1]);
                if(temp == 0) {
                    return s1[0].compareTo(s2[0]);
                }
                return temp;
            }

        });
        return logs;
    }
    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println("Logs: "+ Arrays.toString(logs));
        System.out.println("Reader Log Files: "+ Arrays.toString(reorderLogFiles(logs)));
    }
}
