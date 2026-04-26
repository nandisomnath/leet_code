"""
242.
Given two strings s and t, return true if t is an of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

"""


# we can use hashmap also
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        scharPoint = [c for c in s]
        if len(s) != len(t):
            return False

        for i in range(0, len(s)):
            b = t[i]
            try:
                scharPoint.remove(b)
            except ValueError as e:
                return False

        return True if len(scharPoint) == 0 else False


if __name__ == "__main__":
    sol = Solution()
    o = sol.isAnagram("anagram", "nagaram")
    print(o)