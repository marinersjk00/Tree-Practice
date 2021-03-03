public class Node {

    int data;
    Node left;
    Node right;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

}

class BinaryTree {

    static Node root;

    BinaryTree() {
        root = null;
    }

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

    public static boolean containsNode(Node curr, int n) {
        if (curr == null) {
            //  System.out.println("Integer not Found.");
            return false;
        }
        if (curr.data == n) {
            // System.out.println("Integer Found.");
            return true;
        }
        if (n > curr.data) {
            return containsNode(curr.right, n); //searches again, shifting root to the right
        } else {
            return containsNode(curr.left, n); //searches again, shifting root to left
        }

    }

    public static int findSmallest(Node root) {
        int smallest;
        while (root.left != null) { //finds the leftmost child which is the smallest node
            root = root.left;
        }
        smallest = root.data;
        return smallest;

    }

    public static Node deleteNode(Node root, int n) {

        if (root == null) { //list is empty
            System.out.println("Node not found.");
            return null;
        }

        if (n < root.data) { //move to left where numbers are smaller
            root.left = deleteNode(root.left, n);
        } else if (n > root.data) { //move to right where numbers are bigger
            root.right = deleteNode(root.right, n);
        } else {
            //if there are zero or one children
                if (root.left == null) { 
                    return root.right; //returns right value if root.right is not null, returns null if root.right is null
                } else if (root.right == null) {
                    return root.left;
                }
                //if there are two children
                root.data = findSmallest(root.right); //finds next inorder on right subtree
                root.right = deleteNode(root.right, root.data); //deletes node and replaces it with inorder successor

            }

        

        return root;
    }

    public static void delete(int n) {
        root = deleteNode(root, n);
    }

    public static boolean contains(int n) {
        return containsNode(root, n);
    }

    public static void add(int n) {
        if(!contains(n)){
        root = addNode(root, n);
        }else{
            System.out.print("No Duplicates.");
        }

    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);

        postOrder(root.right);

        System.out.print(root.data + " ");
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);

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
