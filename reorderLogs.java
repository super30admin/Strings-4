import java.util.*;

class Main {

    public static String[] reorderLogFiles(String[] logs) {
        // null case
        if (logs == null || logs.length == 0)
            return logs;

        // sort the logs as per given condition
        // using custom comparator
        Arrays.sort(logs, (str1, str2) -> {
            // split the both string
            String[] sArr1 = str1.split(" ", 2);
            String[] sArr2 = str2.split(" ", 2);
            // check first char is digit or not
            boolean f1 = Character.isDigit(sArr1[1].charAt(0));
            boolean f2 = Character.isDigit(sArr2[1].charAt(0));
            // if both is not digit
            if (!f1 && !f2) {
                if (sArr1[1].compareTo(sArr2[1]) == 0) {
                    return sArr1[0].compareTo(sArr2[0]);
                } else {
                    return sArr1[1].compareTo(sArr2[1]);
                }
            } else if (f1 && !f2) {
                // f1 is digit but f2 is not digit
                return 1;
            } else if (!f1 && f2) {
                // f2 is digit but f1 is not digit
                return -1;
            } else {
                // both are digit
                // no change
                return 0;
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
                "let3 art zero" };
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }
}