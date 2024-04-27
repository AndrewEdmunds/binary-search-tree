package com.binary_search_tree.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class BinarySearchTree {
    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node root, int value) {
        if (root == null) {
            System.out.println("Creating new node with value: " + value);
            return new Node(value);
        }

        if (value < root.value) {
            System.out.println("Inserting " + value + " to the left of " + root.value);
            root.left = insertRecursive(root.left, value);
        } else if (value > root.value) {
            System.out.println("Inserting " + value + " to the right of " + root.value);
            root.right = insertRecursive(root.right, value);
        }
        System.out.println(root);
        return root;
    }

    public String toJSON() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(root));
            return mapper.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Node {
        private int value;
        private Node left;
        private Node right;
    
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    
        @JsonProperty("value")
        public int getValue() {
            return value;
        }
    
        @JsonProperty("value")
        public void setValue(int value) {
            this.value = value;
        }
    
        @JsonProperty("left")
        public Node getLeft() {
            return left;
        }
    
        @JsonProperty("left")
        public void setLeft(Node left) {
            this.left = left;
        }
    
        @JsonProperty("right")
        public Node getRight() {
            return right;
        }
    
        @JsonProperty("right")
        public void setRight(Node right) {
            this.right = right;
        }
    
        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
