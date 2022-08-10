package JGT190002;
// the class deals with operations that is done to the singly linked list
public class SinglyLinkedList<AnyType extends IDedObject> {

    Node<AnyType> head = new Node<>(null); // new object of node called head

    // function that makes list empty
    void makeEmpty() {
        head.next = null; // set head.next to null so the list is empty
    }

    // the function find if an id exists in the list
    AnyType findID(int ID) {
        Node<AnyType> current; // create object node called current

        if (head == null) { // if head is null (list is empty)
            return null; // return null if empty
        } else {
            current = head.next; // set head.next to current
            while (current != null) { // while current does not equal null run the loop
                if (current.data.getID() == ID) { // if the id associated with the current node equals the ID entered by the user
                    return current.data; // return the current.data
                }
                current = current.next; // set current.next to current
            }
        }
        return null;
    }



    // the function inserts the product in front of the singly linked list if it does not already exist in the list
    boolean insertAtFront(AnyType x) {
        Node<AnyType> current; // Node object called current
        current = head.next; // set head dont next to current
        while (current != null) { // run the loop while current does not equal null
            if (current.data.getID() == x.getID()) { // if the the id of in the current node matches the id user entered
                return false; // return false cause product already exists in the list
            }
            current = current.next; // set current.next to current
        }
        Node<AnyType> newNode = new Node<>(x); // create newNOde object with the product object passed by user with id name and supplier
        newNode.next = head.next; // set head.next to newNode.next to connect the element to new list
        head.next = newNode; // set the head to point at the new element
        return true; // return true
    }

    // function that deletes elements from the front
    AnyType deleteFromFront() {
        Node<AnyType> current; // object of Node current
        if (head.next == null) { // if head.next is null return null cause list empty
            return null;
        } else {
            current = head.next; // set current to head.next
            head.next = current.next; // set current.next to head.next
            return current.data; // return current.data which holds the data for the deleted item
        }
    }


    // deletes the product associated with the Id enterd by the user
    AnyType delete(int ID) {
        AnyType deletedProduct; // anytype datatype deletproduct which holds info of the deleted element
        Node<AnyType> current; // object of Node current
        current = head; // set head to current
        while (current.next != null) { // while the current is not null / end of list
            if (current.next.data.getID() == ID) { // if the user entered ID equals to an ID in the list
                deletedProduct = current.next.data; // set the data in the current node to the deletedProduct
                current.next = current.next.next; // set the current.next.next to current.next
                return deletedProduct; // return the deleted item
            }
            current = current.next; // set current.next to current
        }
        return null; // return null if does not exsist
    }
/*
    // deletes the product associated with the Id enterd by the user
    AnyType delete(int ID) {
        AnyType deletedProduct; // anytype datatype deletproduct which holds info of the deleted element
        Node<AnyType> current; // object of Node current
        current = head; // set head to current
        while (current != null) { // while the current is not null / end of list
            if (current.next.data.getID() == ID) { // if the user entered ID equals to an ID in the list
                deletedProduct = current.next.data; // set the data in the current node to the deletedProduct
                current.next = current.next.next; // set the current.next.next to current.next
                return deletedProduct; // return the deleted item
            }
            current = current.next; // set current.next to current
        }
        return null; // return null if does not exsist
    }

 */

    // prints all the elements in the list, if empty prints list empty
    void printAllRecords() {
        Node<AnyType> current; // create a node object current to represent current node
        if(head.next == null){ // if head.next is null it means list is empty
            System.out.println("The list is empty");
        } else{
            System.out.println("The items on the list are: "); // if list is not empty
            System.out.println();
        }
        current = head.next; // set current to head.next
        while(current != null){ // while the current is not null run the loop
            current.data.printID(); // print the data associated with current node
            System.out.println();
            current = current.next; // set current to current.next
        }
    }

    // checks if list is empty
    boolean isListEmpty() {
        if (head.next == null) { // if head.next is null means its empty otherwise its not empty
            return true; // if list empty
        } else {
            return false; // if list does exsist
        }
    }


}
