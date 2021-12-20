"""
https://leetcode.com/problems/reorder-data-in-log-files/
"""


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        """
        To ensure the above order, we could define a tuple of 3 keys, (key_1, key_2, key_3), as follows:

key_1: this key serves as a indicator for the type of logs. For the letter-logs, we could assign its key_1 with 0, and for the digit-logs, we assign its key_1 with 1. As we can see, thanks to the assigned values, the letter-logs would take the priority above the digit-logs.

key_2: for this key, we use the content of the letter-logs as its value, so that among the letter-logs, they would be further ordered based on their content, as required in the Rule (2).

key_3: similarly with the key_2, this key serves to further order the letter-logs. We will use the identifier of the letter-logs as its value, so that for the letter-logs with the same content, we could further sort the logs based on its identifier, as required in the Rule (2).

Note: for the digit-logs, we don't need the key_2 and key_3. We can simply assign the None value to these two keys. As a result, the key value for all the digit-logs would be (1, None, None).
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]

Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]

Time Complexity: O(M⋅N⋅logN) The sorted() in Python is implemented with the Timsort algorithm whose time complexity is O(N⋅logN).Since the keys of the elements are basically the logs itself, the comparison between two keys can take up to(M) time.Therefore, the overall time complexity of the algorithm is O(M⋅N⋅logN).


        """

        def getkeys(log):
            _id, rest = log.split(" ", maxsplit=1)
            ##if the log is numbers
            if rest[0].isalpha():
                return (0, rest, _id)
            else:  ###digit has priority 1 rest keys None
                return (1, None, None)
            ###if the log is of alphabets

        return sorted(logs, key=getkeys)



