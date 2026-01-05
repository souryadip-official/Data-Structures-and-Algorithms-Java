public class PlusOne {
    public int[] plusOne(int[] digits) {
        StringBuilder res = new StringBuilder(); /* to store the resultant addition */
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
            if (carry == 0) {
                /* Just copy the left-overs */
                int idx = i;
                while(idx >= 0) {
                    res.append(digits[idx]);
                    idx--;
                }
                break;
            }
            int val = digits[i];
            if (val == 9) {
                res.append(0);
                /* we have a further carry of 1, so carry remains unchanged */
            } else {
                res.append(val + carry);
                carry = 0; /* addition completed */
            }
        }
        if (carry == 1) res.append(1); /* Just in case we traversed the entire digits, but we still have a carry of one. For example, for 999, after traversing the entire digits array, we will still be left with a carry of 1 */

        String addOne = res.reverse().toString();
        int[] finalAns = new int[addOne.length()];
        for(int i=0; i<addOne.length(); i++)
            finalAns[i] = Integer.parseInt(addOne.charAt(i)+"");
        return finalAns;
    }
}