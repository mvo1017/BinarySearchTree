public class BinarySearchTree <T extends Comparable<T>>{
    public NodeType<T> root;

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
    public NodeType<T> delete(NodeType<T> start, T key) {

        
        boolean present = true;

        //find the node to delete
        
            if (start == null) {
                return start;
            }
            if (key.compareTo(start.info) > 0) { //navigate right
                start.right = delete(start.right, key);
            } else if (key.compareTo(start.info) < 0) { //navigate left
                start.left = delete(start.left, key);
            } else {
                //duplicate found! current node is one to delete
                if (start.left == null && start.right ==  null) {
                    //delete leaf node
                    start = null;
                } else if (start.left != null && start.right == null) {
                    start.info = start.left.info;
                    start.left = null;
                } else if (start.left == null && start.right != null) {
                    start.info = start.right.info;
                    start.right = null;
                } else if (start.right != null) { 
                    //has a child on right
                    start.info = successor(start); 
                    start.right = delete(start.right, start.info);
                } else { 
                    start.info = predecessor(start);
                    start.left = delete(start.left, start.info);
                }
            }
        
        return start;
    } //delete

    
    /**
     * Return node's successor value
     * @param root
     * @return
     */
    public T successor(NodeType<T> root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.info;
    }
    /**
     * Return node's predecessor value
     * @param root
     * @return
     */
    public T predecessor(NodeType<T> root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.info;
    }

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
    public String inOrder(NodeType<?> node) {
        String s = "";
        if (node != null) {
            s += inOrder(node.left);
            s += node.info + " ";
            s += inOrder(node.right);
        }
        return s;
    } //inOrder

    /**
     * Returns the nodes that have only one child.
     */
    public void getSingleParent(NodeType<?> root) {
        //traverses through tree and checks for single parent
        if (root != null) {
            getSingleParent(root.left);

            if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
                System.out.print(root.info + " ");
            }
    
            getSingleParent(root.right);
        }
    } //getSingleParent

    /**
     * Return the count of the number of leaf nodes (nodes with no child)
     */
    public int getNumLeafNodes(NodeType<?> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // Node is a leaf node
            return 1;
        } else {
            // Recursively count leaf nodes in left and right subtrees
            int leftLeaves = getNumLeafNodes(root.left);
            int rightLeaves = getNumLeafNodes(root.right);
            return leftLeaves + rightLeaves;
        }
    } //getNumLeafNodes

    /**
     * Take in a node as input and print cousins of it
     * @param input
     * @return
     */
    public void getCousins(T input) {
        findCousins(root, input);
    }
    /**
     * Finds the level of a given node in the tree.
     * 
     * @param node 
     * @param input
     * @param level 
     * @return 
     */
    public void findCousins(NodeType<T> node, T input) {
        if (node == null) {
            return;
        }

        int level = findLevel(root, input, 1);
        if (level == -1) {
            return;
        }

        printCousins(root, input, null, level);
    }
    
     /**
     * Prints cousins of a given node at a specific level.
     * 
     * @param node  
     * @param input 
     * @param parent
     * @param level 
     */
    public void printCousins(NodeType<T> node, T input, NodeType<T> parent, int level) {
        if (node == null || level < 1) {
            return;
        }

        if (level == 1 && parent != null && !isSibling(parent, node, input) && !node.info.equals(input)) {
            System.out.print(node.info + " "); //prints cousins here
        }

        //continue traversing
        printCousins(node.left, input, node, level - 1); 
        printCousins(node.right, input, node, level - 1);
    }
    /**
     * Checks if the given node is a sibling
     * @param node
     * @param input
     * @return
     */
    public boolean isSibling(NodeType<T> parent, NodeType<T> node, T input) {
        return (parent.left == node && parent.right != null && parent.right.info.equals(input)) ||
        (parent.right == node && parent.left != null && parent.left.info.equals(input));
    }
    /**
     * Finds level of given node
     * @param node
     * @param value
     * @param level
     * @return
     */
    public int findLevel(NodeType<T> node, T input, int level) {
        if (node == null) {
            return -1;
        }
        if (node.info.equals(input)) {
            return level;
        }

        int leftLevel = findLevel(node.left, input, level + 1);
        if (leftLevel != -1) {
            return leftLevel;
        }
        return findLevel(node.right, input, level + 1);
    }

}
