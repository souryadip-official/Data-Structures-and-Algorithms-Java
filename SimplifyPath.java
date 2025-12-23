import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;
public class SimplifyPath {
    public String simplify_usingStack(String path) {
        Stack<String> s = new Stack<>();
        String[] dirs = path.split("/");
        for(int i=0; i<dirs.length; i++) System.out.print(dirs[i] + " ");
        for(int i=0; i<dirs.length; i++) {
            if(dirs[i].equals("..") && !s.isEmpty())
                s.pop();
                /* If we have some directory already pushed onto the stack, then we need to move back by popping it. If the stack is empty, that means we are at the root and from here, we cannot go back, because there is no directory available above root */
            else if(!dirs[i].equals("") && !dirs[i].equals("/") && !dirs[i].equals(".") && !dirs[i].equals(".."))
                s.push(dirs[i]);
        }

        /* We can create a separate arraylist to store the contents of the stack and then traverse it to form the final output */

        /* ArrayList<String> arr = new ArrayList<>();
        while(!s.isEmpty()) arr.add(0, s.pop());
        if(arr.size() == 0) return "/";
        StringBuilder res = new StringBuilder();
        for(int i=0; i<arr.size();i++)
            res.append("/").append(arr.get(i));
        return res.toString(); */

        /* Otherwise, as we know that Stack, ArrayLists, all are subclasses of the parent class List. So, all the general functions that work on an arraylist and the way arraylist is arranged, we can manipulate a stack in the exact same way. So, using this approach we can also form the final answer */
        if(s.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.size(); i++)
            res.append("/").append(s.get(i));
        return res.toString();
    }
    public static String simplify_Approach1(String path) {
        String[] compo = path.split("/");
        ArrayList<String> dirs = new ArrayList<>(Arrays.asList(compo));
        for(int i=0; i<dirs.size(); i++)
            if(dirs.get(i).equals("") || dirs.get(i).equals(".")) {
                dirs.remove(i);
                i--;
            }
        /* this is because both "" and "." represent current directory only and hence we need to remove them */
        for(int i=0; i<dirs.size(); i++) {
            if(dirs.get(i).equals("..")) {
                dirs.remove(i);
                if(i != 0) {
                    dirs.remove(i-1);
                    i--;
                }
                i--;
            }
        }
        /* Wherever we find a "..", it means we are moving outside the directory, so we remove the current ".." and the respective directory from dirs */
        if(dirs.size() == 0) return "/";
        StringBuilder str = new StringBuilder();
        for(int i=0; i<dirs.size(); i++)
            str.append("/").append(dirs.get(i));
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path: ");
        String path = sc.next();
        System.out.println("Simplified path: " + simplify_Approach1(path));
        sc.close();
    }
}
