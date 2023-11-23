Mong Vo
mlv41902@uga.edu

To run the code, please provide a path to the file for the argument. This program only accepts string, double, and integer text files that are space separated (like in the given example files).

Pseudocode + master method analysis

getNumLeafNodes(root)
    if root is null
        return 0
    if root has no left and right child
        return 1
    else
        leftLeaves = getNumLeafNodes(root.left)
        rightLeaves = getNumLeafNodes(root.right)
        return leftLeaves + rightLeaves

This is similar to the code I wrote for inOrder, except it checks for the condition if the node is a leaf (has no right or left child).
Recurrence relation: T(n) = 2T(n/2) + O(1) 
Time complexity: O(n)
--------------------------------------------------------------------------------------------------------------

getSingleParent(root)
    if root is not null
        getSingleParent(root.left)
        
        if (root has exactly one child)
            print root's info
        
        getSingleParent(root.right)

Similar to the code for inOrder, it traverses through the tree and checks for nodes that are single parents (has one child).
Recurrence relation: T(n) = 2T(n/2) + O(1)
Time complexity: O(n)

--------------------------------------------------------------------------------------------------------------

getCousins(input)
    level = findLevel(root, input, 1)
    if level == -1 //it is the root or node not found
        return
    printCousins(root, input, null, level)


findCousins(node, input)
    if node is null
        return

    level = findLevel(root, input, 1)
    if level == -1 //it is the root or node not found
        return
    printCousins(root, input, null, level)

printCousins(node, input, parent, level)
    if node is null or level < 1
        return

    if level == 1 and parent is not null and not isSibling(parent, node, input) and not input node:
        print node.info //cousin gets printed here

    printCousins(node.left, input, node, level - 1)
    printCousins(node.right, input, node, level - 1)

isSibling(parent, node, input)
    //checks to see if this node is a sibling
    return (parent.left == node and parent.right is not null and parent.right.info == input) or 
           (parent.right == node and parent.left is not null and parent.left.info == input)

findLevel(node, input, level)
    if node is null
        return -1
    if node.info == input
        return level

    leftLevel = findLevel(node.left, input, level + 1)
    if leftLevel != -1
        return leftLevel
    return findLevel(node.right, input, level + 1)

Uses several functions to find cousin. Must find level of input node and check all other nodes on that level to print out cousins. Makes sure not to print siblings of node by keeping track of parent node.

getCousins() relies on findLevel() the most. So the recurrence relation for that is : T(n)=T(n−1)+O(1)
Time complexity: O(n)

