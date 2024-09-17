//Time Complexity-O(n)
//Space Complexity-O(1)
class Solution {
    public int myAtoi(String s) {
        int result=0;
        s=s.trim();
        if(s.length()==0)
        {
            return 0;
        }
        if(!Character.isDigit(s.charAt(0))&&(s.charAt(0)!='-'&&s.charAt(0)!='+'))
        {
            return 0;
        }
        char sign='+';
        if(s.charAt(0)=='-')
        {
            sign='-';
        } 
        int limit=Integer.MAX_VALUE/10;
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                if(result>=limit)
                {
                    if(sign=='+')
                    {
                        if(result>limit)
                        {
                            return Integer.MAX_VALUE;
                        }
                        else if(result==limit && (s.charAt(i)-'0'>6))
                        {
                            return Integer.MAX_VALUE;
                        }
                    }
                    else{
                        if(result>limit)
                        {
                            return Integer.MIN_VALUE;
                        }
                        else if(result==limit && (s.charAt(i)-'0'>7))
                        {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result=result*10+(s.charAt(i)-'0');
            }
            else if(i>0)
            {
                break;
            }
        }
        if(sign=='+')
        {
            return result;
        }
        return result*-1;
    }
}