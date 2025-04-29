class Sample{
    /***************PROBLEM-1*************/
    /***************PROBLEM-2*************/
//TC:0(N)
        //SC:0(1)
    class Solution {
        public int myAtoi(String s) {
            s=s.trim();
            if(s.length()==0 || s==null){
                return 0;
            }

            char sign='+';

            if(s.charAt(0)=='-'){
                sign='-';
            }

            if(s.charAt(0)!='-' && s.charAt(0)!='+' && !Character.isDigit(s.charAt(0))){

                return 0;
            }

            int num=0;
            int limit=Integer.MAX_VALUE/10;

            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(Character.isDigit(c)){
                    if(sign=='+'){
                        if((num> limit) || (num==limit && c>='7')){
                            return Integer.MAX_VALUE;
                        }
                    }else{
                        if((num> limit) || (num==limit && c>='8')){
                            return Integer.MIN_VALUE;
                        }
                    }
                    num=num*10+(c-'0');
                }
                else if(i!=0){
                    break;
                }
            }
            if(sign=='-'){
                return -1*num;
            }else{
                return num;
            }

        }
    }
    /***************PROBLEM-3*************/

    //TC:0(NLogN)
//SC:0(1)
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            if(logs.length==0 || logs==null){
                return new String[]{};
            }
            Arrays.sort(logs,(log1,log2)->{
                String[] array1=log1.split(" ",2);
                String[] array2=log2.split(" ",2);
                boolean digit1=Character.isDigit(array1[1].charAt(0));
                boolean digit2=Character.isDigit(array2[1].charAt(0));
                if(!digit1 && !digit2){
                    int cmp=array1[1].compareTo(array2[1]);
                    if(cmp==0){
                        return array1[0].compareTo(array2[0]);
                    }
                    return cmp;
                }else if(!digit1 && digit2){
                    return -1;
                }else if(digit1 && !digit2){
                    return 1;
                }else{
                    return 0;
                }
            });
            return logs;
        }
    }
}