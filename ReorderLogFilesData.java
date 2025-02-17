// Approach: Sort the Arrays with customer comparator and return back the array
// Arrays.sort((a,b)-> a - b = -ve implies already in sorted ascending order
//                           = + ve implies we need to swap a and b
//                           = 0    implies maintain their relative order. don't do anything
// Time : O(nlogn)
// Space :
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b)->{
            // Identifier and Content
            String[] splitArr1 = a.split(" ",2); // split at space into two parts
            String[] splitArr2 = b.split(" ",2); // split at space into two parts
            // check if the first character of the content is digit or character
            boolean isDigit1 = Character.isDigit(splitArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitArr2[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                // both are not digits ==> letter logs
                int comp = splitArr1[1].compareTo(splitArr2[1]);
                if(comp ==0){
                    // now check the identifier
                    return splitArr1[0].compareTo(splitArr2[0]);
                }
                return comp;
            } else if(!isDigit1 && isDigit2){
                 // first one is letter log and second one is digit log;
                 // In terms of Arrays.sort when diff is -ve they are already sorted
                 return -1;

            }else if (isDigit1 && !isDigit2){
                // first one is digit log and second one is letter log
                // From the problem rule - first letter logs come and then digit logs.we need to swap them.
                // In terms of Arrays.sort is when diff is +ve we need to sort.
                return 1;
            }else{
                // case: Both are digit logs
                // for digit logs we dont do anything - just maintain relative order
                // In terms of Arrays.sort when diff is zero we just maintain their relative order
                return 0;

            }
        });

        return logs;
    }

}