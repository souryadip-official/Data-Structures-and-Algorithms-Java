import java.util.Stack;
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); /* stack maintains surviving asteroids in order */
        for(int val: asteroids) {
            if (val >= 0)
                stack.push(val); /* positive asteroid moves right, so no immediate collision */
            else {
                val = Math.abs(val); /* convert negative asteroid to its size for comparison */
                boolean negDestroyed = false; /* tracks whether the current negative asteroid is destroyed */
                while(!stack.isEmpty() && !negDestroyed) {
                    int stcktop = stack.peek(); /* top asteroid which may collide */
                    if (stcktop < 0) break; /* the topmost element in the stack is also moving left, so collision is impossible */
                    if (stcktop < val) stack.pop(); /* smaller positive asteroid explodes, keep checking */
                    else if (stcktop == val) {
                        stack.pop();
                        negDestroyed = true; /* equal size, both asteroids explode */
                        break;
                    } else negDestroyed = true; /* larger positive asteroid survives, negative explodes */
                }
                if (!negDestroyed)
                    stack.push(-val); /* negative asteroid survives all collisions */
            }
        }
        int[] res = new int[stack.size()]; /* result array for remaining asteroids */
        int idx = 0;
        for(int val: stack)
            res[idx++] = val; /* preserving original order */
        return res;
    }
}