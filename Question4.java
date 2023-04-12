import java.util.Random;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}


class LinkedList {

    Node head;

    public void insertAtEnd(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node iterate = head;

        while(iterate.next != null){
            iterate = iterate.next;
        }
        iterate.next = newNode;
    }

    public void printLinkedList(){

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node iterate = head;
        while(iterate != null){
            System.out.print(iterate.data + " -> ");
            iterate =iterate.next;
        }
        System.out.println("NULL");

    }

}

public class Question4 {
    
    public static void main(String args[]) {
        
    LinkedList list = new LinkedList();
    Random rd = new Random();
    
    for(int i=0; i<100; i++) {
        list.insertAtEnd(rd.nextInt(51));
    }
    
    System.out.println("A Linked List of size 100 with range 1-50 is generated");
    list.printLinkedList();
    
    Node temp = list.head;
    Node prev = null;
    
    while(temp != null) {
        
        if(temp.data > 25) {
            
            if(prev == null) {
                list.head = list.head.next;
                temp = list.head;
            }
            
            else {
                prev.next = temp.next;
                temp = temp.next;
            }
        }
        
        else {
            prev = temp;
            temp = temp.next;
        }
        
    }
    System.out.println("Linked List after removing all nodes greater than 25");
    list.printLinkedList();
    }
}