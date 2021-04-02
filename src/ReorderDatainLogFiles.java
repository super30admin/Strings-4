import java.util.Arrays;

/*
 * Time Complexity of the algorithm is O(n Log n) where n is length of the string.
 * Space Complexity is O(1)  
 */

public class ReorderDatainLogFiles {

	public String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, (s1, s2) -> {

			String[] splitArray1 = s1.split(" ", 2);
			String[] splitArray2 = s2.split(" ", 2);

			boolean isDigit1 = Character.isDigit(splitArray1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(splitArray2[1].charAt(0));

			if (!isDigit1 && !isDigit2) {

				int cmp = splitArray1[1].compareTo(splitArray2[1]);
				if (cmp == 0)
					return splitArray1[0].compareTo(splitArray2[0]);
				;
				return cmp;

			} else if (!isDigit1 && isDigit2) {
				return -1;
			} else if (isDigit1 && !isDigit2) {
				return 1;
			} else {
				return 0;
			}

		});

		return logs;
	}

}
