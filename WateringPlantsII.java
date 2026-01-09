public class WateringPlantsII {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0, j = plants.length-1;
        int ca = capacityA;
        int cb = capacityB;
        int totalRefill = 0;
        while (i <= j) {
            if (i == j) {
                if (ca >= cb) { /* If the capacity of Alice is more or equal to the capacity of Bob, then Alice should water the plant */
                    if (ca < plants[i]) {
                        ca = capacityA;
                        totalRefill++;
                    }
                    ca -= plants[i];
                } else {
                    if (cb < plants[i]) {
                        cb = capacityB;
                        totalRefill++;
                    }
                    cb -= plants[i];
                }
                return totalRefill;
            }
            int pa = plants[i];
            int pb = plants[j];
            if (pa > ca) {
                ca = capacityA;
                totalRefill++;
            }
            ca -= pa;
            i++;
            if (pb > cb) {
                cb = capacityB;
                totalRefill++;
            }
            cb -= pb;
            j--;
        }
        return totalRefill;
    }
}