//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



//so it is a special type of question 
//where it seems we can use sliding but we caant


//so here what we didi is we kept a prrfixsum variable which keep track of variable ke sum ka 
//now as some pt if we get sum as letsay sum = 15
//and we need to find k = 12
//then from the hashmap we can check kya 15-12 khi pr aya h
//agar toh phle kabhi bhi 3 aya hoga as a prefixsum vo hashmap mein hoga
//then jo bhi index tak sum3 aya tha vo bhi hashmap mein hoga like(3,2)
//so here index 2 pr hmara sum 3 aya tha
//so abhi current index ex 5 
//(cuurent index )-(x-k ka index) -> 5-2
//so 3 window ke lengthm mein hmara ans hoga



//example
/***

           0 1 2  3  4  5
arr        1 2 3  4  5  6
prefixsum  1 3 6 10 15 21

//so here at index 4 sum = 15 and we want k =12
//so 15-12 =3 kya sum = 3 present h previously yes (sum=3,index=1)
//so our lengtth = 15 ka index  - x-k ka index
l = 4-1 = 3(i.e 3 4 5 ka sum 12 dega)
 */


class Solution {
    public int longestSubarray(int[] arr, int k) {
        int maxlen = 0;
        int prefixsum = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefixsum +=arr[i];
            if(prefixsum == k){
                maxlen = Math.max(maxlen,i+1);
            }
            
            int x = prefixsum - k;
            if(map.containsKey(x)){
                int len = i - map.get(x);
                maxlen = Math.max(maxlen,len);
            }
            if (!map.containsKey(prefixsum)) {
                map.put(prefixsum, i);
            }
        }
        
        return maxlen;
    }
}
