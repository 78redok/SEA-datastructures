import java.util.Stack;

public class Solution1 {
   public static void main(String[] args) {
      // your solution will be tested w/ random add()'s and remove()'s.
      // Observers like peek(), isEmpty() will be used along the way to validate.
      Solution sol = new Solution();
      sol.add(8); 
      sol.add(1); 
      System.out.println(sol.peek());    // 8, if you use System.out.print()
      System.out.println(sol.remove());  // 8
      System.out.println(sol.isEmpty()); // false
      sol.add(2); 
      sol.add(3); 
      System.out.println(sol.peek());    // 1    
      Solution sol2 = new Solution();
      sol2.add(3); 
      sol2.add(1);
      sol2.add(5); 
      sol2.add(7); 
      sol2.add(234); 
      System.out.println(sol2.peek());    
      System.out.println(sol2.remove());  
      System.out.println(sol2.remove());  
      System.out.println(sol2.remove());  
      System.out.println(sol2.isEmpty()); 
      sol2.add(222); 
      sol2.add(31); 
      System.out.println(sol2.peek());
      Solution sol3 = new Solution();
      System.out.println(sol3.isEmpty());
      Solution sol4 = new Solution();
      sol4.add(1);
      System.out.println(sol4.remove());
      sol4.add(2);
      sol4.add(3);
      System.out.println(sol4.peek());
      System.out.println(sol4.remove());
      System.out.println(sol4.remove());
      System.out.println(sol4.isEmpty());
   }
}
class Solution {
    // PLEASE USE THESE GLOBAL STACKS FOR THIS PROBLEM
    private Stack<Integer> pushStack = new Stack<Integer>();
    private Stack<Integer> popStack = new Stack<Integer>();
    /*
     * ==================================== 
     * !!! DO NOT MODIFY ABOVE THIS LINE!!!
     * ====================================
     */

    /**
     * PURPOSE: push x element onto pushStack
     * PARAMETERS: int x
     * RETURN VALUES: void
     */
    public void add(int x) {
        pushStack.push(x);
    }

    /**
     * PURPOSE: juggles between pushStack and popStack. pushStack elements get pushed into popStack in reverse order, popping the popStack stack gives remove value and also
     * returns pushStack by popping back elements into pushStack.
     * PARAMETERS: none
     * RETURN VALUES: temp
     */
    public int remove() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        int temp = popStack.pop();
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        return temp;
    }

    /**
     * PURPOSE: same juggling strategy except return value is the peek without popping, becoming the head of queue.
     * PARAMETERS: none
     * RETURN VALUES: temp
     */
    public int peek() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        int temp = popStack.peek();
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        return temp;
    }

    /**
     * PURPOSE: simple boolean isEmpty check 
     * PARAMETERS: none
     * RETURN VALUES: pushStack.isEmpty(); <-bool
     */
    public boolean isEmpty() {
        return pushStack.isEmpty();
    }
}