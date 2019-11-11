/*Did it run on LeetCode : No
Problems : Facing problem with values exceeding the INT MAX and MIN Value.
Time Complexity : O(N)
Space Complexity : O(1) or O(N)->String builder case
*/


class Solution {
   
    public int myAtoi(String str) {
    Integer result = 0;
        int sign = 1 ;
        int start = 0;
    StringBuilder str11 = new StringBuilder("");
   // int i = 0;
    
        //Iterate until whitespaces are over.
    for(int i = 0 ;i<str.length();i++)
    {
        if(Character.isWhitespace(str.charAt(i)))
        {
            start++;
            continue;
        }
        else
        {
            break;
        }
    }
        
       // Check if first character after whitespace is a + or - sign. 
        
        if(str.charAt(start)=='-'||str.charAt(start)=='+')
        {
            
            if(str.charAt(start)=='-') sign = -1;
            start++;
        }
        
      
        
        //Iterate over the remaining string to find numbers.
        //If digits, append to stringbuilder. Once digits over, break.
        
    int startagain = start;
        if(Character.isLetter(str.charAt(startagain)))
        {
            return 0;
        }
        while(startagain<str.length())
        {
            
            if(Character.isDigit(str.charAt(startagain)))
            {
                str11.append(str.charAt(startagain));
                startagain++;
            }
            else
                break;
        }
        
        System.out.println(str11.toString());
        
        
  
       result = Integer.parseInt(str11.toString());
         if (sign == 1 && result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
        if (sign == -1 && (-1) * result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
        
        return sign*result;
}
}

