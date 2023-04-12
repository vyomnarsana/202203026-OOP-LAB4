#include<iostream>

using namespace std;

class Node{

	public :
		int data;
		Node *next;

	Node(int data) {
		this->data = data;
		this->next = NULL;
	}

	~Node() {
		int deletedData = this->data;
		if(this->next != NULL){
			delete next;
			this->next = NULL;
		}
		cout<<"MEMORY FREE"<<endl;
	}
};

void insertAtBeginning(Node* &head, int data){

	Node* temp = new Node(data);

	temp->next = head;
	head = temp;
}

void insertAtEnd(Node* &head, int data) {

	Node* temp = new Node(data);
    Node* iterate = head;
    
    while(iterate->next != NULL) {
        iterate = iterate->next;
    }

    iterate->next = temp;
}

void insertAtIndex(Node* &head, int index, int data){

	if(index == 1){
		insertAtBeginning(head,data);
		return;
	}
	
	Node* temp = head;
	int c=1;
	
	while(c < index-1){
		temp = temp->next;
		c++;
	}
	
	if(temp->next == NULL){
		insertAtEnd(head,data);
		return;
	}
	
	Node*  newNode = new Node(data);

	newNode->next = temp->next;
	temp->next = newNode;
	
}

void deleteFromBeginning(Node* &head){

Node * temp = head;
head = head->next;

temp->next = NULL;
delete temp;
}

void deleteFromEnd(Node* &head) {
    Node* behind = head;
    Node* ahead = head->next;

    while(ahead->next != NULL) {
        ahead = ahead->next;
        behind = behind->next;
    }

    behind->next = NULL;
    delete ahead;
}

void deleteFromIndex(Node* &head, int index) {
    Node* temp = head;

    int i = 1;

    while(i != index - 1) {
        temp = temp->next;
        i++;
    }

    Node* toBeDeleted = temp->next;

    temp->next = toBeDeleted->next;
    
    toBeDeleted->next = NULL;
    delete toBeDeleted;
}

void printLinkedList(Node* &head){
	Node* temp = head;

	while(temp != NULL){
		cout<<temp->data<< " -> ";
		temp = temp->next;
	}
    cout<<"NULL"<<endl;	
}

int main() {

    Node* head = NULL;

    printLinkedList(head);

    insertAtBeginning(head, 2);
    printLinkedList(head);

    insertAtBeginning(head, 1);
    printLinkedList(head);

    insertAtEnd(head, 4);
    printLinkedList(head);

    insertAtEnd(head, 5);
    printLinkedList(head);

    insertAtIndex(head, 3, 3);
    printLinkedList(head);

    deleteFromBeginning(head);
    printLinkedList(head);

    deleteFromEnd(head);
    printLinkedList(head);

    deleteFromIndex(head, 2);
    printLinkedList(head);

}