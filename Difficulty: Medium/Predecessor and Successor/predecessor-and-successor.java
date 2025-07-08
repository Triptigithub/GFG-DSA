/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
       ArrayList<Node> ans = new ArrayList<>();
       Node pre = null;
       Node suc = null;
       
       
       Node cur = root;
       while(cur!= null){
           if(cur.data<key){
               pre = cur;
               cur = cur.right;
           }else{
               cur = cur.left;
           }
       }
       ans.add(pre);
        
        
        
        
        
        Node node = root;
        
        while(node!= null){
             if(node.data> key){
                 suc = node;
                 node = node.left;
             }else{
                 node = node.right;
             }
        }
        ans.add(suc);
        
        
        
        return ans;
    }
}