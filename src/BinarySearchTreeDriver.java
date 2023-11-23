import java.util.Scanner;

import javax.xml.namespace.QName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearchTreeDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        String listType = scanner.nextLine();

             // throws an error if anything other than one path to a file was inputted
             if (args.length != 1) {
                System.err.println("Please try again");
                System.exit(0);
    
            } //if
    
            //initializing trees
            BinarySearchTree<String> stringTree = new BinarySearchTree<>();
            BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
            BinarySearchTree<Double> doubleTree = new BinarySearchTree<>();

            BinarySearchTree<?> bst = new BinarySearchTree<>();
    
            //importing the file
            String file = args[0];
            
            try {BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {

                if (listType.equals("i")) {
                    String[] numbers = line.split(" ");
        
                    for (int i = 0; i < numbers.length; i++) {
                        int num = Integer.parseInt(numbers[i]);
                        intTree.insert(num);        
                    } //for
                    bst = intTree;
                } else if (listType.equals("d")) {
                    String[] numbers = line.split(" ");
        
                    for (int i = 0; i < numbers.length; i++) {
                        double dub = Double.parseDouble(numbers[i]);
                        doubleTree.insert(dub);        
                    } //for
                    bst = doubleTree;
                } else if (listType.equals("d")) {
                    String[] numbers = line.split(" ");
        
                    for (int i = 0; i < numbers.length; i++) {
                        String s = numbers[i];
                        stringTree.insert(s);
                    } //for
                    bst = stringTree;
                } //if else

            } //while

        } catch (IOException e) {
            System.err.println("Error with file input. Please try again.");
            System.exit(0);
        }

        System.out.println("Commands:\n(i) - Insert Item\n(d) - Delete Item \n(p) - Print Tree\n(r) - Retrieve Item\n(l) - Count Leaf Nodes\n(s) - Find Single Parents\n(c) - Find Cousins\n(q) - Quit program");

        boolean running = true;
        while (running) {
            System.out.print("Enter a command: ");
            String command = scanner.next();

            if (command.equals("i")) {

                if (listType.equals("i")) {
                    System.out.print("Enter a number to insert: ");
                    int insert = scanner.nextInt();
                    intTree.insert(insert);
                    bst = intTree;
                } //int tree
                else if (listType.equals("d")) {
                    System.out.print("Enter a number to insert: ");
                    double insert = scanner.nextDouble();
                    doubleTree.insert(insert);
                    bst = doubleTree;
                } //double tree
                else if (listType.equals("s")){
                    System.out.print("Enter a string to insert: ");
                    String insert = scanner.nextLine();
                    stringTree.insert(insert);
                    bst = stringTree;
                } //string tree

            } //insert

            if (command.equals("d")) {
                if (listType.equals("i")) {
                    System.out.print("Enter a number to delete: ");
                    int delete = scanner.nextInt();
                    intTree.delete(delete);
                    bst = intTree;
                } //int tree
                else if (listType.equals("d")) {
                    System.out.print("Enter a number to delete: ");
                    double delete = scanner.nextDouble();
                    doubleTree.delete(delete);
                    bst = doubleTree;
                } //double tree
                else if (listType.equals("s")){
                    System.out.print("Enter a string to delete: ");
                    String delete = scanner.nextLine();
                    stringTree.delete(delete);
                    bst = stringTree;
                } //string tree
            } //delete

            if (command.equals("q")) {
                System.out.println("Exiting the program...");
                running = false;
            } //quit program

        } //while
    } //main
} //class
