
class StackLinkedList{
    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            this.next = null;
        }
    }
    private Node top;
    private int size;

    StackLinkedList(){
        this.top =null;
        this.size=0;
    }
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed"+data);
    }
    public void display(){
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public int pop(){
        int poppedVal = top.data;
        top = top.next;
        return poppedVal;
    }
}

public class StackImplementation {
    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();
        s.push(10);
        s.push(20);
        s.push(30);
        s.pop();
        s.display();
    }
}
