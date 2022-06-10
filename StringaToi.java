public class StringaToi {
  /**
   * 
   * Time Complexity: O(n)
   * 
   * Space Complexity: O(1)
   * 
   * Were you able to solve this on leetcode? Yes
   */
  public int myAtoi(String s) {
    s.trim();
    if(s.equals("") || s== null) { return 0; }
    
    int sign = 1;
    int result = 0;
    
    int i = 0;
    while(i < s.length()){
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
            break;
        } else if(s.charAt(i) != ' ') break;
        
        i++;
    }
    
    
    int idx = i;
    int limit = Integer.MAX_VALUE / 10;

    while(idx < s.length()){
        char curr = s.charAt(idx);
        
        if(Character.isDigit(curr)){
            if(sign == 1){
                if(result == limit){
                    if(curr - '0' >= 7) { return Integer.MAX_VALUE; }
                } else if(result > limit){
                    return Integer.MAX_VALUE;
                }
            } else { // negative number

                if(result == limit){
                    if(curr - '0' >= 8) { return Integer.MIN_VALUE; }
                } else if(result > limit){
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + (curr - '0');
        } else {
            break;
        }
        idx++;
    }
    
    result *= sign;
    return result;
}
}
