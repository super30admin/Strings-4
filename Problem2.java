// 8 String to Integer Atoi
// Time O(n)
// Space O(1)   
class Solution {
    public int myAtoi(String s) {
        
        
        int i = 0;
        
        while(i < s.length() && s.charAt(i) == 32){
            
            i++;
        }
        
        if(i == s.length()){
            
            return 0;
        }
        
        char sign = '+';
        
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            
            sign = s.charAt(i);
            i++;
        }else if(s.charAt(i) < 48 || s.charAt(i) > 57){
            
            return 0;
        }
        
        int num = 0;
        int limit = Integer.MAX_VALUE / 10;
        
        while(i < s.length()){
            
            if(s.charAt(i) < 48 || s.charAt(i) > 57){
                break;
            }else{
                 System.out.println(num + "->" + limit);
                if(sign == '+'){
                    System.out.println(sign);
                    if(num > limit || (num == limit && (s.charAt(i) - 48) >= 7)){
                        
                        System.out.println("Enter..");
                        return Integer.MAX_VALUE;
                    }
                }else{
                    if(num > limit || (num == limit && s.charAt(i) - 48 >= 8)){
                        
                        return Integer.MIN_VALUE;
                    }
                }
                
                num = num * 10 + (s.charAt(i) -48);
            }
            
            i++;
        }
        
        if(sign == '-'){
            return num * -1;
        }
        
        return num;
    }
}