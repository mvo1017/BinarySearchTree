public class BinarySearchTree <T extends Comparable<T>>{
    NodeType<T> root;

    /**
     * Initializes the tree.
     */
    public BinarySearchTree() {
        root = new NodeType<>();
        root = null;
    } //constructor

    /**
     * Inserts a node with the value of key into tree.
     * No duplicates allowed.
     * @param key
     */
    public void insert(T key) {
        NodeType<T> insert = new NodeType<>();
        insert.info = key;
        NodeType<T> current = new NodeType<>();
        current = root;
        if (root == null) {
            root = insert;
        } else {

            boolean inserted = false;
            boolean duplicateFound = false;

            while (!inserted && !duplicateFound) {
                if (key.compareTo(current.info) > 0) {
                    if (current.right == null) {
                        current.right = insert;
                        inserted = true;
                    } else {
                        current = current.right;
                    }
                } else if (key.compareTo(current.info) < 0) {
                    if (current.left == null) {
                        current.left = insert;
                        inserted = true;
                    } else {
                        current = current.left;
                    }
                } else {
                    duplicateFound = true;
                }
            }

            if (duplicateFound) {
                System.out.println("The item already exists in the tree.");
            }
        }
    } //insert

    /**
     * Remove a node with a key value equal to the
     * parameter key’s value otherwise leave the tree unchanged (if the key
     * is not present). In situations, where the node to be deleted has two
     * children, replace the deleted node with its immediate predecessor or
     * successor.
     *  @param key
     */
    public void delete(T key) {

        NodeType<T> current = root;
        NodeType<T> delete;
        boolean found = false;
        boolean present = true;

        //find the node to delete
        while (!found && present) {
            if (key.compareTo(current.info) > 0) { //navigate right
                if (current.right == null) {
                    present = false;
                } else {
                    current = current.right;
                }
            } else if (key.compareTo(current.info) < 0) { //navigate left
                if (current.left == null) {
                    present = false;
                } else {
                    current = current.left;
                }
            } else {
                found = true; //duplicate found! current node is one to delete
            }
        }

        if (found) {
            
            if (current.left == null && current.right ==  null) {
                //delete leaf node
                current = null;
            } else if (current.left != null && current.right == null) {
                //delete node with one child
                current = current.left;
                current.left = null;
            } else if (current.left == null && current.right != null) {
                //delete node with one child
                current = current.right;
                current.right = null;
            } else if (current.left != null && current.right != null) {
                //delete node with two children
                NodeType<T> temp = current;
                temp = temp.right;
                while (temp.left != null) {
                    temp = temp.left;
                }

                current.info = temp.info;
                if (temp.right != null) {
                    temp = temp.right; //if node to delete has child(ren) on right
                } else {
                    temp = null;
                }
            }
        }



    } //delete
/**
     * 
     * @param item
     * @return true if item is in tree, else return false.
     */
    public boolean retrieve(T item) {
        NodeType<T> current = root;
        boolean found = false;

         while (!found) {
            if (item.compareTo(current.info) > 0) { //navigate right
                if (current.right == null) {
                    break;
                } else {
                    current = current.right;
                }
            } else if (item.compareTo(current.info) < 0) { //navigate left
                if (current.left == null) {
                    break;
                } else {
                    current = current.left;
                }
            } else {
                found = true; 
            }
        }

        return found;
    } //retrieve

    /**
     * Return the tree in order.
     */
    public void inOrder() {

    } //inOrder

    /**
     * Returns the nodes that have only one child.
     */
    public void getSingleParent() {

    } //getSingleParent

    /**
     * Return the count of the number of leaf nodes (nodes with no child)
     */
    public int getNumLeafNodes() {
        int num = 0;
        return num;
    } //getNumLeafNodes

    /**
     * Take in a node as input and print cousins of
     * @param input
     * @return
     */
    public String getCousins(T input) {
        String s = "";
        return s;
    } //getCousins

}
