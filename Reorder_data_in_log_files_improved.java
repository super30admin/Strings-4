

class Solution {
    
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            
            boolean isDigitS1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigitS2 = Character.isDigit(split2[1].charAt(0));
            
            //case1           
            if(!isDigitS1 && !isDigitS2){
                int check = split1[1].compareTo(split2[1]);
                if(check ==0 ) return split1[0].compareTo(split2[0]);
            return check;
            }
            //case2
            else if(isDigitS1 && isDigitS2) return 0;
            
            // case3
            else if(!isDigitS1 && isDigitS2) return -1;
            
            //case4
            else return 1;
        });
        return logs;
    }
}
