class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b)->{
            String[] splitArr1 = a.split(" ",2);
            String[] splitArr2 = b.split(" ",2);
            boolean isDigit1 = Character.isDigit(splitArr1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitArr2[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                int cmp = splitArr1[1].compareTo(splitArr2[1]);
                if(cmp == 0){
                    return splitArr1[0].compareTo(splitArr2[0]);
                }
                return cmp;
            }else if(!isDigit1 && isDigit2){
                return -232;
            }else if(isDigit1 && !isDigit2){
                return 333;
            }else{
                return 0;
            }
        });


        return logs;
    }
}