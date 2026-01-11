public class MaxMinElementQueries {
    private static class Info {
        int max;
        int min;
        Info(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
    private static Info[] segmentTree = null;

    /* Initialization of the tree */
    public static void initialize(int[] arr) {
        segmentTree = new Info[4 * arr.length];
        return;
    }

    /* Display */
    public static void display() {
        for (Info info : segmentTree) {
            if (info == null)
                System.out.println("null, ");
            else
                System.out.println("[Max = " + info.max + ", Min = " + info.min + "], ");
        }
    }

    /* Building the tree */
    private static Info buildTreeUtil(int[] arr, int start, int end, int curr) {
        if (start == end) {
            segmentTree[curr] = new Info(arr[start], arr[start]);
            return segmentTree[curr];
        }
        int mid = start + (end - start)/2;
        Info leftSubtree = buildTreeUtil(arr, start, mid, 2*curr+1);
        Info rightSubtree = buildTreeUtil(arr, mid+1, end, 2*curr+2);
        segmentTree[curr] = new Info(Math.max(leftSubtree.max, rightSubtree.max), Math.min(leftSubtree.min, rightSubtree.min));
        return segmentTree[curr];
    }
    public static void buildTree(int[] arr) {
        buildTreeUtil(arr, 0, arr.length-1, 0);
    }

    /* Query on the tree */
    private static Info queryUtil(int segmentStart, int segmentEnd, int queryStart, int queryEnd, int curr) {
        /* Current segment does not overlap with the query range */
        if (queryStart > segmentEnd || queryEnd < segmentStart)
            return null;
        /* Current segment completely overlaps with the query range */
        if (queryStart <= segmentStart && segmentEnd <= queryEnd)
            return segmentTree[curr];
        /* Current segment partially overlaps with the query range */
        int mid = segmentStart + (segmentEnd - segmentStart)/2;
        Info leftResult = queryUtil(segmentStart, mid, queryStart, queryEnd, curr*2+1);
        Info rightResult = queryUtil(mid+1, segmentEnd, queryStart, queryEnd, curr*2+2);
        if (leftResult != null && rightResult != null)
            return new Info(Math.max(leftResult.max, rightResult.max), Math.min(leftResult.min, rightResult.min));
        else if (rightResult == null)
            return leftResult;
        else
            return rightResult;
    }
    public static int[] query(int[] arr, int queryStart, int queryEnd) {
        Info info = queryUtil(0, arr.length-1, queryStart, queryEnd, 0);
        if (info == null) return null;
        return new int[] {info.max, info.min};
    }

    /* Update on the tree */
    private static void updateUtil(int start, int end, int idx, int newValue, int curr) {
        if (start == idx && end == idx) {
            /* Leaf node condition */
            segmentTree[curr] = new Info(newValue, newValue);
            return;
        }
        /* Checking if the range overlaps */
        if (start <= idx && idx <= end) {
            /* This node is included in the current range */
            int mid = start + (end - start)/2;
            if (idx <= mid) /* This particular idx lies in the [start, mid] range */
                updateUtil(start, mid, idx, newValue, curr*2+1);
            else /* This particular idx lies in the [mid+1, end] range */
                updateUtil(mid+1, end, idx, newValue, curr*2+2);

            /* Now updating the parent */
            Info leftChild = segmentTree[curr*2+1];
            Info rightChild = segmentTree[curr*2+2];
            segmentTree[curr] = new Info(Math.max(leftChild.max, rightChild.max), Math.min(leftChild.min, rightChild.min));
        } else return; /* No overlap */
    }
    public static void update(int[] arr, int idx, int newValue) {
        if (idx < 0 || idx >= arr.length) return;
        arr[idx] = newValue;
        updateUtil(0, arr.length-1, idx, newValue, 0);
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        initialize(arr);
        buildTree(arr);
        // display();
        int[] res = query(arr, 3, 8);
        if (res == null) System.out.println("No result");
        else System.out.println("Max = " + res[0] + ", Min = " + res[1]);

        update(arr, 4, -67);
        res = query(arr, 3, 8);
        if (res == null) System.out.println("No result");
        else System.out.println("Max = " + res[0] + ", Min = " + res[1]);
    }
}
