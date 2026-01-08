public class MountainRanges {
    public static int mountainRanges(int pairs) {
        if (pairs == 0 || pairs == 1) return 1;

        int[] mountainCount = new int[pairs + 1];
        mountainCount[0] = 1; /* 0 pairs: empty mountain */
        mountainCount[1] = 1; /* 1 pair: single mountain */

        for (int currentPairs = 2; currentPairs <= pairs; currentPairs++) {
            /* Considering one pair at a time. We need to find out the number of valid mountains considering some pairs within this pair and some pair outside this */
            int totalMountains = 0;
            for (int innerPairs = 0; innerPairs <= currentPairs - 1; innerPairs++) {
                int inside = mountainCount[innerPairs]; /* mountains completely inside current mountain */
                int outside = mountainCount[currentPairs - innerPairs - 1]; /* mountains outside current mountain */
                totalMountains += inside * outside;
            }
            mountainCount[currentPairs] = totalMountains;
        }
        return mountainCount[pairs];
    }
    public static void main(String[] args) {
        System.out.println(mountainRanges(5));
    }
}
