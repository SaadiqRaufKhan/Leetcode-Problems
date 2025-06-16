/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node finalHead = null;
        Node finalTail = null;
        Node oldHead = head;
        Map<Node, Node> oldToNew = new HashMap<>();  // a -> a' 
        Map<Node, Node> newToOld = new HashMap<>(); // a'-> a

        // first make a basic copy of the list without the random pointers and populate the HashMaps 
        while(oldHead != null) {
            Node newNode = new Node(oldHead.val);
            if(finalHead == null) {
                finalHead = newNode;
                finalTail = newNode;
            }
            else {
                finalTail.next = newNode;
                finalTail = newNode;
            }
            oldToNew.put(oldHead, newNode);
            newToOld.put(newNode, oldHead);
            oldHead = oldHead.next;
        }

        // now we need to set the random pointers
        // if in the original list we had a.random = b then now we need to make it as a'.random = b'
        Node newHead = finalHead;
        while(newHead != null) {
            Node oldRandom = (newToOld.get(newHead)).random; // get the random pointer of the corresponding node in the original list
            if(oldRandom == null) {
                newHead.random = null;
            }
            else {
                newHead.random = oldToNew.get(oldRandom);     // set the random using the hashmap
            }
            newHead = newHead.next;
        }

        return finalHead;
    }


}