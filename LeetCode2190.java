class LeetCode2190 {
    /* Way 1: Using Sorting, Time Complexity: O(nlogn), Space Complexity: O(n)
    public int mostFrequent(int[] nums, int key) {
        ArrayList<Integer> target = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
            if(nums[i] == key && i+1 != nums.length)
                target.add(nums[i+1]);

        if(target.size() == 1) return target.get(0);
        Collections.sort(target);
        int ans = 0, count = 0;
        int maxCount = 0;
        int prev = target.get(0);
        for(int i=1; i<target.size(); i++) {
            if(target.get(i) == prev) {
                count++;
                if(i+1 == target.size() && count > maxCount)
                    ans = prev;
            } else {
                if(count > maxCount) {
                    maxCount = count;
                    ans = prev;
                }
                prev = target.get(i);
                count = 1;
            }
        }
        return ans;
    }   */
    /* Way 2: Using count array: Time Complexity: O(n+m), Space Complexity: O(m) [m is the largest number in nums] */
    public int mostFrequent(int[] nums, int key) {
        /* find the maximum element in nums */
        int max = 0;
        for(int num : nums) max = Math.max(max, num);
        int[] count = new int[max+1];
        for(int i=0; i<nums.length-1; i++)
            if(nums[i] == key) count[nums[i+1]]++;
        int maxCount = 0;
        int ans = 0;
        for(int i=0; i<count.length; i++) {
            if(count[i] > maxCount) {
                maxCount = count[i];
                ans = i;
            }
        }
        return ans;
    }
}