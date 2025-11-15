/*

190. Reverse Bits


Reverse bits of a given 32 bits signed integer.

 

Example 1:

Input: n = 43261596

Output: 964176192

Explanation:
Integer	Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000

Example 2:

Input: n = 2147483644

Output: 1073741822

Explanation:
Integer	Binary
2147483644	01111111111111111111111111111100
1073741822	00111111111111111111111111111110

 

Constraints:

    0 <= n <= 231 - 2
    n is even.

 

Follow up: If this function is called many times, how would you optimize it?


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReverseBits {

    // 32 bits = 32 times
    // 6=110
    //   011
    // 8/2 = 4 0
    // 4/2 = 2 0
    // 2/2 = 1 0
    // 1/2 = 0 1
    public int reverseBits(int n) {
        
        long result = 0;
        int[] bits = new int[32];
        int index = 31;
            

        while (n >= 1) {
            bits[index] = n%2;
            
            index--;
            n = n/2;
        }

        

        for (int i= bits.length-1; i >=0; i--) {
            result += bits[i] * Math.powExact((long)2, i);
        }

        return (int) result;
    } 

    public static void main(String[] args) {
        var res = new ReverseBits().reverseBits(43261596);
        System.out.println(res);
    }
}

// 00000010100101000001111010011100
