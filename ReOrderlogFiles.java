//Time -O(n)
//Space -O(1)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs , (a,b) ->{
            String[] a1 = a.split(" ",2);
            String[] a2 = b.split(" ",2);
            boolean integer1 = Character.isDigit(a1[1].charAt(0));
            boolean integer2 = Character.isDigit(a2[1].charAt(0));
            if(!integer1 && !integer2){
                int comp = a1[1].compareTo(a2[1]);
                if(comp ==0){
                    return a1[0].compareTo(a2[0]);
                }
                return a1[1].compareTo(a2[1]);
            }else if(!integer1 && integer2){
                return -1;
            }else if(integer1 && !integer2){
                return 1;
            }else{
                return 0;
            }
        });

        return logs;
        
    }
}