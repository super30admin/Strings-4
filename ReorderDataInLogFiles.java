// Time Complexity : O(k*n*logn) where n is the length of array, k is the max length of string in array
// Space Complexity : O(k*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Separate the letters and digits strings and store in lists
// Sort the letters list using comparator
// Merge them and return by converting it to string array
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();
        for(String x: logs){
            int i = 0;
            while(x.charAt(i) != ' '){
                i++;
            }
            if(!Character.isDigit(x.charAt(i+1))){
                letter.add(x);
            }
            else{
                digit.add(x);
            }
        }
        Collections.sort(letter, new Comparator<String>(){
            public int compare(String a, String b){
                int i = 0, j = 0;
                while(a.charAt(i) != ' ')
                    i++;
                while(b.charAt(j) != ' ')
                    j++;
                String a1 = a.substring(i+1);
                String b1 = b.substring(j+1);
                if(a1.compareTo(b1) == 0){
                    String a2 = a.substring(0,i+1);
                    String b2 = b.substring(0,j+1);
                    return a2.compareTo(b2);
                }
                return a1.compareTo(b1);
            }
        });
        for(String x: digit){
            letter.add(x);
        }
        return letter.toArray(new String[0]);
    }
}