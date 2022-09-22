class Solution {
    public int myAtoi(String s) {
        int flag=1;
        
        int p=0;
       
        while(p<s.length() && s.charAt(p)==' '){
            p++;
            
        }
        if(p<s.length()&&s.charAt(p)=='-'){
            flag=-1;
            p++;
        }
        else if(p<s.length()&&s.charAt(p)=='+'){
            flag=1;
            p++;
        }
        
         
        if(p<s.length() &&!Character.isDigit(s.charAt(p))){return 0;}
       
        int ans=0;
        
        while(p<s.length() &&Character.isDigit(s.charAt(p))){
            if( flag ==1 && (ans > Integer.MAX_VALUE/10 ||ans== Integer.MAX_VALUE/10 && (s.charAt(p))-48 >7)){return Integer.MAX_VALUE;}
            
            if( flag==-1 && (ans > (Integer.MAX_VALUE/10) || ans== (Integer.MAX_VALUE/10)&& (s.charAt(p))-48 > 8)){ return Integer.MIN_VALUE;}
            //System.out.println(s.charAt(p)-48 +" "+ans );
           ans= ans*10+(int)(s.charAt(p))-48; 
            
            
            p++;
        }
        
        ans= ans*flag;
        return ans;
    }
}
