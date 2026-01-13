public class BrowserHistory {
    public static class Node {
        String url;
        Node next;
        Node prev;
        public Node (String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    private static Node head = null;
    private static Node tail = null;
    private static Node curr = null;

    public BrowserHistory(String homepage) {
        Node newNode = new Node(homepage);
        BrowserHistory.head = BrowserHistory.tail = BrowserHistory.curr = newNode;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        /* We are visiting a new URL. So, all forward history up till now must be deleted */
        curr.next = null;
        curr.next = newNode;
        newNode.prev = curr;
        curr = tail = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && curr != head) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    public String forward(int steps) {
        int currStep = 1;
        while (currStep <= steps && curr != tail) {
            curr = curr.next;
            currStep++;
        }
        return curr.url;
    }
}