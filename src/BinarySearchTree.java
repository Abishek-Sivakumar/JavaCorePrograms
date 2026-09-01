import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {

    public static Node insertNode(Node root, int val){
        if(root==null){
            return new Node(val);
        }
        if(root.data > val){
            root.left = insertNode(root.left, val);
        }else if(root.data < val){
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    public static void inOrderTraversal(Node root){
        if(root!=null){
            inOrderTraversal(root.left);
            System.out.print(root.data);
            inOrderTraversal(root.right);
        }
    }

    public static Node leastCommonAncestor(Node root, Node left, Node right){
        if(root==null){
            return null;
        }
        if(root.data > left.data && root.data > right.data){
            return leastCommonAncestor(root.left, left, right);
        }else if(root.data < left.data && root.data < right.data){
            return leastCommonAncestor(root.right, left, right);
        }
        return root;
    }

    public static int findHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int isBalanced(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = isBalanced(root.left);
        int rightHeight = isBalanced(root.right);
        if(leftHeight==-1 || rightHeight==-1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //public static int count = 0;
    //public static int result = 0;
//    public static void findKSmallest(Node root){
//        if(root==null || count==0){
//            return;
//        }
//        findKSmallest(root.left);
//        count--;
//        if(count==0){
//            result = root.data;
//            return;
//        }
//        if(count>0){
//            findKSmallest(root.right);
//        }
//    }

    public static int countLeafNodes(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    //THIS IS FOR ONLY BINARY TREES, AND DOES NOT WORK FOR BST
    //                      1
//                         /  \
//                        2    2
//                       / \   / \
//                      3  4   4  3
//                      VERY IMPORTANT NOTICE THE root.left.left and root.right.right are equals
//                      and                       root.left.right and root.right.left are equal
//                                          THis differentiates from the isIdentical problem
//    public static boolean isSymmetric(Node root){
//        if(root==null){
//            return false;
//        }
//        return isMirror(root.left, root.right);
//    }
//
//    public static boolean isMirror(Node left, Node right) {
//        if (left == null && right == null) {
//            return true;
//        }
//        if (left == null || right == null) {
//            return false;
//        }
//        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
//    }

    // VERY IMPORTANT : IT IS ALMOST SIMILAR TO FINDING SYMMENTRIC FUNCTION WITH EXCEPTION OF PASSING THE ROOTS
    public static boolean isIdentical(Node root1, Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
//                          20
//                         /  \
//                        8    22
//                       / \
//                      4   12
//                         /  \
//                        10  14
//        root = insertNode(root, 20);
//        root = insertNode(root, 8);
//        root = insertNode(root, 22);
//        root = insertNode(root, 4);
//        root = insertNode(root, 12);
//        root = insertNode(root, 10);
//        root = insertNode(root, 14);
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            root = insertNode(root, val);
        }
        inOrderTraversal(root);
    }
}

