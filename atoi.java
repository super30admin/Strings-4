//time complexity O(n)
//space complexity O(1)

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        //because this way we only need to compare the 9 digits from Integer.MAX_VALUE
        //the last digit we can handle as follows
        int maxLimit = Integer.MAX_VALUE/10;
        char first = str.charAt(0);
        char sign = first == '-' ? '-' : '+';
        if(!Character.isDigit(first) && first != '-' && first != '+') return 0;
        int result = 0;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                int lastDig = str.charAt(i) - '0';
                if(sign == '+'){
                    if(result > maxLimit){
                        return Integer.MAX_VALUE;
                    } else if(result == maxLimit){
                        // > 2147483647
                        if(lastDig > 7){
                            return Integer.MAX_VALUE;
                        }
                    }
                } else {
                    if(result > maxLimit){
                        return Integer.MIN_VALUE;
                    } else if(result == maxLimit){
                        // > -2147483648
                        if(lastDig > 8){
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = result * 10 + lastDig;
                //if we encounter any non digit we break and return 0
                //0th index is handled at top
            } else if( i != 0){
                break;
            }
        }
        if(sign == '-') return -result;
        return result;
    }
}
