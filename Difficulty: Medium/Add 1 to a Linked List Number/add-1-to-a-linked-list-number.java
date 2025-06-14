/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

//did on my own code 
//intuitionn by striver

class Solution {
public Node reverse(Node node) {
    Node prev = null;
    Node temp = node;

    while (temp != null) {
        Node next = temp.next;
        temp.next = prev;
        prev = temp;
        temp = next;
    }

    return prev; // return the new head
}
    public Node addOne(Node head) {
       head = reverse(head);
       Node temp = head;
       int carry = 1;
       while(temp!= null){
           int val = temp.data+carry;
           if(val>9){
               //means two dig h
               int first = val / 10;   // 12 / 10 = 1
               int second = val % 10;  // 12 % 10 = 2
               
               carry = first;
               temp.data = second;
               temp = temp.next;
               
           }else{
               carry = 0;
               temp.data = val;
               temp = temp.next;
                 
           }
       }
       
       
      head = reverse(head);
       Node newhead = null;
       if(carry !=0){
          newhead = new Node(carry);
          newhead.next = head;
          return newhead;
       }
       
       
      return head;
       
       
    }
}