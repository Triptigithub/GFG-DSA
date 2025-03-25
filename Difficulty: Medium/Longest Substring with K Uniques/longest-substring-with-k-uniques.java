//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

// we will use map to store character and its frequency
//every time we reach to an element we increase its frequecny in map
//if map size chota h k se then increase window
//if queal h then compute and and slide window
//if size bda h map ka k se then shrink the window remove ith element or decrease the frequency of ith value in map and at last slide the window


class Solution {
    public int longestkSubstr(String s, int k) {
    
    HashMap<Character,Integer> hs = new HashMap<>();
    int i=0;
    int j=0;
    int maxi =-1;
    
    
    while(j<s.length()){
        
        //do calculation
        //fill the hashmap with the character and its frequency
        
        if(hs.containsKey(s.charAt(j))){
            int cnt = hs.get(s.charAt(j));
            hs.put(s.charAt(j),cnt+1);
        }else{
            hs.put(s.charAt(j),1);
        }
        
        
        int x = hs.size();
        if(x<k){
            //just slide
            j++;
        }else if(x == k){
            maxi = Math.max(maxi,j-i+1);  //find ans from calculation
            j++;  //slide
        }else if(x>k){
            
            //try to shrink
            while(hs.size()>k){
                char y= s.charAt(i);
                if (hs.containsKey(y)) {
                        if (hs.get(y) == 1) {
                            hs.remove(y);  // Properly remove key
                        } else {
                            hs.put(y, hs.get(y) - 1);  // Decrease count safely
                        }
                    }
                
                i++; 
            }
            j++; //slide window
        }
    }
    
   
    return maxi;
    
    }
}