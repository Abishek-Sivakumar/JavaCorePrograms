import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListProblems {
    public static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static Node insertAtEnd(Node head, int val){
        Node newNode = new Node(val);
        if(head==null){
            return newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        System.out.println("Enter the number of nodes ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            head = insertAtEnd( head,val);
        }
        printList(head);
    }
}
