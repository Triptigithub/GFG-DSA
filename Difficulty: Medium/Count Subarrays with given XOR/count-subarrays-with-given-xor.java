
//the question is bnased on the same concept that we use in no of sunarray with sum k 
//did usinfg strrive sde sheet arrya4
class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        //so
        int xr =0;
        HashMap<Integer,Integer> map = new HashMap<>(); //xor,freq
        map.put(0,1); //onitial confinxuration
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            xr = xr^arr[i]; 
            //now our x is
            int x = xr^k; //finding that entire subarray ka sum - k
            
            //resolve x first
            if(map.containsKey(x)){
                cnt+=map.get(x);
            }
            
            
            //then resolve our xr
            if(map.containsKey(xr)){
                int val = map.get(xr);
                map.put(xr,val+1);
            }else{
                map.put(xr,1);
            }
            
            
        }
        return cnt;
    }
}