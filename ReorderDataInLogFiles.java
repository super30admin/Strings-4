// Time Complexity : O(nk*logk) where n = length of logs array, k = average length of each string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//937. Reorder Data in Log Files (Medium) - https://leetcode.com/problems/reorder-data-in-log-files/
// Time Complexity : O(nk*logk) where n = length of logs array, k = average length of each string
// Space Complexity : O(1)
class Solution {
	public String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, (a, b) -> {
			String[] aArr = a.split(" ", 2);
			String[] bArr = b.split(" ", 2);
			boolean isDigit1 = Character.isDigit(aArr[1].charAt(0));
			boolean isDigit2 = Character.isDigit(bArr[1].charAt(0));

			if (!isDigit1 && !isDigit2) {
				int comp = aArr[1].compareTo(bArr[1]);

				if (comp == 0) {
					return aArr[0].compareTo(bArr[0]);
				}

				return comp;
			} else if (isDigit1 && !isDigit2) {
				return 1;
			} else if (!isDigit1 && isDigit2) {
				return -1;
			} else {
				return 0;
			}
		});

		return logs;
	}
}