class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Queue<String> q= new LinkedList<>();
        List<String>l= new ArrayList<>();
        
        for(String s:logs){
            int p=0;
            while(s.charAt(p)!=' '){
                p++;
            }
            if( Character.isDigit(s.charAt(p+1))){
                q.add(s);
            }else{
                l.add(s);
            }
        }
        
        l.sort((a,b)->{
            
            String []s1=a.split("\\s",2);
            String []s2=b.split("\\s",2);
            
            if(s1[1].compareTo(s2[1])==0){
                return s1[0].compareTo(s2[0]);
            }else{
                return s1[1].compareTo(s2[1]);
            }
        });
        
        while(!q.isEmpty()){
            l.add(q.poll());
        }
        String []ans= new String[l.size()];
        for( int i=0;i<ans.length;i++){
            ans[i]= l.get(i);
        }
     //   System.out.println(l);
        return ans;
        
    }
}
