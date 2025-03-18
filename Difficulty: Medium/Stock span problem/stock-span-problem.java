//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//here we used the concept of 
//nearest grester to left
//for every idex we find the next greater element to its left --> to maanage cnt
//we use idex of values like we subtract the index of current elemenet with the index of greater element to its left
//and then we added that in our ans arr


//we used the same generic etemplate as we use in all stack question
//here make sure you make st of pair in which you store value and its index

//MY First solution

class Pair{
    int num;
    int idx;
    public Pair(int num,int idx){
        this.num = num;
        this.idx = idx;
    }
}

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
         
         Stack<Pair> st = new Stack<>();
        ArrayList<Integer> ans= new ArrayList<>();
        
        
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty()){
                ans.add(1);
            }else if(!st.isEmpty() && st.peek().num > arr[i]){
                //Pair p = st.peek();
                    //window size= i-p.idx
                   // int window = i-(p.idx);
                    ans.add(i-(st.peek().idx));
                  
            }else if(!st.isEmpty() && st.peek().num <= arr[i]){
               
                    while(!st.isEmpty() && st.peek().num <= arr[i]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        ans.add(i+1); //if st empty ho gya iska mtlb sare values chote so sare chote values ka cnt i.e cur value ka idex and + current element ka cnt1 
                    }else{
                     
                     ans.add(i-st.peek().idx);
                    }
                    
             
                }
                
                st.add(new Pair(arr[i],i));
               
                
            }
            
           
            
        
        
        return ans;
    }
}