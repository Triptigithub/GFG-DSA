/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    public static boolean solver(Node node){
           if(node == null)return true;
        if(node.left == null && node.right == null)return true;
        int leftData = (node.left != null) ? node.left.data : 0;
           int rightData = (node.right != null) ? node.right.data : 0;
           if(node.data != leftData + rightData) return false;
        boolean left = solver(node.left);
        boolean right = solver(node.right);
           

        return left&&right;
    }
    public static int isSumProperty(Node root) {
       if(solver(root) == true)return 1;
       return 0;
    }
}