import java.util.Scanner;

public class Queue {
    int[] arr = new int[10];
    int front = -1, rear = -1;

    public void enqueue(int element) {
        if (rear == arr.length - 1) {
            System.out.println("Queue is full");
        } else {
            arr[++rear] = element;
        }
    }

    public void dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Dequeued: " + arr[++front]);
        }
    }

    public void print() {
        if (front == rear) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front + 1; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue q = new Queue();
        int option;
        System.out.println("1. Enqueue\n2. Dequeue\n3. Print\n4. Exit");

        do {
            
            System.out.print("Enter option: ");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter element: ");
                    q.enqueue(scan.nextInt());
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.print();
                    break;
            }
        } while (option != 4);

        scan.close();
    }
}