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

    public static Node insertBSTNode(Node root, int val){
        if(root==null){
            return new Node(val);
        }
        if(root.data > val){
            root.left = insertBSTNode(root.left, val);
        }else if(root.data < val){
            root.right = insertBSTNode(root.right, val);
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
            root = insertBSTNode(root, val);
        }
        inOrderTraversal(root);
    }
}

