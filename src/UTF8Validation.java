/**
 * @author Davis Jeffrey
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given an integer array data representing the data, return whether it is a valid UTF-8 encoding
 * (i.e. it translates to a sequence of valid UTF-8 encoded characters).
 *
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *
 *     For a 1-byte character, the first bit is a 0, followed by its Unicode code.
 *     For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0,
 *     followed by n - 1 bytes with the most significant 2 bits being 10.
 *
 * Link: https://leetcode.com/problems/utf-8-validation/
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        //Check value of data, see how many bytes are supposed to be there
        //Check if those bytes are present correctly
        for (int i = 0; i < data.length; i++) {
            int nextBytes = 0;

            if ((data[i] | 0b01111111) == 0b01111111) {
                //1 byte,   0xxxxxxx
                nextBytes = 0;
            } else if ((data[i] | 0b00011111) == 0b11011111) {
                //2 bytes,  110xxxxx
                nextBytes = 1;
            } else if ((data[i] | 0b00001111) == 0b11101111) {
                //3 bytes,  1110xxxx
                nextBytes = 2;
            } else if ((data[i] | 0b00000111) == 0b11110111) {
                //4 bytes,  11110xxx
                nextBytes = 3;
            } else {
                return false;
            }

            for (int j = 0; j < nextBytes; j++) {
                i++;
                //Required byte doesn't exist
                if (i >= data.length) {
                    return false;
                }
                //Byte exists, but not in the format we expect
                if ((data[i] | 0b00111111) != 0b10111111) {
                    return false;
                }
            }
        }
        return true;
    }
}
