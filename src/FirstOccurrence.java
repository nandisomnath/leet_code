/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */

public class FirstOccurrence {
    public int strStr(String haystack, String needle) {
        int index;

        boolean isSame = true;

        for (int i = 0; i < haystack.length(); i++) {
            index = i;
            for (int j = 0; j < needle.length(); j++) {
                if (index >= haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) == haystack.charAt(index)) {
                    index++;
                } else {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                return i;
            } else {
                isSame = true;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        FirstOccurrence obj = new FirstOccurrence();
        int index = obj.strStr(haystack, needle);
        System.out.println(index);
    }

}
