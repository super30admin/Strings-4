# // Time Complexity :O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def myAtoi(self, s: str) -> int:
       
        s=s.strip()
        if s=="":
            return 0
        num=0
        
        sign='+'
        if s[0]=='-':
            sign='-'
        if s[0]!='+' and s[0]!='-' and not s[0].isdigit():
            return 0
        temp=214748364
        print(sign)
        for i in range(len(s)):
            print(i)
            if s[i].isdigit():
                if sign=='+':
                    print(num)
                    if num==temp:
                        print(num)
                        if int(s[i])>7:
                            print("x")
                            return 2147483647
                    elif num>temp:
                        print(num)
                        return 2147483647
                    
                    num=num*10+int(s[i])
                else:
            
                    print(s[i])
                    if num==temp:
                        print(int())
                        
                        if int(s[i])>8:
                            print("x")
                            return -2147483648
                    elif num>temp:
                        print("b")
                        return -2147483648
                    
                    num=num*10+int(s[i])
                    print(num)
            else:
                if(i!=0):
                    break
        if sign=='+':
            return num
        elif sign=='-':
            return -num

                