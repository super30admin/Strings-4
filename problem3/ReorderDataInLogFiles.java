// Time Complexity : O(knlog n), n -> Number of logs, k -> Average length of each log
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.Arrays;

public class ReorderDataInLogFiles {
	public String[] reorderLogFiles(String[] logs) {
		if (logs == null || logs.length < 2) {
			return logs;
		}

		Arrays.sort(logs, (l1, l2) -> {
			String[] strArr1 = l1.split(" ", 2);
			String[] strArr2 = l2.split(" ", 2);

			boolean isDigitLog1 = Character.isDigit(strArr1[1].charAt(0));
			boolean isDigitLog2 = Character.isDigit(strArr2[1].charAt(0));

			if (!isDigitLog1 && !isDigitLog2) {
				int comp = strArr1[1].compareTo(strArr2[1]);
				if (comp == 0) {
					return strArr1[0].compareTo(strArr2[0]);
				}
				return comp;
			} else if (isDigitLog1 && !isDigitLog2) {
				return 1;
			} else if (!isDigitLog1 && isDigitLog2) {
				return -1;
			} else {
				return 0;
			}
		});

		return logs;
	}

	private void print(String[] logs) {
		StringBuilder sb = new StringBuilder();
		for (String log : logs) {
			if (sb.length() != 0) {
				sb.append(", ");
			}
			sb.append(log);
		}

		System.out.print(sb);
	}

	public static void main(String[] args) {
		ReorderDataInLogFiles obj = new ReorderDataInLogFiles();
		String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		System.out.print("Logs: ");
		obj.print(logs);
		System.out.println();

		String[] reorderedLogs = obj.reorderLogFiles(logs);
		System.out.print("Reordered Logs: ");
		obj.print(reorderedLogs);
	}

}
