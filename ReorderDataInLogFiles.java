// Time Complexity: O(n)
// Space Complexity: O(n), to account for the result space
class So
lution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
        	String[] token1 = s1.split(" ", 2);
        	String[] token2 = s2.split(" ", 2);

        	boolean isLetter1 = Character.isAlphabetic(token1[1].charAt(0));
        	boolean isLetter2 = Character.isAlphabetic(token2[1].charAt(0));

        	if(isLetter1 && isLetter2) { // both letter logs
        		int diff = token1[1].compareTo(token2[1]);
        		if(diff == 0) {
        			return token1[0].compareTo(token2[0]);
        		}
        		return diff;
        	} else if(isLetter1 && !isLetter2) {
        		return -1;
        	} else if(!isLetter1 && isLetter2) {
        		return 1;
        	}
        	return 0;
        });

        return logs;
    }
}