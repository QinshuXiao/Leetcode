/**
 * Created by qinshuxiao on 2018/6/18.
 */
public class ReverseBits {

    /**
     * The easiest one is taking use of 32-bits space.
     * we travel through all 32 bits and do some bit operations to build the new number.
     * Time complexity is O(32)
     */

    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; ++i){
            res <<= 1;
            res |= (n&1);
            n >>= 1;
        }

        return res;
    }

    /**
     * But What if this function is frequently accessing?
     *
     * All right, maybe we can use Divide & Conquer way
     * Suppose we meet a num with n bits.
     * 1. split n-bit num into two part.
     *     Left part is n-th bit to (n/2)-th bit.
     *     Right part is (n/2)-th bit to 0 bit.
     * 2. Then we reverse Left part and Right part individualy.
     * 3. Finally we swap the position of Left and Right,
     *    so that Original Right becomes Current Left, and original Left becomes current Right.
     *
     */

    public int DCreverseBits(int n){
        return reverse(n, 32);
    }

    private int reverse(int n, int len){
        if(n == 0 || len == 1) return n;

        int halfLen = len >> 1;

        // extract Left part and Right part
        int leftBits = n >>> halfLen;
        int rightBits = n & ((1 << halfLen) - 1);
        // Reverse Left part and Right part individually
        int left = reverse(leftBits, halfLen), right = reverse(rightBits, halfLen);

        // swap position of Right and Left
        return ((right << halfLen) >>> 0 | left) >>> 0;
    }
}
