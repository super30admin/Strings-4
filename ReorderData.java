class Solution {
    //tc-o(nlogn) ,  sc-o(1)
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a,b)->{
            String[] strArr1 = a.split(" ",2);// dig1, 8 1 5 1// split into 2 parts
            String[] strArr2 = b.split(" ",2);
            boolean isDigit1 = Character.isDigit(strArr1[1].charAt(0));// 8
            boolean isDigit2 = Character.isDigit(strArr2[1].charAt(0));
            if(!isDigit1 && !isDigit2)//lexographical sort
            {
                int comp = strArr1[1].compareTo(strArr2[1]);//0 , 1 0r -1;
                if(comp!=0)
                {
                return comp;
                }
                else{
                    return strArr1[0].compareTo(strArr2[0]);//comapre identifier
                }

            }
            else if(!isDigit1 && isDigit2)//string and digit so no need to swap
            {
                return -1;
            }
            else if(isDigit1 && !isDigit2)//digit and string need to swap
            {
                return 1;//return  any +ve
            }
            else{//both are digit
            return 0; //no change in position
            }


        });
        return logs;
    }
}