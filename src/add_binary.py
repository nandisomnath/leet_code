"""
67. 
Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
"""

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        i = len(a)-1
        j = len(b)-1

        result = ''
        carry = '0'


        while i >= 0 or j >= 0:
            ax = a[i] if i >= 0 else '0'
            bx = b[j] if j >= 0 else '0'

            if ax == '0' and bx == '0':
                out = '1' if carry == '1' else '0'
                carry = '0' if carry == '1' else '0'
            elif (ax == '0' and bx == '1') or (bx == '0' and ax == '1'):
                out = '0' if carry == '1' else '1'
                carry = '1' if carry == '1' else '0'
            elif ax == '1' and bx == '1':
                out = '1' if carry == '1' else '0'
                carry = '1'

            result =  out + result
            i = i-1
            j = j-1

        if carry == '1':
            result = '1' + result
        
        return result
    

if __name__ == '__main__':
    sol = Solution()
    c = sol.addBinary('11', '1')
    print(c)
        