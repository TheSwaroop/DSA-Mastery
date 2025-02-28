import java.util.Scanner;

class Node {
    int data; // Data part of the node
    Node next; // Pointer to the next node

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head; // Head (first node) of the linked list

    // Method to insert a new node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to delete a node by value
    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value not found");
        } else {
            temp.next = temp.next.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node");
            System.out.println("2. Delete a node");
            System.out.println("3. Display the list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int valueToInsert = scanner.nextInt();
                    list.insert(valueToInsert);
                    System.out.println("Value inserted.");
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    int valueToDelete = scanner.nextInt();
                    list.delete(valueToDelete);
                    System.out.println("Delete operation completed.");
                    break;
                case 3:
                    System.out.println("Linked List:");
                    list.display();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
