// Time Complexity : O(NlogN * word length of comparsion) N logs count
// Space Complexity : O(1)

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] token1=s1.split(" ",2);
            String[] token2=s2.split(" ",2);
            
            boolean letter1= Character.isAlphabetic(token1[1].charAt(0));
            boolean letter2= Character.isAlphabetic(token2[1].charAt(0));
            
            if(letter1 && letter2) {
                int diff=token1[1].compareTo(token2[1]);
                if(diff != 0) return diff;
                return token1[0].compareTo(token2[0]);
            } else if(letter1 && !letter2) {
                return -1;
            } else if(!letter1 && letter2) {
                return 1;
            }
            return 0;
        });
        return logs;
    }
}
