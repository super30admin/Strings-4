package s30.strings.s4;



//algo:-> List down all the conditions and code

//TC: O(n)
//SC: O(1)
public class Atoi {


    public int myAtoi(String s) {

        boolean isPositive = true;

        int n = s.length();

        int i=0;

        while(i < n && s.charAt(i) == ' '){
            ++i;
        }

        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')  ){
            if(s.charAt(i) == '-' )
                isPositive = false;
            ++i;
        }



        long res= 0;

        while(i < n && Character.isDigit(s.charAt(i))){

            res = res * 10 + s.charAt(i) - '0';

            if(isPositive){

                if(res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;

            }else{
                if(res > Integer.MAX_VALUE + 1l)
                    return Integer.MIN_VALUE;
            }

            i++;
        }



        if(!isPositive) res = -res;

        return (int)res;


    }
    public static void main(String[] args) {




    }
}
