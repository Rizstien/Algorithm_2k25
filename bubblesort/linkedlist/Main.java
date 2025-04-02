package bubblesort.linkedlist;

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

    // Function to add a new node at the end
    void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(4);
        list.append(2);
        list.append(1);
        list.append(3);
        list.append(5);

        System.out.println("Before Sorting:");
        list.printList();

        list.bubbleSort();

        System.out.println("After Sorting:");
        list.printList();
    }

    private void bubbleSort() {
        if(head == null || head.next ==null) return;

        boolean swapped = false;
        Node ptr = head;
        Node last = null;

        do{
            swapped = false;
            ptr = head;
            while(ptr.next != last){
                if(ptr.data > ptr.next.data){
                    int temp = ptr.data;
                    ptr.data = ptr.next.data;
                    ptr.next.data = temp;
                    swapped = true;
                }
                ptr = ptr.next;
            }
            last = ptr;
        }while(swapped);
    }

}

