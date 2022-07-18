//TC : O(N)
//SC : O(1)
class Solution {
    public int myAtoi(String s) {
        boolean positive = true;
        int result=0;
        int limit = Integer.MAX_VALUE/10;
        int rem = Integer.MAX_VALUE%10;
        //Step 1
        s=s.trim();
        if(s==null || s.length()==0) return 0;
        //Step 2
        if(s.charAt(0)=='-'){
            positive=false;
        }
        //Step 3
        //System.out.println(" s: "+s);
        int l = s.length();
        for(int i=0;i<l;i++){
            char c =s.charAt(i);
            //System.out.println(" c: "+c);
            //System.out.println(" postive: "+positive);
            if(i==0 && (c=='-' || c=='+'))
            {
                if(c=='-')
                    positive = false;
                continue;
            }
            if(!Character.isDigit(c))
            {
                if(!positive)
                    return -1*result;
                else
                    return result;
            }

            if(result>limit)
            {
                if(!positive)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }

            if(result == limit && c-'0' > rem){
                if(!positive)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            result = (result*10)+c-'0';
            //System.out.println(" result at i : "+i+" result : "+result);
        }
        if(!positive)
            return -1*result;
        else
            return result;
    }
}