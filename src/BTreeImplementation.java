import java.util.*;


class BTreeLinkedList{
    private class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;
    BTreeLinkedList(){
        this.root = null;
    }
    public void insert(int data){
        Node newNode = new Node(data);
        if(root==null){
            root = newNode;
            return;
        }
        Queue<Node> q  =  new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left==null){
                temp.left = newNode;
                break;
            }else{
                q.add(temp.left);
            }

            if(temp.right==null){
                temp.right = newNode;
                break;
            }else{
                q.add(temp.right);
            }
        }
    }
    public void inOrderTraversal(){
        System.out.println("Inoder traversal");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node current){
        if(current!=null){
            inOrder(current.left);
            System.out.print(current.data+" ");
            inOrder(current.right);
        }
    }
    //We can direclty do like this or follow the pattern for the inorder
    public void levelOrder(){
        System.out.println("Level Order Traversal");
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                level.add(temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            ans.add(level);
        }
        System.out.println(ans);
    }
}

public class BTreeImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of node :");
        int n = sc.nextInt();
        BTreeLinkedList t = new BTreeLinkedList();
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            t.insert(val);
        }
        t.inOrderTraversal();
        t.levelOrder();
    }
}
