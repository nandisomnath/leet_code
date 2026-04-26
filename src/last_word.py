"""
58. Length of Last Word

Given a string s consisting of words and spaces,
return the length of the last word in the string.

A word is a maximal

consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

Constraints:

    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.

"""


class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        wordLength = 0
        word = ''

        for i in range(len(s)-1, -1, -1):
            x = s[i]
            if x != ' ':
                word = x + word
                wordLength += 1
            
            if len(word) != 0 and  x == ' ':
                break

        return wordLength
    

if __name__ == "__main__":
    sol = Solution()
    res = sol.lengthOfLastWord("   fly me   to   the moon  ")
    print(res)