public class AddDigits {
    public int addDigits(int num) {
        int temp = num;
        int add = 0;
        while(temp > 0) {
            int dg = temp % 10;
            add += dg;
            temp = temp / 10;

            if (temp == 0 && add > 9) { /* current number is exhausted but the addition is still greater than 9, so in that case, we need to the addition on this new addition number */
                temp = add;
                add = 0;
            }
        }
        return add;
    }
}