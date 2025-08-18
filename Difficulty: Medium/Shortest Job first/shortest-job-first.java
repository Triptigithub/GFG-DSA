// User function Template for Java
import java.util.*;
class Solution {
    static int solve(int bt[]) {
      Arrays.sort(bt); 
        int sum = 0;
        int[] dum = new int[bt.length];
        for(int i=0; i<=bt.length-2; i++){
            dum[i+1] = dum[i]+bt[i];
            sum += dum[i+1];
        }
         return sum / bt.length; 
        
        
    }
}
