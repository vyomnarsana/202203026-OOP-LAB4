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

    public int searchForElement(Node head, int data) {

        if(head == null)
            System.out.println("The List is Empty");

        Node temp = head;
        int index = 1;
        while(temp != null) {

            if(temp.data == data)
                return index;

            temp = temp.next;
            index++;
        }

        return -1;
    }
}

public class Question3 {

    public static void main(String args[]) {

        LinkedList list = new LinkedList();

        list.insertAtEnd(1);
        list.insertAtEnd(5);
        list.insertAtEnd(7);
        list.insertAtEnd(3);
        list.insertAtEnd(8);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        
        list.printLinkedList();

        int index = list.searchForElement(list.head, 7);

        if(index == -1)
            System.out.println("Element 7 is not found");

        else
            System.out.println("Element 7 is found at index "+index);
    }
}