//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalElements(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


//this question is based on variable size sliding window
//here to kept cnt of distinct lememnt i kept map(not a set)
//when map size is smaller than 2 - > we increase window size
//when map size is equal to 2 then we compute our ans and store the winodw lengtth in asn
//and also increase the wnodw


//when map size is bigger than the 2 then we shrink the window and remove arr[i] if it is present in set
//and then increase the window with j++;

//here we kept map instead of set bcz ex [2,2,2,2,3,4,4,4]
//here we push 2 ans 3 in set for example andwe are at index 5 now we cannot add 4 bcz we need two distinct element
//so we shrink the window by removinf index i from 0 to 1 now if we kept set
//then when we remove 2 -> the 2 we reoved should be for index 0 only but bcz we kept set it got removed


//so we should kept map and decrease the variable frequency as we shrink the window

class Solution {
    public static int totalElements(Integer[] arr) {
        if(arr.length == 1)return 1;
        if(arr.length == 2){
            if(arr[0] == arr[1])return 2;
        }
        int ans =0;

        int i=0;
        int j=0;
        
        HashMap<Integer,Integer> map = new HashMap<>(); //to store distinct element
        //this map stores the arrvalues,frequency
        
        while(j<arr.length){
            
            
            int value = arr[j];
            if(map.containsKey(value)){
                int cnt = map.get(value);
                cnt++;
                map.put(value,cnt);
            }else{
                map.put(value,1);
            }
            
            
            if(map.size() < 2){
                //we need to increase window length
                j++;
            }else if(map.size() == 2){
                //compute ans =
                ans = Math.max(ans,j-i+1);
                j++;
            }else if(map.size() > 2){
                //shrink the window
                
                while(map.size() >2){
                    
                    //here we val is present in set remove it
                    int num = arr[i];
                    
                    
                    if(map.containsKey(num)){
                        int cnt = map.get(num);
                        if(cnt <= 1){
                            map.remove(num);
                        }else{
                            cnt = cnt-1;
                            map.put(num,cnt);
                        }
                    }
                    
                    
                    
                    i++;
                    
                    
                }
                j++;//slide the window after shrinking
            }
            
        }
        
        return ans;
        
    }
}