//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    public int myAtoi(String s) {
       if(s.length()==0)
           return 0;
       s= s.trim();
       if(s.length()==0)
           return 0;
       int res=0;
       boolean flag=true;
        int hlimit= Integer.MAX_VALUE/10;
       if( (s.charAt(0)!='+' && s.charAt(0)!='-') && !Character.isDigit(s.charAt(0)) )
            return 0;
       if(s.charAt(0)=='-')
            flag=false;
       for(int i=0;i<s.length();i++)
       {
           Character c=s.charAt(i);
           if(Character.isDigit(c))
           {
               if(res>hlimit){
                   if(flag)
                    return Integer.MAX_VALUE;
                   return Integer.MIN_VALUE; 
               }
               else if(res==hlimit){
                   if(flag){
                       if((c-'0')>=7)
                           return Integer.MAX_VALUE;
                   }
                   else{
                       if((c-'0')>=8)
                           return Integer.MIN_VALUE;
                   }
                   
               }
               res=res*10 + (c-'0');
           }
           else if(i!=0){
               break;
           }
       }
        if(flag)
            return res;
        else
            return -res;
        
        
    }
}