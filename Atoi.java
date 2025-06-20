class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length() == 0) return 0;
        char c = s.charAt(0);
        if(!Character.isDigit(c) && c!='+' && c!='-') return 0;
        boolean flag = true;
        int startindex=0;
        if(c == '+'){
            flag = true;
            startindex =1;
        }else if(c == '-'){
            flag = false;
            startindex=1;
        }

        int result =0;
        int limit = Integer.MAX_VALUE/10;
        for(int i=startindex;i<s.length();i++){
            c =s.charAt(i);
            if(Character.isDigit(c)){
                if(result>limit){
                    if(flag) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }else if(result == limit){
                    if(flag){
                        if(c-'0'>7) return Integer.MAX_VALUE;
                    }else{
                        if(c-'0'>=8) return Integer.MIN_VALUE;
                    }

                }


                result=result*10+c-'0';
            }else{
                break;
            }
        }
        if(flag) return result;
        return -result;
        
    }
}