import java.util.ArrayList;
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] {newInterval};

        ArrayList<int[]> res = new ArrayList<>();
        int ns = newInterval[0];
        int ne = newInterval[1];
        int i;

        /* Adding intervals before newInterval */
        for (i=0; i<intervals.length; i++) {
            int currEnd = intervals[i][1];
            if (ns <= currEnd) break;
            else res.add(intervals[i]);
        }

        /* Determining the start of the merged interval */
        int start = ns; /* default start is newInterval's start. This is because if this interval is greater than all the available intervals, then this is going to mark the new beginning or start of an interval */
        if (i < intervals.length)
            start = Math.min(ns, intervals[i][0]);

        /* Merge overlapping intervals */
        int j = i;
        while (j < intervals.length && intervals[j][1] < ne) /* interval that can be merged */
            j++;

        if (j == intervals.length) {
            /* If we have reached the end, we just need to add the merged interval */
            res.add(new int[] {start, ne});
        } else if (intervals[j][0] > ne) {
            /* No overlap with the current interval */
            res.add(new int[] {start, ne});
        } else {
            /* Overlap exists, so handling the overlap */
            res.add(new int[] {start, Math.max(intervals[j][1], ne)});
            j++;
        }

        /* Appending the remaining intervals */
        for (; j<intervals.length; j++)
            res.add(intervals[j]);

        /* Building the result 2d array */
        int[][] finalAns = new int[res.size()][2];
        for (int k=0; k<res.size(); k++)
            finalAns[k] = res.get(k);

        return finalAns;
    }
}