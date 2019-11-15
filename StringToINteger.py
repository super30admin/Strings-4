#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 11 09:25:53 2019

@author: tanvirkaur
"""

# Time limit exceeded for the example2: "    -42" and example4 : "-91283472332"
class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        # s = str.lstrip(' ')
        s = str.replace(" ","")
        result = 0
        i = 0
        MAX_INT = 2**31-1
        MIN_INT = -(2**31)
        max_limit = MAX_INT/10
        sign = -1 if s[0] == "-" else 1
        while (i<len(s) and self.isValid(s,i)):
            char = s[i]
            if i == 0 and char =='-' or char == '+':
                continue
            if result > max_limit:
                if sign == -1:
                    return MIN_INT
                return MAX_INT
            if result == max_limit:
                if sign == -1:
                    if char >= '8':
                        return MIN_INT
                    else:
                        if char >= '7':
                            return MAX_INT
            result = result*10 + int(char)
            i += 1
        if sign == -1:
            return -result
        else:
            return result
    def isValid(self,s,i):
        char = s[i]
        if (char >= '0' and char<= '9') or (i == 0 and(char =='-' or char =='+')):
            return True
        return False