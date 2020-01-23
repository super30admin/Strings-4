class Solution:
    '''
    Accepted on leetcode(937)
    time - O(NlogN)
    space - O(N)
    '''

    # Reference - https://stackoverflow.com/questions/20459982/how-to-sort-a-list-alphabetically-by-the-second-word-in-a-string
    def reorderLogFiles(self, logs):
        # take 2 arrays for digits and letters
        nums = []
        alpha = []
        for i in range(len(logs)):
            # if secong element is digit add to nums array else add to alpha array.
            if logs[i].split(' ')[1].isnumeric():
                nums.append(logs[i])
            else:
                alpha.append(logs[i])

        # custom sort for alpha array first based on first element and then based on rest of array.
        alpha.sort(key=lambda x: x.split()[0])
        alpha.sort(key=lambda x: x.split()[1:])

        # join both arrays and return
        result = alpha + nums

        return result