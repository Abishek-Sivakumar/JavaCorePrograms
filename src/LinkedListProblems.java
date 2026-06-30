//import java.util.Scanner;
//
//class Node {
//    int data;
//    Node next;
//    Node(int data){
//        this.data = data;
//        this.next = null;
//    }
//}
//
//public class LinkedListProblems {
//    public static void printList(Node head){
//        Node temp = head;
//        while(temp!=null){
//            System.out.print(temp.data+" -> ");
//            temp = temp.next;
//        }
//        System.out.print("null");
//    }
//
//    public static Node insertAtEnd(Node head, int val){
//        Node newNode = new Node(val);
//        if(head==null){
//            return newNode;
//        }
//        Node temp = head;
//        while(temp.next!=null){
//            temp = temp.next;
//        }
//        temp.next = newNode;
//        return head;
//    }
//
//    public static Node insertNode(Node head, int data){
//        // THIS IS FOR CIRCULAR LINKED LIST
//        Node newNode = new Node(data);
//        if(head==null){
//            head = newNode;
//            head.next = head;
//            return head;
//        }
//        Node temp = head;
//        while(temp.next!=head){
//            temp = temp.next;
//        }
//        temp.next = newNode;
//        newNode.next = head;
//        return head;
//    }
//
//    public static void printCircularList(Node head){
//        Node temp = head;
//        do{
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }while(temp!=head);
//    }
//
//    public static Node reverseListRecursive(Node head){
//        if(head==null || head.next==null){
//            return head;
//        }
//        Node newHead = reverseListRecursive(head.next);
//        Node front = head.next;
//        front.next = head;
//        head.next = null;
//        return newHead;
//    }
//
//    public static Node reverseList(Node head){
//        Node temp = head;
//        Node prev = null;
//        while(temp!=null){
//            Node front = temp.next;
//            temp.next = prev;
//            prev = temp;
//            temp = front;
//        }
//        return prev;
//    }
//
//    public static Node findMiddle(Node head){
//        Node slow = head;
//        // IMPORTANT CONDITIONS
//        Node fast = head;
//        while(fast!=null && fast.next!=null && fast.next.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    public static Node mergeLinkedList(Node head1, Node head2){
//        Node dummy = new Node(-1);
//        Node temp = dummy;
//        Node temp1 = head1;
//        Node temp2 = head2;
//        while(temp1!=null && temp2!=null){
//            if(temp1.data < temp2.data){
//                temp.next = temp1;
//                temp1 = temp1.next;
//            }else{
//                temp.next = temp2;
//                temp2 = temp2.next;
//            }
//            temp = temp.next;
//        }
//        if(temp1!=null){
//            temp.next = temp1;
//        }else{
//            temp.next = temp2;
//        }
//        return dummy.next;
//    }
//
//    public static Node sortList(Node head){
//        // DON'T FORTGET THE HEAD.NEXT
//        if(head==null || head.next==null){
//            return head;
//        }
//        Node middle = findMiddle(head);
//        Node left = head;
//        Node right = middle.next;
//        middle.next = null;
//        left = sortList(left);
//        right = sortList(right);
//        return mergeLinkedList(left, right);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Node head = null;
////        Node head2 = null;
//        System.out.println("Enter the number of nodes ");
//        int n = sc.nextInt();
//        for(int i=0;i<n;i++){
//            int val = sc.nextInt();
//            head = insertAtEnd(head,val);
//        }
//        Node sorted = sortList(head);
//        printList(sorted);
//    }
//}
