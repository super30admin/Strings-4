#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 14 16:02:34 2019

@author: tanvirkaur
"""
#Leetcode accceptance = yes
# Time complexity = O(n) where n is the total length of the logs

class Solution(object):
    def reorderLogFiles(self, logs):
        """
        :type logs: List[str]
        :rtype: List[str]
        """
        result = []
        digit1 = []
        letter = []
        for log in logs:
            word = log.split()
            if word[1].isdigit():
                digit1.append(word)
            else:
                letter.append(word)
        #letter.sort(cmp = lambda x,y: x[1]-y[1] if x[1]!= y[1]! else x[0]-y[0])
        #return " ".join(letter) + digit
        return [" ".join(i) for i in sorted(letter, key = lambda x: x[1:]+[x[0]]) + digit1]