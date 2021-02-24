/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jskuschner
 */
public class Node {
    int data;
    Node left;
    Node right;
    
    Node(){}
    Node(int data){
        this.data = data;
    }
   
}

 class BinaryTree {
     
    static Node root;

    public static Node addNode(Node root, int n) {
        Node curr = root;
        if (curr == null) {
            return new Node(n); //creates a new node
        } else {
            if (n <= curr.data) { //adds left child if n value is less than root value
                curr.left = addNode(curr.left, n);
            } else if (n > curr.data) { //adds right child if n value is greater than root value
                curr.right = addNode(curr.right, n);
            }
        }
        return curr;
    }
    public static boolean containsNode(Node curr, int n){
        if (curr == null){
            System.out.println("Integer not Found.");
            return false;
        }
        if (curr.data == n){
            System.out.println("Integer Found.");
            return true;
        }
            if(n > curr.data){
                return containsNode(curr.right, n); //searches again, shifting root to the right
            }else{
                return containsNode(curr.left, n); //searches again, shifting root to left
            }
        
        
    }
    public static int findSmallest(Node root){
        int smallest;
        while (root.left != null){ //finds the leftmost child which is the smallest node
            root = root.left;
        }
        smallest = root.data;
        return smallest;
        
    }
    public static Node deleteNode(Node curr, int n){
        
        if (curr == null){ //list is empty
           // System.out.println("Nothing to delete.");
            return null;
        }
        
        if (curr.data == n){ //element to be deleted is found
            if(curr.left == null && curr.right == null){ //no children
                return null;
            }
            if(curr.left == null && curr.right != null){ //if node has one child on right
                curr = curr.right;
                return curr;
            }
            if(curr.right == null && curr.left != null){ //if node has one child on left
                curr = curr.left;
                return curr;
            }
            if(curr.right != null && curr.left != null){ //two children
                int smallest = findSmallest(curr); //finds smallest number from current root
                curr.data = smallest; //sets current data to the smallest number from current root
                curr.right = deleteNode(curr.right, smallest); //deletes the repeated smallest value and sets proper pointer
                return curr;
                
                
            }
        }
        
        if (n < curr.data){ //move to left where numbers are smaller
            curr.left = deleteNode(curr.left, n);
        }else if(n > curr.data){
            curr.right = deleteNode(curr.right, n);
        }
        
        
    
        
        return curr;
    }
    
    public static void delete(int n){
        root = deleteNode(root, n);
    }
            
    public static boolean contains(int n){
        return containsNode(root, n);
    }
    
    public static void add(int n) {
        root = addNode(root, n);
    }

    public static void printBinaryTree(Node root, int level) { //print function taken from stackexchange
        if (root == null) {
            return;
        }
        printBinaryTree(root.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + root.data);
        } else {
            System.out.println(root.data);
        }
        printBinaryTree(root.left, level + 1);
    }

}
