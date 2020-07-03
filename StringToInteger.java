// 8.
// time - O(n)
// space - constant
class Solution {
    public int myAtoi(String str) {
        str = str.trim(); //clears front and end whitespaces
        //edge
        if(str.length() == 0)
        {
            return 0;
        }
        //edge
        //return 0 if the 1st character is not a +, - or a digit
        if(str.charAt(0) != '+' && str.charAt(0) != '-' && !Character.isDigit(str.charAt(0)))
        {
            return 0;
        }
        char sign = '+'; //capture the sign
        sign = (str.charAt(0) == '-') ? '-' : '+';
        //keeping infinity as max value / 10 to ensure that max range is not overshooted at any point
        int infinity = Integer.MAX_VALUE / 10; 
        int result = 0; //return value
        for(int i = 0; i < str.length(); i++)
        {
            char current = str.charAt(i);
            if(Character.isDigit(current))
            {
                if(sign == '+')
                {
                    //irrespective of value of current, result overshoots max value, so return integer max value
                    if(result > infinity)
                    {
                        return Integer.MAX_VALUE;
                    }
                    //return integer max value if current >= 7
                    else if(result == infinity)
                    {
                        if(current - '0' >= 7)
                        {
                            return Integer.MAX_VALUE;
                        }
                    }
                }
                else
                {
                    //irrespective of value of current, result overshoots min value, so return integer min value
                    if(result > infinity)
                    {
                        return Integer.MIN_VALUE;
                    }
                    //return integer max value if current >= 8
                    else if(result == infinity)
                    {
                        if(current - '0' >= 8)
                        {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = result * 10 + (current - '0'); //update result
            }
            //the first char can have '-' so if a char is found at any other index break
            else if(i != 0)
            {
                break;
            }
        }
        
        return (sign == '+') ? result : -result;
    }
}
