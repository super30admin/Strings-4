class Problem2 {
    //TC:O(N)
    //SC:O(1)
    public int myAtoi(String s) {
        //if the string is negetve or positive
        String trimmedStr = s.trim();
        boolean negetive = false;
        int result = 0;
        int maxInteger = Integer.MAX_VALUE/10;
        for(int i=0;i<trimmedStr.length();i++){
            char c =   trimmedStr.charAt(i);
            if(i==0 && (c =='+' || c=='-')){
                if(c == '-'){
                    negetive = true;
                }else{
                    negetive = false;
                }
                continue;
            }

            //
            if(!Character.isDigit(c)) break;

            if(result > maxInteger){
                if(negetive) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;

            }else if(result == maxInteger){
                //there can be two cases for -2147483648 to 2147483647
                if(!negetive && ((c-'0') >= 7)) return Integer.MAX_VALUE;
                if( negetive && ((c-'0') >= 8)) return Integer.MIN_VALUE;
            }

            result = result * 10 + (c-'0');
        }


        //
        if(negetive) return -1*result;
        return result;
    }
}