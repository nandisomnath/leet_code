/*
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


*/

class AddBinary {
    public String addBinary(String a, String b) {
        // check which length is better

        int resultLength = a.length() > b.length() ? a.length()+1 : b.length()+1;

        int[] result = new int[resultLength];
        int borrow = 0;
        int index = result.length - 1;

        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0) {

            int f = 0, l = 0;

            if (i >= 0) {
                f = Integer.parseInt(String.valueOf(a.charAt(i)));
            }

            if (j >= 0) {
                l = Integer.parseInt(String.valueOf(b.charAt(j)));
            }

            int r = (f + l + borrow) % 2; // 1 0 1
            borrow = (f + l + borrow) >= 2 ? 1 : 0;
            result[index] = r;

            index--;
            j--;
            i--;
        }

        result[index] = borrow;

        String resultString = "";
        if (result[0] == 1) {
            resultString += String.valueOf(result[0]);
        }
        for (int z = 1; z < result.length; z++) {
            resultString += String.valueOf(result[z]);
        }

        return resultString;
    }

    public static void main(String[] args) {

        var result = new AddBinary().addBinary("1", "111");
        System.out.println(result);
    }
}