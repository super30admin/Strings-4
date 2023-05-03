import java.util.Arrays;
//Time Complexity : O(NMlogM)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Use comparator to sort the logs as per requirements.
 *
 */
class Solution {
	public String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, (a, b) -> {
			int identA = a.indexOf(" ") + 1;
			int identB = b.indexOf(" ") + 1;

			boolean isLetterA = Character.isLetter(a.charAt(identA));
			boolean isLetterB = Character.isLetter(b.charAt(identB));
			if (isLetterA && isLetterB) {
				int cmp = a.substring(identA).compareTo(b.substring(identB));
				if (cmp != 0)
					return cmp;

				return a.compareTo(b);
			} else if (isLetterA && !isLetterB) {
				return -1;
			} else if (!isLetterA && isLetterB) {
				return 1;
			} else
				return 0;

		});

		return logs;
	}
}