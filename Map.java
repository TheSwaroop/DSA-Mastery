import java.util.Scanner;

class HashNode {
    int key, value;
    HashNode next;

    HashNode(int k, int v) {
        key = k;
        value = v;
        next = null;
    }
}

public class Map {
    HashNode[] ht = new HashNode[10]; // Initialize hash table

    public int hash(int key) {
        return key % 10;
    }

    public void insert(int key, int value) {
        int index = hash(key);
        HashNode t = ht[index]; // temp -> t
        if (t == null) {
            ht[index] = new HashNode(key, value);
        } else {
            while (t.next != null) t = t.next;
            t.next = new HashNode(key, value);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        HashNode t = ht[index];
        if (t == null) {
            System.out.println("Key not found");
            return;
        }
        if (t.key == key) {
            ht[index] = t.next;
        } else {
            while (t.next != null && t.next.key != key) t = t.next;
            if (t.next != null) t.next = t.next.next;
            else System.out.println("Key not found");
        }
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ":\t");
            for (HashNode t = ht[i]; t != null; t = t.next) {
                System.out.print("(" + t.key + ", " + t.value + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map map = new Map();
        int option;

        do {
            System.out.println("1. Insert\n2. Remove\n3. Print\n4. Exit");
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.print("Enter key: ");
                    int key = scanner.nextInt();
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    map.insert(key, value);
                }
                case 2 -> {
                    System.out.print("Enter key: ");
                    int key = scanner.nextInt();
                    map.remove(key);
                }
                case 3 -> map.print();
            }
        } while (option != 4);

        scanner.close();
    }
}