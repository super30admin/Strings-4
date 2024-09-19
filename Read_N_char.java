// Time Complexity : O(n) 
// Space Complexity : O(n)   
// Did this code successfully run on Leetcode : NO //premium question
// Any problem you faced while coding this : No


char myBuffer[] = new char[4];
int bufferSize, index;

public int read(char[] buf, int n){
    if(bufferSize == 0){
        bufferSize = read4(myBuffer)
    }
    int i =0;
    while(i < n && bufferSize > 0){
        buf[i++] = myBuffer[index++];
        
        if(index == bufferSize){
            bufferSize = read4(myBuffer);
            index = 0;
        }
    }
    return buff;
}