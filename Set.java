import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int d) {
        data = d;
        left = right = null;
    }
}

public class Set {
    TreeNode r; // root is now r

    public TreeNode insert(TreeNode r, int element) {
        if (r == null) return new TreeNode(element);
        if (element < r.data) r.left = insert(r.left, element);
        else if (element > r.data) r.right = insert(r.right, element);
        return r;
    }

    public int inorderSuccessor(TreeNode r) {
        TreeNode t = r; // temp is now t
        while (t.left != null) t = t.left;
        return t.data;
    }

    public TreeNode remove(TreeNode r, int element) {
        if (r == null) return null;
        if (element < r.data) r.left = remove(r.left, element);
        else if (element > r.data) r.right = remove(r.right, element);
        else {
            if (r.left == null) return r.right;
            if (r.right == null) return r.left;
            r.data = inorderSuccessor(r.right);
            r.right = remove(r.right, r.data);
        }
        return r;
    }

    public void print(TreeNode r) {
        if (r == null) return;
        print(r.left);
        System.out.print(r.data + " ");
        print(r.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set set = new Set();
        int option;
 System.out.println("1. Insert\n2. Remove\n3. Print\n4. Exit");
        do {
           
            System.out.print("Option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    set.r = set.insert(set.r, scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter element: ");
                    set.r = set.remove(set.r, scanner.nextInt());
                }
                case 3 -> {
                    set.print(set.r);
                    System.out.println();
                }
            }
        } while (option != 4);

        scanner.close();
    }
}
