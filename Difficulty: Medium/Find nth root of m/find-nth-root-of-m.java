class Solution {
    public int nthRoot(int n, int m) {
        int s = 1;
        int e = (int)1e9;
        int ans =-1;
        
        
        while(s<=e){
            
            
            int mid = s+(e-s)/2;
            
          
            int result = (int) Math.pow(mid, n); //n= 4 //x =3 4^3 = 64
            if(result == m){
                ans = mid;
                return ans;
            }
            
            if(result<m){
                s = mid+1;
                
            }else{
                e = mid-1;
            }
        }
        
        return ans;
        
    }
}