import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // Tc: O(NlogN * M) Sc: O(N)
        List<String> digLogs = new ArrayList<>();
        List<String> wordLogs = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ", 2)[1].charAt(0))) {
                digLogs.add(log);
            } else {
                wordLogs.add(log);
            }
        }

        wordLogs.sort(new Comparator<String>() {
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                return split1[0].compareTo(split2[0]);
            }
        });

        String[] result = new String[logs.length];
        int index = 0;
        for (String log : wordLogs) {
            result[index++] = log;
        }
        for (String log : digLogs) {
            result[index++] = log;
        }
        return result;
    }

}