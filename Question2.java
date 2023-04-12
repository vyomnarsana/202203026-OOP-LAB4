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

    public void insertAtBeginning(int data){

        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }


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

    public void insertAtIndex(int data, int index) {


        if (index == 1) {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        int i = 1;
        Node newNode = new Node(data);

        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        if (temp.next == null) {
            temp.next = newNode;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }


    public void deleteFromBeginning(){

        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        head = head.next;
    }

    public void deleteFromEnd(){

        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;

        }

        secondLast.next = null;
    }

    public void deleteFromIndex(int index) {

        if(head == null) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;
        int i = 1;

        while(i != index - 1) {
            temp = temp.next;
            i++;
        }

        if(temp.next == null) {
            deleteFromEnd();
            return;
        }

        temp.next = (temp.next).next;
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

public class Question2 {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.printLinkedList();

        list.insertAtBeginning(2);
        list.printLinkedList();

        list.insertAtBeginning(1);
        list.printLinkedList();

        list.insertAtEnd(4);
        list.printLinkedList();

        list.insertAtEnd(5);
        list.printLinkedList();

        list.insertAtIndex(3, 3);
        list.printLinkedList();

        list.deleteFromBeginning();
        list.printLinkedList();

        list.deleteFromEnd();
        list.printLinkedList();

        list.deleteFromIndex(2);
        list.printLinkedList();
    }
}
