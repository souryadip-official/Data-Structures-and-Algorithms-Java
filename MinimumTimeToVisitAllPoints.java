public class MinimumTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 0) return 0;
        int prevx = points[0][0];
        int prevy = points[0][1];
        int totalCost = 0;
        for (int i=1; i<points.length; i++) {
            int currx = points[i][0];
            int curry = points[i][1];
            int dx = Math.abs(currx - prevx);
            int dy = Math.abs(curry - prevy);
            totalCost += Math.max(dx, dy);
            prevx = currx;
            prevy = curry;
        }
        return totalCost;
    }
}