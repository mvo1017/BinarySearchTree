public class BinarySearchTree <T extends Comparable<T>>{
    NodeType<T> root;

    /**
     * Initializes the tree.
     */
    public BinarySearchTree() {
        root = null;
    } //constructor

    /**
     * Inserts a node with the value of key into tree.
     * No duplicates allowed.
     * @param key
     */
    public void insert(T key) {

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

    } //getNumLeafNodes

    /**
     * Take in a node as input and print cousins of a given node
     * @param input
     * @return
     */
    public String getCousins(T input) {

    } //getCousins

}
