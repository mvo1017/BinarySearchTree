#! /bin/bash
echo "executing script commands..."
 javac -d bin src/NodeType.java 
 javac -d bin -cp bin src/BinarySearchTree.java
 javac -d bin -cp bin src/BinarySearchTreeDriver.java
