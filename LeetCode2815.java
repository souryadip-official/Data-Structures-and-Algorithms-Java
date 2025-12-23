import java.util.Scanner;
class LeetCode2815 {
    public static int find(int num) {
        int lDg = 0;
        while(num > 0) {
            int dg = num % 10;
            lDg = Math.max(lDg, dg);
            num /= 10;
        }
        return lDg;
    }
    public static int maxSum_bruteForce(int[] nums) {
        if(nums.length == 1) return -1;
        int max = -1;
        for(int i=0; i<nums.length;i++) {
            for(int j=i+1; j<nums.length;j++) {
                int ps = nums[i] + nums[j];
                if(ps > max && find(nums[i]) == find(nums[j]))
                    max = ps;
            }
        }
        return max;
    }
    public static int maxSum_optimised(int[] nums) {
        /* max1[d]: stores the largest number with max digit d */
        /* max2[d]: stores the second-largest number with max digit d */
        int[] max1 = new int[10];
        int[] max2 = new int[10];
        for (int num : nums) {
            int d = find(num);
            if (num > max1[d]) {
                max2[d] = max1[d];
                max1[d] = num;
            } else if (num > max2[d]) {
                max2[d] = num;
            }
        }
        int ans = -1;
        for (int d = 0; d < 10; d++)
            if (max1[d] != 0 && max2[d] != 0)
                ans = Math.max(ans, max1[d] + max2[d]);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = sc.nextInt();
        int ans = maxSum_bruteForce(nums);
        if(ans != -1) System.out.println(ans);
        else System.out.println("No pair sum!");
        sc.close();
    }
}