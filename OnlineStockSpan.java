import java.util.ArrayList;
import java.util.Stack;
public class OnlineStockSpan {
    public static class StockSpanner01 {
        ArrayList<Integer> pricearr;
        public StockSpanner01() {
            this.pricearr = new ArrayList<>();
        }

        public int next(int price) {
            pricearr.add(price);
            int count = 0;
            for (int i=pricearr.size()-1; i>=0; i--) {
                if (pricearr.get(i) <= price)
                    count++;
                else break; /* because we are dealing with consecutive days */
            }
            return count;
        }
    }
    public static class StockSpanner02 {
        public static class Info {
            int val;
            int idx;
            public Info(int val, int idx) {
                this.val = val;
                this.idx = idx;
            }
        }
        Stack<Info> stack;
        int idx;
        public StockSpanner02() {
            this.stack = new Stack<>();
            this.idx = -1;
        }
        public int next(int price) {
            int prevGreaterIdx;
            if (stack.isEmpty())
                prevGreaterIdx = -1;
            else {
                while (!stack.isEmpty() && stack.peek().val <= price)
                    stack.pop(); /* If the elements before it are smaller, then after arrival of this new bigger element completely removes the chance of those elements to be someones previous greater element because now onwards, the previous greater element of any new smaller element would be this current new bigger element itself */
                if (stack.isEmpty())
                    prevGreaterIdx = -1;
                else
                    prevGreaterIdx = stack.peek().idx;
            }
            stack.push(new Info(price, ++idx));
            return (idx - prevGreaterIdx);
        }
    }
}
