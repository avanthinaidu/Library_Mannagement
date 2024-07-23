import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Student {
    String name;
    int id_no;
    String stream;
    String book1, book2;
    int book_no, issuedbook;

    Student(String name, int id_no, String stream) {
        this.name = name;
        this.id_no = id_no;
        this.stream = stream;
        this.book_no = 0;
        this.issuedbook = 0;
        this.book1 = null;
        this.book2 = null;
    }
}

class Node {
    String key;
    Node left, right;

    public Node(String item) {
        key = item;
        left = right = null;
    }
}

class FinalDSA {
    Node root;
    private static Scanner input;

    FinalDSA() {
        root = null;
    }

    void insert(String key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, String key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.compareTo(root.key) < 0) 
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.key) > 0) 
            root.right = insertRec(root.right, key);
        else
            System.out.println("Error: Duplicate entry");

        return root;
    }

    void update(String key, String key1) {
        deleteKey(key);
        insert(key1);
    }

    public boolean containsNode(String value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, String key) {
        if (current == null) {
            return false;
        }
        if (key.equalsIgnoreCase(current.key)) {
            return true;
        }
        return key.compareTo(current.key) < 0 ? containsNodeRecursive(current.left, key)
                : containsNodeRecursive(current.right, key);
    }

    void printTree() {
        root = printTreeRec(root, 0);
    }

    Node printTreeRec(Node t, int space) {
        if (t == null)
            return root;

        space += 5;
        printTreeRec(t.right, space);

        System.out.println();
        for (int i = 5; i < space; i++)
            System.out.print(" ");
        System.out.print("[" + t.key + "]");

        return printTreeRec(t.left, space);
    }

    void deleteKey(String key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, String key) {
        if (root == null)
            return root;

        if (key.compareTo(root.key) < 0)
            root.left = deleteRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    String minValue(Node root) {
        String minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    void printInorder() {
        printInorder(root);
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}

 class LibraryManagement {

    static void selectionSort(Student arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j].id_no < arr[min_idx].id_no)
                    min_idx = j;

            Student temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    static void display(Student arr[]) {
        for (Student student : arr) {
            System.out.println("\nName of Student: " + student.name);
            System.out.println("Id of Student: " + student.id_no);
            System.out.println("Stream of Student: " + student.stream);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        FinalDSA tree = new FinalDSA();
        HashMap<String, Integer> hashmapping = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Student[] array = new Student[3];

        array[0] = new Student("Avanthi", 21, "B.Tech-IT");
        array[1] = new Student("Jyothi", 22, "B.Tech-IT");
        array[2] = new Student("Ramya", 23, "B.Tech-IT");

        int[][] arr = new int[100][2];

        FileWriter fr = new FileWriter("append.txt", true);
        BufferedWriter br = new BufferedWriter(fr);

        FileReader file = new FileReader("x.txt");
        BufferedReader reader = new BufferedReader(file);

        FileReader file2 = new FileReader("y.txt");
        BufferedReader reader2 = new BufferedReader(file2);

        FileReader file3 = new FileReader("z.txt");
        BufferedReader reader3 = new BufferedReader(file3);

        Date Rday1 = null, Rday2 = null, Cday = null;
        boolean e1 = false;

        int i = 0;

        while (e1 == false) {
            System.out.println("\n.....................................");
            System.out.println("1. Librarian Login.");
            System.out.println("2. User Login.");
            System.out.println("3. Exit.");
            System.out.println("\n.....................................");

            System.out.println("\nEnter Your choice:");
            int ch1 = input.nextInt();

            switch (ch1) {
                case 1: // For Librarian login
                    String pwd1 = "abc123";
                    String id1 = "dsa@1";

                    System.out.println("\nEnter UserId:");
                    String id2 = input.next();

                    System.out.println("\nEnter Password:");
                    String pwd2 = input.next();

                    if (!id1.equals(id2))
                        System.out.println("Invalid Userid.");
                    else if (!pwd1.equals(pwd2))
                        System.out.println("Invalid Password.");
                    else {
                        System.out.println("Login successfully.");
                        boolean e2 = false;
                        while (e2 == false) {
                            System.out.println("\n.....................................");
                            System.out.println("1. Add book.");
                            System.out.println("2. Delete book.");
                            System.out.println("3. Update book.");
                            System.out.println("4. Print Books Details.");
                            System.out.println("5. Print Books in-order.");
                            System.out.println("6. Print tree");
                            System.out.println("7. Exit");

                            System.out.println("\n.....................................");

                            System.out.println("\nEnter Your choice:");
                            int ch2 = input.nextInt();

                            switch (ch2) {
                                case 1: // To add a book
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        tree.insert(line);
                                        hashmapping.put(line, i);
                                        i++;
                                    }
                                    int j = i;

                                    int o = 0;
                                    String number;
                                    while ((number = reader2.readLine()) != null) {
                                        int result = Integer.parseInt(number);
                                        if (j != o)
                                            arr[o][0] = result;
                                        o++;
                                    }

                                    int pq = 0;
                                    String number1;
                                    while ((number1 = reader3.readLine()) != null) {
                                        int result1 = Integer.parseInt(number1);
                                        if (pq != j)
                                            arr[pq][1] = result1;
                                        pq++;
                                    }

                                    for (Entry<String, Integer> entry : hashmapping.entrySet()) {
                                        String key = entry.getKey();
                                        Integer value = entry.getValue();

                                        System.out.println("Name: " + key + " Copies Available: " + arr[value][0]
                                                + " Price: " + arr[value][1]);
                                    }

                                    System.out.println("File has been inserted successfully.");
                                    break;

                                case 2: // To delete a book
                                    System.out.println("Enter name of book to be deleted:");
                                    String bk = input.next();
                                    tree.deleteKey(bk);
                                    System.out.println("The book deleted successfully.");
                                    break;

                                case 3: // To update a book
                                    System.out.println("Enter name of book to be updated:");
                                    String k1 = input.next();
                                    System.out.println("Enter new book name:");
                                    String k2 = input.next();
                                    tree.update(k1, k2);
                                    System.out.println("Book updated successfully.");
                                    break;

                                case 4: // Print Books Details
                                    for (Entry<String, Integer> entry : hashmapping.entrySet()) {
                                        String key = entry.getKey();
                                        Integer value = entry.getValue();

                                        System.out.println("Name: " + key + " Copies Available: " + arr[value][0]
                                                + " Price: " + arr[value][1]);
                                    }
                                    break;

                                case 5: // Print Books in-order
                                    System.out.println("Inorder traversal:");
                                    tree.printInorder();
                                    break;

                                case 6: // Print tree
                                    System.out.println("Printing tree:");
                                    tree.printTree();
                                    break;

                                case 7: // Exit
                                    e2 = true;
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                        }
                    }
                    break;

                case 2: // For User login
                    boolean e3 = false;
                    while (e3 == false) {
                        System.out.println("\n.....................................");
                        System.out.println("1. Book Issue.");
                        System.out.println("2. Book Return.");
                        System.out.println("3. Book Details.");
                        System.out.println("4. Book Issue History.");
                        System.out.println("5. Exit.");

                        System.out.println("\n.....................................");

                        System.out.println("\nEnter Your choice:");
                        int ch3 = input.nextInt();

                        switch (ch3) {
                            case 1: // For Book Issue
                                System.out.println("Enter your ID:");
                                int id = input.nextInt();

                                Student currentStudent = null;
                                for (Student student : array) {
                                    if (student.id_no == id) {
                                        currentStudent = student;
                                        break;
                                    }
                                }

                                if (currentStudent == null) {
                                    System.out.println("Invalid ID.");
                                    break;
                                }

                                System.out.println("Enter name of book to be issued:");
                                String bookName = input.next();

                                if (currentStudent.book_no >= 2) {
                                    System.out.println("You have already issued maximum number of books.");
                                    break;
                                }

                                if (!tree.containsNode(bookName)) {
                                    System.out.println("Book not available.");
                                    break;
                                }

                                if (currentStudent.book_no == 0) {
                                    currentStudent.book1 = bookName;
                                    currentStudent.book_no++;
                                } else if (currentStudent.book_no == 1) {
                                    currentStudent.book2 = bookName;
                                    currentStudent.book_no++;
                                }

                                System.out.println("Book issued successfully.");
                                break;

                            case 2: // For Book Return
                                System.out.println("Enter your ID:");
                                int returnId = input.nextInt();

                                Student returnStudent = null;
                                for (Student student : array) {
                                    if (student.id_no == returnId) {
                                        returnStudent = student;
                                        break;
                                    }
                                }

                                if (returnStudent == null) {
                                    System.out.println("Invalid ID.");
                                    break;
                                }

                                System.out.println("Enter name of book to be returned:");
                                String returnBookName = input.next();

                                if (returnBookName.equals(returnStudent.book1)) {
                                    returnStudent.book1 = null;
                                    returnStudent.book_no--;
                                } else if (returnBookName.equals(returnStudent.book2)) {
                                    returnStudent.book2 = null;
                                    returnStudent.book_no--;
                                } else {
                                    System.out.println("You have not issued this book.");
                                    break;
                                }

                                System.out.println("Book returned successfully.");
                                break;

                            case 3: // For Book Details
                                System.out.println("Enter your ID:");
                                int detailId = input.nextInt();

                                Student detailStudent = null;
                                for (Student student : array) {
                                    if (student.id_no == detailId) {
                                        detailStudent = student;
                                        break;
                                    }
                                }

                                if (detailStudent == null) {
                                    System.out.println("Invalid ID.");
                                    break;
                                }

                                System.out.println("Name: " + detailStudent.name);
                                System.out.println("ID: " + detailStudent.id_no);
                                System.out.println("Stream: " + detailStudent.stream);
                                System.out.println("Books issued: " + detailStudent.book_no);
                                if (detailStudent.book1 != null) {
                                    System.out.println("Book 1: " + detailStudent.book1);
                                }
                                if (detailStudent.book2 != null) {
                                    System.out.println("Book 2: " + detailStudent.book2);
                                }
                                break;

                            case 4: // For Book Issue History
                                System.out.println("Enter your ID:");
                                int historyId = input.nextInt();

                                Student historyStudent = null;
                                for (Student student : array) {
                                    if (student.id_no == historyId) {
                                        historyStudent = student;
                                        break;
                                    }
                                }

                                if (historyStudent == null) {
                                    System.out.println("Invalid ID.");
                                    break;
                                }

                                System.out.println("Books issued history:");
                                if (historyStudent.book1 != null) {
                                    System.out.println("Book 1: " + historyStudent.book1);
                                }
                                if (historyStudent.book2 != null) {
                                    System.out.println("Book 2: " + historyStudent.book2);
                                }
                                break;

                            case 5: // Exit
                                e3 = true;
                                break;

                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                    break;

                case 3: // Exit
                    e1 = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        input.close();
        reader.close();
        reader2.close();
        reader3.close();
        br.close();
    }
}
