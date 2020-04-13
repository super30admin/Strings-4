
import java.util.Arrays;

public class ReorderLogs {
    public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (log1, log2) -> {
			String part1[] = log1.split("\\s", 2);
			String part2[] = log2.split("\\s", 2);
			boolean isDigit1 = Character.isDigit(part1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(part2[1].charAt(0));

			if (!isDigit1 && !isDigit2) {
				int compare = part1[1].compareTo(part2[1]);
				if (compare != 0) {
					return compare;
				} else {
					return part1[0].compareTo(part2[0]);
				}
			} else if (!isDigit1 && isDigit2) {
				return -1;
			} else if (isDigit1 && !isDigit2) {
				return 1;
			}
			else {
				return 0;
			}
		});
		return logs;
	}

	public static void main(String args[]) {
		String logs[] = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		ReorderLogs reorderLogs = new ReorderLogs();

		System.out.print(Arrays.toString(reorderLogs.reorderLogFiles(logs)));
	}
}