import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] finalArray = new int[digits.length + 1];
        finalArray[0] = 0;
        int borrow = 0;
        int result = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int curr = digits[i];
            if (i == digits.length - 1) {
                result = curr + 1;
            } else {
                result = curr + finalArray[i + 1];
            }

            if (result >= 10) {
                borrow = 1;
                result = 0;

                finalArray[i + 1] = result;
                finalArray[i] = borrow;
            } else {
                finalArray[i + 1] = result;
            }
        }

        if (finalArray[0] == 0) {
            return Arrays.copyOfRange(finalArray, 1, finalArray.length);
        }

        return finalArray;
    }

    public static void main(String[] args) {
        int[] digits = { 9, 9 };

        digits = new PlusOne().plusOne(digits);

        System.out.println(Arrays.toString(digits));
    }

}
