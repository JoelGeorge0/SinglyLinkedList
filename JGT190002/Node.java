package JGT190002;

// Node class for the liked list of type AnyType
public class Node <AnyType>{
    // attributes of NODE
    AnyType data;
    Node<AnyType> next;
    // constructor that takes in the data
    Node(AnyType data){
        this.data = data;
        this.next = null;
    }
}
