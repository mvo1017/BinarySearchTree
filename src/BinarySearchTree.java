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

    } //delete
/**
     * 
     * @param item
     * @return true if item is in tree, else return false.
     */
    public boolean retrieve(T item) {
        boolean retrieve = false;
        return retrieve;
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
