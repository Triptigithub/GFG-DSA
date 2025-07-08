/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    int cnt =0;
    
    void inorder(Node root, int l,int h){
        if(root == null)return;
        
        inorder(root.left,l,h);
        if(root.data >= l && root.data <=h )cnt++;
        inorder(root.right,l,h);
        
        
        
    }
    int getCount(Node root, int l, int h) {
       //do inorder and 
       inorder(root,l,h);
       return cnt;
        
    }
}