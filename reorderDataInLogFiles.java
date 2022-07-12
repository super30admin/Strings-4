/*
Problem: https://leetcode.com/problems/reorder-data-in-log-files/
*/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        
        for (String log : logs) {
            if (isDigitLog(log)) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        
        Collections.sort(letterLogs, (s1, s2) -> {
           int index1 = s1.indexOf(" ");
            int index2 = s2.indexOf(" ");
            String substr1 = s1.substring(index1 + 1);
            String substr2 = s2.substring(index2 + 1);
            
            if (substr1.equals(substr2)) {
                return s1.substring(0, index1).compareTo(s2.substring(0, index2));
            } else {
                return substr1.compareTo(substr2);
            }
        });
        
        letterLogs.addAll(digitLogs);
        
        String result[] = new String[letterLogs.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = letterLogs.get(i);
        }
        return result;
    }
    
    private boolean isDigitLog(String log) {
        int index = log.indexOf(" ");
        if (Character.isDigit(log.charAt(index + 1))) {
            return true;
        }
        return false;
    }
}