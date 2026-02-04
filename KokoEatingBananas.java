public class KokoEatingBananas {
    public int minEatingSpeedLinearSearch(int[] piles, int h) {
        int maxEle = Integer.MIN_VALUE;
        for (int ele: piles)
            maxEle = Math.max(maxEle, ele);

        for (int speed=1; speed<=maxEle; speed++) {
            long currTime = 0;
            for (int ele: piles)
                currTime += ((long) Math.ceil(ele / (double) speed));
            if (currTime <= h)
                return speed; /* minimum speed found */
        }
        return -1;
    }

    public int minEatingSpeedBinarySearch(int[] piles, int h) {
        int maxEle = Integer.MIN_VALUE;
        for (int ele: piles)
            maxEle = Math.max(maxEle, ele);

        int minSpeed = 1;
        int maxSpeed = maxEle;
        int ans = Integer.MAX_VALUE;
        while (minSpeed <= maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed)/2;
            long currTime = 0;
            for (int ele: piles)
                currTime += ((long) Math.ceil(ele / (double) midSpeed));

            if (currTime <= h) {
                ans = Math.min(ans, midSpeed);
                maxSpeed = midSpeed - 1;
            } else {
                minSpeed = midSpeed + 1;
            }
        }
        return ans;
    }
}
